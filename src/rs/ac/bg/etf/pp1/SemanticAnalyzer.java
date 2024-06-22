package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class SemanticAnalyzer extends VisitorAdaptor {
	
	private boolean errorDetected = false;
	
	Logger log = Logger.getLogger(getClass());

	private Obj currentProgram;

	private Struct currentType;

	private int constant;

	private Struct constantType;
	
	private Struct boolType = Tab.find("bool").getType();

	private Obj mainMethod;

	private Obj currentMethod;

	private boolean returnHappened = false;
	
	private int loopCounter = 0;

	int nVars;

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" on the line: ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" on the line: ").append(line);
		log.info(msg.toString());
	}
	
	
	public boolean passed() {
		return !errorDetected;
	}
	
	
	// Analyzer code
	
	@Override
	public void visit(ProgramName ProgramName) {
		currentProgram = Tab.insert(Obj.Prog, ProgramName.getI1(), Tab.noType);
		Tab.openScope(); //Opening global scope
		
		
	}
	
	@Override
	public void visit(Program program) {
		
		//getting global variables
		
		this.nVars = Tab.currentScope().getnVars(); //counts just global variables
		
		Tab.chainLocalSymbols(currentProgram);
		Tab.closeScope(); //closing global scope
		currentProgram = null;
		
		if(mainMethod == null || mainMethod.getLevel() > 0) 
			report_error("Program nema adekvatnu main metodu!", program);

		// With this level checking for main method it is ensured that it must not have any formal parameters
		
	}
	
	
	// Const declarations
	
	@Override
	public void visit(ConDecl conDecl) {
		
		Obj conObj = null;
		
		
			 conObj = Tab.find(conDecl.getI1());


		
		if (conObj != Tab.noObj && conObj != null) {
			report_error("Dvostruka definicija konstante: " + conDecl.getI1(), conDecl);
		}
		else {
			if(constantType.assignableTo(currentType)) {
				
			
					conObj = Tab.insert(Obj.Con, conDecl.getI1(), currentType);
				
				conObj.setAdr(constant);
				
			}
			else {
				report_error("Neadekvatna dodela konstanti: " + conDecl.getI1(), conDecl);
			}
	
		}
	}
	
	@Override
	public void visit(Constant_Number constant_number) {
		constant = constant_number.getN1();
		constantType = Tab.intType;
	}
	
	@Override
	public void visit(Constant_Char constant_char) {
		constant = constant_char.getC1();
		constantType = Tab.charType;
	}
	
	@Override
	public void visit(Constant_Bool constant_bool) {
		constant = constant_bool.getB1();
		constantType = boolType;
	}
	
	
	// variable declarations
	
	// if a global variable node is visited currentMethod is null but for local variables it will have a object node of a method for which it is defined
	@Override
	public void visit(VarDecl_Var varDecl_var) {
		
		
		
		Obj varObj = null;
		
		
		
		if(currentMethod == null) 
			varObj = Tab.find(varDecl_var.getI1());

		else 
			varObj = Tab.currentScope().findSymbol(varDecl_var.getI1());

		if (varObj ==null || varObj == Tab.noObj) {
				varObj = Tab.insert(Obj.Var, varDecl_var.getI1(), currentType);	


		}
		else
			report_error("Dvostruka definicija promenjive: " + varDecl_var.getI1(), varDecl_var);

				
			
	}
	
	@Override
	public void visit(VarDecl_Array varDecl_array) {
		
		Obj varObj = null;
		
		
		
		if(currentMethod == null) 
			varObj = Tab.find(varDecl_array.getI1());

		else 
			varObj = Tab.currentScope().findSymbol(varDecl_array.getI1());

		if (varObj ==null || varObj == Tab.noObj) {
		
				 varObj = Tab.insert(Obj.Var, varDecl_array.getI1(), new Struct(Struct.Array, currentType));	

		}
		else
			report_error("Dvostruka definicija promenjive: " + varDecl_array.getI1(), varDecl_array);
		
	}
	
	// method declarations
	
	@Override
	public void visit (MethodReturnAndName_type methodReturnAndName_type) {
		
		String methName = methodReturnAndName_type.getI2();
		
		
		methodReturnAndName_type.obj = currentMethod = Tab.insert(Obj.Meth, methName, currentType );
		Tab.openScope();
		
	}
	
	@Override
	public void visit (MethodReturnAndName_void methodReturnAndName_void) {
		
		String methName = methodReturnAndName_void.getI1();
		
		
		methodReturnAndName_void.obj = currentMethod = Tab.insert(Obj.Meth, methName, Tab.noType );
		
		if (methodReturnAndName_void.getI1().equalsIgnoreCase("main")) //main can be written as maiN, it is not case sensitive
			mainMethod = currentMethod;
		Tab.openScope();
	}
	
	@Override 
	public void visit (MethodDecl methodDecl)  {
		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		
		if(currentMethod.getType() != Tab.noType && !returnHappened) {
			report_error("Ne postoji iskaz return u okviru metode: " + currentMethod.getName(), methodDecl);
		}
		
		currentMethod = null;
		returnHappened = false;

	}
	
	//Form par declarations
	
	public void visit(FormPar_Var formPar_var) {
		
		Obj formParObj = null;
		
		if(currentMethod == null) 
			report_error("Semanticka greska. [FormPar_Var]" , formPar_var);

		else 
			formParObj = Tab.currentScope().findSymbol(formPar_var.getI2());

		if (formParObj ==null || formParObj == Tab.noObj)  {
			
			String formParName = formPar_var.getI2();
			
			formParObj = Tab.insert(Obj.Var, formParName, currentType);	
			formParObj.setFpPos(1);
			currentMethod.setLevel(currentMethod.getLevel()+1);
			
		}
		else
			report_error("Dvostruka definicija formalnog parametra: " + formPar_var.getI2(), formPar_var);
	
	}
	
	public void visit(FormPar_Array formPar_array) {
		
		Obj formParObj = null;
		
		if(currentMethod == null) 
			report_error("Semanticka greska. [FormPar_Var]" , formPar_array);

		else 
			formParObj = Tab.currentScope().findSymbol(formPar_array.getI2());

		if (formParObj ==null || formParObj == Tab.noObj) {
			
			
			String formParName = formPar_array.getI2();
			
			formParObj = Tab.insert(Obj.Var, formParName, new Struct(Struct.Array, currentType));	
			formParObj.setFpPos(1);
			currentMethod.setLevel(currentMethod.getLevel()+1);
		}

		else
			report_error("Dvostruka definicija nizovskog formalnog parametra: " + formPar_array.getI2(), formPar_array);
	
	}
	
	
	
	@Override
	public void visit(Type type) {
		Obj typeRegularObj = Tab.find(type.getI1());
		if(typeRegularObj == Tab.noObj) {
			report_error("Nepostojeci tip podatka: " + type.getI1() , type); 
			type.struct = currentType = Tab.noType;
			
		}
		else if (typeRegularObj.getKind() != Obj.Type) {
			report_error("Neadekvatan tip podatka" + type.getI1() , type);
			type.struct = currentType = Tab.noType;
		}
		else 
			type.struct = currentType = typeRegularObj.getType();

		
	}
	
	
	//=============================================================================================================
	// Context conditions
	//=============================================================================================================
	
	//Factor_designator_body
	
	@Override
	public void visit (Factor_Designator_Char factor_Designator_Char) {
		factor_Designator_Char.struct = Tab.charType;
	}
	
	@Override
	public void visit (Factor_Designator_Num factor_Designator_Num) {
		factor_Designator_Num.struct = Tab.intType;
	}
	
	@Override
	public void visit (Factor_Designator_BOOL factor_Designator_BOOL) {
		factor_Designator_BOOL.struct = boolType;
	}
	
	
	@Override
	public void visit (Factor_Designator_Expr factor_Designator_Expr) {
		factor_Designator_Expr.struct = factor_Designator_Expr.getExpr().struct;
	}
	
	@Override
	public void visit (Factor_Designator_Var factor_Designator_Var) {
		factor_Designator_Var.struct = factor_Designator_Var.getDesignator().obj.getType();
	}
	
	
	//Factor
	@Override
	public void visit(Factor factor) {
		if(factor.getUnary() instanceof Unary_minus) {
			if(factor.getFactorBody().struct.equals(Tab.intType)) 
				factor.struct = Tab.intType;
			else {
				report_error("Negacija tipa koja nije int", factor);
				factor.struct = Tab.noType;
			}
				
		}
		else
			factor.struct = factor.getFactorBody().struct;
	}
	
	//Designator
	
	@Override
	public void visit(Designator_Var designator_Var) {
		
		String varName =designator_Var.getI1();
		Obj varObj = Tab.find(varName);
		
		if(varObj == Tab.noObj) {
			report_error("Pristup nedefinisanoj promenjivoj: " + varName, designator_Var);
			designator_Var.obj = Tab.noObj; 
		    }
		else if (varObj.getKind() != Obj.Var && varObj.getKind()!= Obj.Con && varObj.getKind()!= Obj.Meth) 
			report_error("Pristup neadekvatnoj promenjivoj: " + varName, designator_Var);
		else {
			designator_Var.obj = varObj;
			//report_info("Symbol access: " + designator_Var.getI1(), designator_Var);
		}		
		
	}
	
	
	
	@Override
	public void visit(DesignatorArrayName designatorArrayName) {
		String arrName = designatorArrayName.getI1();

		Obj arrObj = Tab.find(arrName);
		
		
		if(arrObj == Tab.noObj) {
			report_error("Pristup nedefinisanoj promenjivoj niza: " + arrName, designatorArrayName);
			designatorArrayName.obj = Tab.noObj;
		}
		else if (arrObj.getKind() != Obj.Var && arrObj.getType().getKind() != Struct.Array && arrObj.getKind()!= Obj.Meth) {
			report_error("Neadekvatna promenjiva niza: " + arrName, designatorArrayName);
			designatorArrayName.obj = Tab.noObj;
		}
		else  {
			designatorArrayName.obj = arrObj;
			
		}
	}
	
	@Override
	public void visit (Designator_Arr_Elem designator_Arr_Elem) {
		Obj arrObj = designator_Arr_Elem.getDesignatorArrayName().obj;
		if(arrObj == Tab.noObj) 
			designator_Arr_Elem.obj = Tab.noObj;
		else if (!designator_Arr_Elem.getExpr().struct.equals(Tab.intType)) {
			report_error("Indeksiranje niza sa vrednoscu koja nije int", designator_Arr_Elem);
		}
		else {
			String arrName = designator_Arr_Elem.getDesignatorArrayName().getI1();
			String output = "Array element access: "+ arrName + "[#]";
			
			//report_info(output, designator_Arr_solo);
			designator_Arr_Elem.obj = new Obj(Obj.Elem, arrObj.getName()+"[$]", arrObj.getType().getElemType());
		}
	}
	

	
	@Override
	public void visit(Factor_Designator_Meth factor_Designator_Meth) {
		
		Obj fdsMeth = factor_Designator_Meth.getDesignator().obj;
		
		if( fdsMeth.getKind() != Obj.Meth) 
			report_error("Poziv neadekvatne metode: " + fdsMeth.getName(), factor_Designator_Meth);
		
		else {
			factor_Designator_Meth.struct = fdsMeth.getType();
			
			List<Struct> formal_param_list = new ArrayList<>();
			
			for (Obj local : fdsMeth.getLocalSymbols()) {
				if(local.getKind() == Obj.Var && local.getLevel() == 1 && local.getFpPos() == 1)
					formal_param_list.add(local.getType());
				else if (fdsMeth.getName().equals("ord")) {

					formal_param_list.add(local.getType());
				}
			}
			
			ActParCounter actParCounter = new ActParCounter();
			factor_Designator_Meth.getActPars().traverseBottomUp(actParCounter);
			
			List<Struct> apList = actParCounter.finalactParList;

			try {
				if(formal_param_list.size() != apList.size()) 
					throw new Exception("Broj formalnih i act parametara nije isti");
				
				for (int i = 0; i< apList.size(); i++) {
					Struct fps = formal_param_list.get(i);
					Struct aps = apList.get(i);
					
					if(!aps.assignableTo(fps)) 
						throw new Exception("Tip formalnog act parametra nije dodeljiv formalnom parametru na indeksu: " + Integer.toString(i));
				}
				
			}catch(Exception e) {
				report_error( e.getMessage() +": Nekompatibilnost parametara pri pozivu metode: " + fdsMeth.getName(), factor_Designator_Meth);

			}
			
		}
			
	}
	
	
	//NEW
	
	@Override
	public void visit (Factor_Designator_NewExpr factor_Designator_NewExpr) {
		if(factor_Designator_NewExpr.getExpr().struct.equals(Tab.intType)) 			
			factor_Designator_NewExpr.struct = new Struct(Struct.Array, (currentType));
			 
		else {
			report_error("Velicina niza nije int tipa", factor_Designator_NewExpr);
			factor_Designator_NewExpr.struct = Tab.noType;
			
		}
			
			
	}
	
	//RANGE
	
	@Override
	public void visit (Factor_Designator_Range factor_Designator_Range) {
		if(factor_Designator_Range.getExpr().struct.equals(Tab.intType)) 			
			factor_Designator_Range.struct = new Struct(Struct.Array, Tab.intType);
			 
		else {
			report_error("Argument funkcije range nije tipa int", factor_Designator_Range);
			factor_Designator_Range.struct = Tab.noType;
			
		}
			
			
	}
	
	//Expr
	
	@Override
	public void visit(MulOpList_factor mulOpList_factor) {
		mulOpList_factor.struct = mulOpList_factor.getFactor().struct;
	}
	
	@Override 
	public void visit (MulopList_mul mulopList_mul) {
		
		Struct left = mulopList_mul.getMulOpList().struct;
		Struct right = mulopList_mul.getFactor().struct;
		
		if(left.equals(Tab.intType) && right.equals(Tab.intType)) 
			mulopList_mul.struct = Tab.intType;
		else {
			report_error("Mulop operacija sa ne int vrednoscu", mulopList_mul);
			mulopList_mul.struct = Tab.noType;
		}
		
		
	}
	
	@Override
	public void visit (Term term) {
		term.struct = term.getMulOpList().struct;
	}
	
	@Override
	public void visit(AddOpList_term addOpList_term) {
		addOpList_term.struct = addOpList_term.getTerm().struct;
	}
	
	@Override 
	public void visit (AddOpList_add addOpList_add) {
		
		Struct left = addOpList_add.getAddOpList().struct;
		Struct right = addOpList_add.getTerm().struct;
		
		if(left.equals(Tab.intType) && right.equals(Tab.intType)) 
			addOpList_add.struct = Tab.intType;
		else {
			report_error("Addop operacija sa ne int vrednoscu", addOpList_add);
			addOpList_add.struct = Tab.noType;
		}
		
		
	}
	
	@Override
	public void visit (Expr expr) {
		expr.struct = expr.getAddOpList().struct;
	}
	
	
	
	// DesignatorStatements single
	
	@Override
	public void visit (DesignatorStatement_Assign designatorStatement_Assign) {
		
		
		Obj dsAssign = designatorStatement_Assign.getDesignator().obj;
		int kind = dsAssign.getKind();
		
		if(kind != Obj.Var && kind != Obj.Elem)
			report_error("Dodela u neadekvatnu promenjivu: " + dsAssign.getName(), designatorStatement_Assign);
		
		else if (!designatorStatement_Assign.getExpr().struct.assignableTo(dsAssign.getType())) {
			report_error("Neadekvatna dodela vrednosti u promenjivu: " + dsAssign.getName(), designatorStatement_Assign);

		}
	}
	
	@Override
	public void visit (DesignatorStatement_Inc designatorStatement_Inc) {
		
		Obj dsInc = designatorStatement_Inc.getDesignator().obj;
		int kind = dsInc.getKind();
		
		
		if(kind != Obj.Var && kind != Obj.Elem)
			report_error("Inkrement neadekvatne promenjive: " + dsInc.getName(), designatorStatement_Inc);
		else if(!dsInc.getType().equals(Tab.intType))
			report_error("Inkrement ne int promenjive: " + dsInc.getName(), designatorStatement_Inc);

	}
	
	@Override
	public void visit (DesignatorStatement_Dec designatorStatement_Dec) {
		
		
		Obj dsDec = designatorStatement_Dec.getDesignator().obj;
		int kind = dsDec.getKind();
		
		if(kind != Obj.Var && kind != Obj.Elem)
			report_error("Dekrement neadekvatne promenjive: " + dsDec.getName(), designatorStatement_Dec);
		else if(!dsDec.getType().equals(Tab.intType))
			report_error("Dekrement ne int promenjive: " + dsDec.getName(), designatorStatement_Dec);
	}
	
	@Override
	public void visit (DesignatorStatement_List_Comprehension designatorStatement_List_Comprehension) {
		
		
		Obj leftDes = designatorStatement_List_Comprehension.getDesignator().obj;
		
		Obj rightDes = designatorStatement_List_Comprehension.getDesignator1().obj;
		
		Struct expr = designatorStatement_List_Comprehension.getExpr().struct;
		
		DesignatorVarCounter desVarCounter = new DesignatorVarCounter();
		
		designatorStatement_List_Comprehension.getExpr().traverseBottomUp(desVarCounter);
		
		List<Designator_Var> varCnt = desVarCounter.designatorVarList;
		
		int varCount = varCnt.size();
		
		
		
		if(leftDes.getType().getKind() != Struct.Array) 
			report_error("Promenjiva sa leve strane dodele nije nizovskog tipa: " + rightDes.getName(), designatorStatement_List_Comprehension);
		else if (rightDes.getType().getKind() != Struct.Array)
			report_error("Promenjiva sa desne strane dodele nije nizovskog tipa: " + leftDes.getName(), designatorStatement_List_Comprehension);
		else if (leftDes.getType() != rightDes.getType()) 
			report_error("Nizovi sa leve i desne strane dodele nisu istog tipa: ", designatorStatement_List_Comprehension);
		else if (varCount > 1)
			report_error("Vise od jedne promenjive se nalazi u okviru expr izraza: ", designatorStatement_List_Comprehension);
		else if (Tab.find(varCnt.get(0).getI1())==Tab.noObj)
			report_error("Promenjiva u okviru Expr nije definisana: ", designatorStatement_List_Comprehension);
		else if (expr.getKind() != rightDes.getType().getKind())
			report_error("Expr nije kompatibilan sa elementom niza kroz koji se iterira: ", designatorStatement_List_Comprehension);
		
		

	}
	
	@Override
	public void visit(ComprehensionCondition_if comprehensionCondition_if) {
		
		DesignatorVarCounter desVarCounter = new DesignatorVarCounter();
		
		comprehensionCondition_if.getCondition().getCondTermList().traverseBottomUp(desVarCounter);
		
		List<Designator_Var> varCnt = desVarCounter.designatorVarList;
		
		int varCount = varCnt.size();
		
		if (varCount > 1)
			report_error("Vise od jedne promenjive se nalazi u okviru condition izraza: ", comprehensionCondition_if);
		else if (Tab.find(varCnt.get(0).getI1())==Tab.noObj)
			report_error("Promenjiva u okviru Condition nije definisana: ", comprehensionCondition_if);
		
	}
	
	//Single statements
	
	@Override
	public void visit(SingleStatement_Read singleStatement_Read) {
		int kind = singleStatement_Read.getDesignator().obj.getKind();
		
		Struct type = singleStatement_Read.getDesignator().obj.getType();
		
		if(kind != Obj.Var && kind != Obj.Elem)
			report_error("Citanje neadekvatne promenjive: " + singleStatement_Read.getDesignator().obj.getName(), singleStatement_Read);
		else if(!type.equals(Tab.intType) && !type.equals(Tab.charType) && !type.equals(boolType))
			report_error("Citanje promenjive koja nije int, char ili bool: " + singleStatement_Read.getDesignator().obj.getName(), singleStatement_Read);
	}
	
	@Override
	public void visit(SingleStatement_Print1 singleStatement_Print1) {
		
		Struct type = singleStatement_Print1.getExpr().struct;

		if(!type.equals(Tab.intType) && !type.equals(Tab.charType) && !type.equals(boolType) && type.getKind() != Struct.Array)
			report_error("Print operacija neadekvatnog izraza ", singleStatement_Print1);
		

			//report_info("Function call: print(expr)" , singleStatement_Print1);
		
	}
	
	
	@Override
	public void visit(SingleStatement_Print2 singleStatement_Print2) {
		Struct type = singleStatement_Print2.getExpr().struct;
		
		if(!type.equals(Tab.intType) && !type.equals(Tab.charType) && !type.equals(boolType) && type.getKind() != Struct.Array)
			report_error("Print operacija neadekvatnog izraza ", singleStatement_Print2);
		
		//report_info("Function call: print(expr, number )" , singleStatement_Print2);
		
	}
	
	@Override
	public void visit (SingleStatement_Return1 singleStatement_Return1) {
		returnHappened = true;
		if(!currentMethod.getType().equals(singleStatement_Return1.getExpr().struct))
			report_error("Dogodio se nekompatibilan iskaz return u okviru metode: " + currentMethod.getName(), singleStatement_Return1);
	}
	
	@Override
	public void visit (SingleStatement_Return2 singleStatement_Return2) {
		returnHappened = true;
		if(currentMethod.getType()!= Tab.noType)
			report_error("Dogodio se nevalidan iskaz return u okviru metode koja vraca void: " + currentMethod.getName(), singleStatement_Return2);
	}
	
	@Override
	public void visit(DesignatorStatement_Meth designatorStatement_Meth) {
		
		Obj dsActPars = designatorStatement_Meth.getDesignator().obj;
		
		if(dsActPars.getKind() != Obj.Meth)
			report_error("Poziv neadekvatne metode: " + dsActPars.getName(), designatorStatement_Meth);
		else {
			List<Struct> formal_param_list = new ArrayList<>();
			for (Obj local : dsActPars.getLocalSymbols()) {
				if(local.getKind() == Obj.Var && local.getLevel() == 1 && local.getFpPos() == 1)
					formal_param_list.add(local.getType());
			}
			
			ActParCounter actParCounter = new ActParCounter();
			designatorStatement_Meth.getActPars().traverseBottomUp(actParCounter);
			

			
			List<Struct> apList = actParCounter.finalactParList;
			
			try {
				if(formal_param_list.size() != apList.size()) 

					throw new Exception("Broj formalnih i act parametara nije isti");

				for (int i = 0; i< apList.size(); i++) {
					Struct fps = formal_param_list.get(i);
					Struct aps = apList.get(i);
					
					if(!aps.assignableTo(fps)) 
						throw new Exception("Tip formalnog act parametra nije dodeljiv formalnom parametru na indeksu: " + Integer.toString(i));
					//else
						 //report_info("Function call" + designatorStatement_Meth.getDesignator().obj.getName(), designatorStatement_Meth);
				}
				
			}catch(Exception e) {
				report_error( e.getMessage() +": Nekompatibilnost parametara pri pozivu metode: " + dsActPars.getName(), designatorStatement_Meth);

			}
			
		}
		
		
		
	}
	
	@Override
	public void visit (SingleStatement_Break singleStatement_Break ) {
		
		
		if(loopCounter == 0)
			report_error("Break naredba se nalazi van petlje", singleStatement_Break);
	}
	
	@Override
	public void visit (SingleStatement_Continue singleStatement_Continue) {
		if(loopCounter == 0)
			report_error("Continue naredba se nalazi van petlje", singleStatement_Continue);
	}
	
	@Override
	public void visit ( ForNonTerm forNonTerm) {
		
		loopCounter++;
	}
	
	@Override
	public void visit ( SingleStatement_For singleStatement_For) {

			loopCounter--;
	}
	
	//Condition
	
	@Override 
	public void visit(CondFact_expr condFact_expr) {
		if(!condFact_expr.getExpr().struct.equals(boolType)) {
			report_error("Logicki operand nije tipa bool", condFact_expr);
			condFact_expr.struct = Tab.noType;
		}
		else 
			condFact_expr.struct = boolType;
	}
	
	@Override 
	public void visit(CondFact_expr_r_expr condFact_expr_r_expr) {
		
		Struct left = condFact_expr_r_expr.getExpr().struct;
		Struct right = condFact_expr_r_expr.getExpr1().struct;
		
		
		if(left.compatibleWith(right))  {
			
			if(left.isRefType() && right.isRefType()) {
				if(condFact_expr_r_expr.getRelop() instanceof Relop_Equals || condFact_expr_r_expr.getRelop() instanceof Relop_NotEquals)
					condFact_expr_r_expr.struct = boolType;
				else {
					report_error("Poredjenje REF tipova sa neadekvatnim relacionim operatorima", condFact_expr_r_expr);
					condFact_expr_r_expr.struct = Tab.noType;
				}
			}
			else
				condFact_expr_r_expr.struct = boolType;
					
		}
		else {
			report_error("Logicki operandi nisu kompatibilni", condFact_expr_r_expr);
			condFact_expr_r_expr.struct = Tab.noType;
		}
	}
	
	@Override
	public void visit(CondFactList_cf condFactList_cf) {
		condFactList_cf.struct = condFactList_cf.getCondFact().struct;
	}
	
	@Override
	public void visit(CondFactList_and condFactList_and) {
		Struct left = condFactList_and.getCondFactList().struct;
		Struct right = condFactList_and.getCondFact().struct;
		
		if(left.compatibleWith(right)) 
			condFactList_and.struct = boolType;
		else {
			report_error("AND operacija sa ne bool vrednostima", condFactList_and);
			condFactList_and.struct = Tab.noType;
		}
		
		
	}
	
	@Override
	public void visit (CondTerm condTerm) {
		condTerm.struct = condTerm.getCondFactList().struct;
	}
	
	@Override
	public void visit(CondTermList_ct condTermList_ct) {
		condTermList_ct.struct = condTermList_ct.getCondTerm().struct;
	}
	
	@Override
	public void visit(CondTermList_OR condTermList_OR) {
		Struct left = condTermList_OR.getCondTermList().struct;
		Struct right = condTermList_OR.getCondTerm().struct;
		
		if(left.equals(boolType) && right.equals(boolType)) 
			condTermList_OR.struct = boolType;
		else {
			report_error("Logicki operandi nisu kompatibilni", condTermList_OR);
			condTermList_OR.struct = Tab.noType;
		}
		
		
	}
	
	@Override
	public void visit (Condition condition) {
		condition.struct = condition.getCondTermList().struct;
		if(!condition.struct.equals(boolType))
			report_error("Uslov nije tipa bool", condition);
	}
	
	
	
	
}
