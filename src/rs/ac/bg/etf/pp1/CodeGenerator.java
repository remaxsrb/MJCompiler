package rs.ac.bg.etf.pp1;

import java.util.List;
import java.util.Stack;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	
	Logger log = Logger.getLogger(getClass());
	
	private int mainPc;
	
	private Stack<Integer>  skipCondFact = new Stack<>(); 
	
	private Stack<Integer>  skipCondition = new Stack<>();
	
	private Stack<Integer> skipThen = new Stack<>();
	
	private Stack<Integer> skipElse = new Stack<>();

	private Stack<Integer> condFactStack = new Stack<>();
	
	private Stack<Integer> incdecStack = new Stack<>();
	
	private Stack<Integer> forBodyStack = new Stack<>();
	
	private Stack<Integer> breakStack = new Stack<>();

	private Stack<Integer> continueStack = new Stack<>();
	
	private int loopCounter = 0;


	public int getMainPc() {
		
		return this.mainPc;
	}
	
	
	@Override
	public void visit (MethodReturnAndName_type methodReturnAndName_type) {
		
		methodReturnAndName_type.obj.setAdr(Code.pc);
				
		Code.put(Code.enter);
		Code.put(methodReturnAndName_type.obj.getLevel()); //number of formal parameters - b1
		Code.put(methodReturnAndName_type.obj.getLocalSymbols().size()); //sum of formal and local parameters -b2
	}
	
	@Override
	public void visit (MethodReturnAndName_void methodReturnAndName_void) {
		
		methodReturnAndName_void.obj.setAdr(Code.pc);
		if (methodReturnAndName_void.getI1().equalsIgnoreCase("main"))
			this.mainPc = Code.pc;
		
		Code.put(Code.enter);
		Code.put(methodReturnAndName_void.obj.getLevel()); //number of formal parameters - b1
		Code.put(methodReturnAndName_void.obj.getLocalSymbols().size()); //sum of formal and local parameters -b2
		

	}
	
	@Override
	public void visit (MethodDecl methodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);

	}
	
	// Single statements
	
	@Override
	public void visit(SingleStatement_Print1 singleStatement_Print1) {
		if(singleStatement_Print1.getExpr().struct.equals(Tab.charType))
		{
			if (singleStatement_Print1.getExpr().struct.getKind() == Struct.Array)  {
				
				Obj arrayAddress = Tab.insert(Obj.Var, "arrAddressRange", Tab.intType);
				arrayAddress.setLevel(1);
				
				Code.put(Code.dup);
				Code.store(arrayAddress); //adresa novokreiranog niza
				
				Obj arrayLength = Tab.insert(Obj.Var, "arrLengthRange", Tab.intType);
				arrayLength.setLevel(1);
				
				Obj index = Tab.insert(Obj.Var, "index", Tab.intType);
				index.setLevel(1);
				
				Code.loadConst(0);
				Code.store(index);
				
				//Code.loadConst(1);
				Code.put(Code.arraylength);
				//Code.put(Code.sub);
				Code.store(arrayLength); //duzina niza
				
				int ret = Code.pc; //adresa pocetka petlje
				
				Code.load(arrayLength);
				Code.load(index);
				Code.putFalseJump(Code.ne, 0);
				
				int codeFixUpLoopEnd = Code.pc-2;	
				
				Code.load(arrayAddress);
				Code.load(index);
				
				Code.put(Code.baload);
				Code.loadConst(0);
				Code.put(Code.bprint);
				
				Code.loadConst(1);
				Code.load(index);
				Code.put(Code.add);
				Code.store(index);
				
				Code.putJump(ret); //vrati se na pocetak petlje
				
				Code.fixup(codeFixUpLoopEnd); //ovde se skace nakon sto se gornja petlja zavrsi
				
			}
			else {
				Code.loadConst(0);
				Code.put(Code.bprint);
			}
		}
		
			
		else {
			if (singleStatement_Print1.getExpr().struct.getKind() == Struct.Array)  {
				
				Obj arrayAddress = Tab.insert(Obj.Var, "arrAddressRange", Tab.intType);
				arrayAddress.setLevel(1);
				
				Code.put(Code.dup);
				Code.store(arrayAddress); //adresa novokreiranog niza
				
				Obj arrayLength = Tab.insert(Obj.Var, "arrLengthRange", Tab.intType);
				arrayLength.setLevel(1);
				
				Obj index = Tab.insert(Obj.Var, "index", Tab.intType);
				index.setLevel(1);
				
				Code.loadConst(0);
				Code.store(index);
				
				Code.put(Code.arraylength);

				Code.store(arrayLength); //duzina niza
				
				int ret = Code.pc; //adresa pocetka petlje
				
				Code.load(arrayLength);
				Code.load(index);
				Code.putFalseJump(Code.ne, 0);
				
				int codeFixUpLoopEnd = Code.pc-2;	
				
				Code.load(arrayAddress);
				Code.load(index);

				
				Code.put(Code.aload);
				Code.loadConst(0);
				Code.put(Code.print);
				
				Code.loadConst(1);
				Code.load(index);
				Code.put(Code.add);
				Code.store(index);
				
				Code.putJump(ret); //vrati se na pocetak petlje
				
				Code.fixup(codeFixUpLoopEnd); //ovde se skace nakon sto se gornja petlja zavrsi
			}
			else {
				Code.loadConst(0);
				Code.put(Code.print);
			}
		}
			

		
		
	}
	
	@Override
	public void visit(SingleStatement_Print2 singleStatement_Print2) {
		
		if(singleStatement_Print2.getExpr().struct.equals(Tab.charType))
		{
			if (singleStatement_Print2.getExpr().struct.getKind() == Struct.Array)  {
				
				Obj arrayAddress = Tab.insert(Obj.Var, "arrAddressRange", Tab.intType);
				arrayAddress.setLevel(1);
				
				Code.put(Code.dup);
				Code.store(arrayAddress); //adresa novokreiranog niza
				
				Obj arrayLength = Tab.insert(Obj.Var, "arrLengthRange", Tab.intType);
				arrayLength.setLevel(1);
				
				Obj index = Tab.insert(Obj.Var, "index", Tab.intType);
				index.setLevel(1);
				
				Code.loadConst(0);
				Code.store(index);
				
				//Code.loadConst(1);
				Code.put(Code.arraylength);
				//Code.put(Code.sub);
				Code.store(arrayLength); //duzina niza
				
				int ret = Code.pc; //adresa pocetka petlje
				
				Code.load(arrayLength);
				Code.load(index);
				Code.putFalseJump(Code.ne, 0);
				
				int codeFixUpLoopEnd = Code.pc-2;	
				
				Code.load(arrayAddress);
				Code.load(index);
				
				Code.put(Code.baload);
				Code.loadConst(singleStatement_Print2.getN2()); //pomeranje karaktera u desno za toliko blanko znaka
				Code.put(Code.bprint);
				
				Code.loadConst(1);
				Code.load(index);
				Code.put(Code.add);
				Code.store(index);
				
				Code.putJump(ret); //vrati se na pocetak petlje
				
				Code.fixup(codeFixUpLoopEnd); //ovde se skace nakon sto se gornja petlja zavrsi
				
			}
			else {
				Code.loadConst(singleStatement_Print2.getN2()); //pomeranje karaktera u desno za toliko blanko znaka
				Code.put(Code.bprint);
			}
		}
		
			
		else {
			if (singleStatement_Print2.getExpr().struct.getKind() == Struct.Array)  {
				
				Obj arrayAddress = Tab.insert(Obj.Var, "arrAddressRange", Tab.intType);
				arrayAddress.setLevel(1);
				
				Code.put(Code.dup);
				Code.store(arrayAddress); //adresa novokreiranog niza
				
				Obj arrayLength = Tab.insert(Obj.Var, "arrLengthRange", Tab.intType);
				arrayLength.setLevel(1);
				
				Obj index = Tab.insert(Obj.Var, "index", Tab.intType);
				index.setLevel(1);
				
				Code.loadConst(0);
				Code.store(index);
				
				Code.put(Code.arraylength);

				Code.store(arrayLength); //duzina niza
				
				int ret = Code.pc; //adresa pocetka petlje
				
				Code.load(arrayLength);
				Code.load(index);
				Code.putFalseJump(Code.ne, 0);
				
				int codeFixUpLoopEnd = Code.pc-2;	
				
				Code.load(arrayAddress);
				Code.load(index);

				
				Code.put(Code.aload);
				Code.loadConst(singleStatement_Print2.getN2()); //pomeranje karaktera u desno za toliko blanko znaka
				Code.put(Code.print);
				
				Code.loadConst(1);
				Code.load(index);
				Code.put(Code.add);
				Code.store(index);
				
				Code.putJump(ret); //vrati se na pocetak petlje
				
				Code.fixup(codeFixUpLoopEnd); //ovde se skace nakon sto se gornja petlja zavrsi
			}
			else {
				Code.loadConst(singleStatement_Print2.getN2()); //pomeranje karaktera u desno za toliko blanko znaka
				Code.put(Code.print);
			}
		}
		
		
	}
	
	@Override
	public void visit (SingleStatement_Return1 singleStatement_Return1) {
		

		Code.put(Code.exit);
		Code.put(Code.return_);

	}
	
	@Override
	public void visit(SingleStatement_Return2 singleStatement_Return2) {
		Code.put(Code.exit);
		Code.put(Code.return_);

	}
	
	@Override
	public void visit(SingleStatement_Read singleStatement_Read) {
		
		if(singleStatement_Read.getDesignator().obj.getType().equals(Tab.charType))
			Code.put(Code.bread);
		else
			Code.put(Code.read);
		
		Code.store(singleStatement_Read.getDesignator().obj);
		
	}
	
	
	//When used, expr has to be on a expr stack. More precisely, factors at the right side of assignmend which expr boils down to have to be on expr stack
	

	
	@Override
	public void visit(Factor_Designator_Var factor_Designator_Var) {
		Code.load(factor_Designator_Var.getDesignator().obj); //stavljanje svih mogucih varijabli i konstanti na stek
	}
	
	@Override
	public void visit(DesignatorArrayName designatorArrayName) {
		Code.load(designatorArrayName.obj); //pushovanje adrese niza na stek nebitno sa koje strane dodele se nalazi
	}
	
	
	//designator statements

	@Override
	public void visit (Factor_Designator_NewExpr factor_Designator_NewExpr) {
		
		//velicina niza je vec na steku jer je taj cvor vec obidjen
		
		Code.put(Code.newarray);
		if(factor_Designator_NewExpr.getType().struct.equals(Tab.charType)) 
			Code.put(0);
		else
			Code.put(1);
	}
	
	//RANGE
	
	@Override
	public void visit (Factor_Designator_Range factor_Designator_Range) {
			
		//velicina niza je vec na steku jer je taj cvor obidjen i nalazi se na vrhu steka
		Code.put(Code.newarray);
		Code.put(1); //alociraj niz sa N elemenata i inicijalizuj na nulu a adresa niz ce biti na vrhu steka
		
		Obj arrayAddress = Tab.insert(Obj.Var, "arrAddressRange", Tab.intType);
		arrayAddress.setLevel(1);
		
		Code.put(Code.dup);
		Code.store(arrayAddress); //adresa novokreiranog niza
		
		Obj arrayLength = Tab.insert(Obj.Var, "arrLengthRange", Tab.intType);
		arrayLength.setLevel(1);
		
		Obj index = Tab.insert(Obj.Var, "index", Tab.intType);
		index.setLevel(1);
		
		Code.loadConst(0);
		Code.store(index);
		
		//Code.loadConst(1);
		Code.put(Code.arraylength);
		//Code.put(Code.sub);
		Code.store(arrayLength); //duzina niza
		
		int ret = Code.pc; //adresa pocetka petlje
		
		Code.load(arrayLength);
		Code.load(index);
		Code.putFalseJump(Code.ne, 0);
		
		int codeFixUpLoopEnd = Code.pc-2;	
		
		Code.load(arrayAddress);
		Code.load(index);
		Code.load(index);
		
		Code.put(Code.astore);
		
		Code.loadConst(1);
		Code.load(index);
		Code.put(Code.add);
		Code.store(index);
		
		Code.putJump(ret); //vrati se na pocetak petlje
		
		Code.fixup(codeFixUpLoopEnd); //ovde se skace nakon sto se gornja petlja zavrsi
		
		Code.load(arrayAddress);
	}
	
	
	@Override
	public void visit (DesignatorStatement_Assign designatorStatement_Assign) {
		Code.store(designatorStatement_Assign.getDesignator().obj); //Expr sa desne strane je izracunat i vec je na steku 
	}
	
	@Override
	public void visit (DesignatorStatement_Inc designatorStatement_Inc) {
		if(designatorStatement_Inc.getDesignator().obj.getKind() == Obj.Elem)
			Code.put(Code.dup2); //dupliranje poslednja dva elementa na steku- pogodno za inc elementa niza
		Code.load(designatorStatement_Inc.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(designatorStatement_Inc.getDesignator().obj);

	}
	
	@Override
	public void visit (DesignatorStatement_Dec designatorStatement_Dec) {
		if(designatorStatement_Dec.getDesignator().obj.getKind() == Obj.Elem)
			Code.put(Code.dup2);
		Code.load(designatorStatement_Dec.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(designatorStatement_Dec.getDesignator().obj);

	}
	
	@Override
	public void visit (DesignatorStatement_Meth designatorStatement_Meth) {
		int offset = designatorStatement_Meth.getDesignator().obj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);


		if(designatorStatement_Meth.getDesignator().obj.getType() != Tab.noType)
			Code.put(Code.pop);
		
	}
	
	
	//Expresions
	
		@Override
		public void visit(AddOpList_add addOpList_add) {
			if (addOpList_add.getAddop() instanceof Addop_Plus) 
				Code.put(Code.add);
			else if (addOpList_add.getAddop() instanceof Addop_Minus)
				Code.put(Code.sub);
		}
		
		@Override
		public void visit(MulopList_mul mulopList_mul) {
			if (mulopList_mul.getMulop() instanceof Mulop_Mul) 
				Code.put(Code.mul);
			else if (mulopList_mul.getMulop() instanceof Mulop_Div)
				Code.put(Code.div);
			else if (mulopList_mul.getMulop() instanceof Mulop_Rem)
				Code.put(Code.rem);
		}
	
	@Override
	public void visit (Factor factor) {
		if (factor.getUnary() instanceof Unary_minus)
			Code.put(Code.neg);
	}
	
	@Override 
	public void visit(Factor_Designator_Num factor_Designator_Num) {
		
		Code.loadConst(factor_Designator_Num.getN1());
		
	}
	
	@Override 
	public void visit(Factor_Designator_Char factor_Designator_Char) {
		
		Code.loadConst(factor_Designator_Char.getC1());
		
	}
	
	@Override 
	public void visit(Factor_Designator_BOOL factor_Designator_BOOL) {
		
		Code.loadConst(factor_Designator_BOOL.getB1());
		
	}
	

	
	@Override
	public void visit (Factor_Designator_Meth factor_Designator_Meth) {
		int offset = factor_Designator_Meth.getDesignator().obj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
	}
	
	private int returnRelOpCode(Relop relop) {
		if(relop instanceof Relop_Equals)
			return Code.eq;
		if(relop instanceof Relop_NotEquals)
			return Code.ne;
		if(relop instanceof Relop_GREATER)
			return Code.gt;
		if(relop instanceof Relop_GEquals)
			return Code.ge;
		if(relop instanceof Relop_Less)
				return Code.lt;
		if(relop instanceof Relop_LEquals)
			return Code.le;
		return -1;
	}
	
	
	//Condition
	@Override
	public void visit(CondFact_expr condFact_expr) {
		Code.loadConst(0);
		Code.putFalseJump(Code.ne, 0); //netacna tj else grana
		this.skipCondFact.push(Code.pc-2);
		//tacna tj then grana
		
		
	}
	
	@Override
	public void visit(CondFact_expr_r_expr condFact_expr_r_expr) {
		Code.putFalseJump(returnRelOpCode(condFact_expr_r_expr.getRelop()), 0); //netacna tj else grana
		this.skipCondFact.push(Code.pc-2);
		//tacna tj then grana
		
	}
	
	@Override
	public void visit(CondTerm condTerm) {
		//tacan
		Code.putJump(0); //tacne bacamo na THEN ; ujedno kraj jednog OR-a i pocetak sleceg OR-a
		this.skipCondition.push(Code.pc-2);
		//vracam netacan
		while(!this.skipCondFact.empty()) 
			Code.fixup(this.skipCondFact.pop()); //jednu po jednu netacnu vracam sa steka jer ce sledeci OR ispitati da li su tacne
		//netacsn nastavlja na sledeci OR
	}
	
	
	@Override 
	public void visit (Condition condition) {
		//prvo sve moguce AND-ove vracamo na stek jer su u svakom OR-u bili netacni i ceo njihov condition je netacan
		
		//netacan
		
		Code.putJump(0);//jedan jedini skok koji se desava u condition-u koji direktno baca na ELSE
		this.skipThen.push(Code.pc-2);
		
		//THEN
		while(!this.skipCondition.empty()) 
			Code.fixup(this.skipCondition.pop()); //Ciscenje adresa koje su direktno bacale na THEN granu 
		
		//tacan tok
		
	}
	
	@Override
	public void visit(ElseStatement_Epsilon elseStatement_Epsilon) {
		// posecivanje dela koda ukoliko ELSE deo ne postoji tj kraj iskaza u IF 
		
		Code.fixup(this.skipThen.pop());
		
		//tacan + netacan ====> posto postoji beskonacno mnogo kombinacija AND-OR 
		//izraza ovi visiti se lakse razumeju ako se posmatraju kao niti a ne jedan tok koji ce zapravo biti u programu jer niti nisu podrzane
	}
	
	@Override
	public void visit(Else else_) {
		//Postoji ELSE u kodu ===> //vracamo netacne jer su tacni izbaceni vec u delu kad nema Else-a
		//obe se spajaju kad se else zavrsi
		
		Code.putJump(0); //tacne stavljamo na kraj else
		this.skipElse.push( Code.pc -2);
		Code.fixup(this.skipThen.pop());
		//netacne

	}
	
	@Override
	public void visit (ElseStatement_S elseStatement_S) {
		//netacne
		Code.fixup(this.skipElse.pop());
		//netacne + tacne
	}
	
	//FOR LOOP
		
	@Override
	public void visit (ForNonTerm forNonTerm) {
		loopCounter++;

	}

	@Override
	public void visit (SingleStatement_For singleStatement_For) {

		//ovde treba da se fiksapujem ukoliko je uslov netacan
		if(loopCounter==1) 
			Code.fixup(this.skipThen.pop());		

		loopCounter--;
		
		while(!this.breakStack.empty()) 
			Code.fixup(this.breakStack.pop());


	}
	
	@Override
	public void visit(CondFactForBegin condFactForBegin) {
		
		this.condFactStack.push(Code.pc); 
	}
	
	@Override 
	public void visit(CondFactFor_True condFactFor_True) {
		Code.putJump(0); //bezuslovno skoci na pocetak body dela
		this.forBodyStack.push(Code.pc-2);
		
	}
	
	@Override
	public void visit(ForCountBegin forCountBegin) {

		this.incdecStack.push(Code.pc); 
	}
	
	@Override
	public void visit(ForCount forCount) {

		Code.putJump(this.condFactStack.pop()); 

	}
	


	@Override public void visit(ForBodyBegin forBodyBegin) {
		

		Code.fixup(this.forBodyStack.pop());

	}  

	@Override
	public void visit(ForBody forBody) {
		

		while(!this.continueStack.empty()) 
			Code.fixup(this.continueStack.pop());
		
		Code.putJump(this.incdecStack.pop()); 
		
		if(loopCounter>1) 
			Code.fixup(this.skipThen.pop());

	}
	
	@Override 
	public void visit(SingleStatement_Break singleStatement_Break) {
		
		Code.putJump(0);
		this.breakStack.push(Code.pc-2);
		

	}
	
	@Override 
	public void visit(  SingleStatement_Continue singleStatement_Continue) {
		
		Code.putJump(0);
		this.continueStack.push(Code.pc-2);
		

	}
	
	@Override
	public void visit(Designator_Var designator_Var) {	
		if(designator_Var.getI1().equals( "ord")) 
					Code.loadConst(0);
	}

}
