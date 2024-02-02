package rs.ac.bg.etf.pp1;

import java_cup.runtime.*;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.util.Log4JUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

import rs.etf.pp1.mj.runtime.Code;

public class Compiler {

	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}

	public static void main (String[] args) throws Exception {

		Logger log = Logger.getLogger(Compiler.class);

		Reader br = null;

		try {
			File sourceCode = new File("program.mj");
			log.info("Compiling source file: " + sourceCode.getAbsolutePath());
			

			br = new BufferedReader(new FileReader(sourceCode));
			Yylex lexer = new Yylex(br);
			
			//Formiranje AST
			MJParser parser = new MJParser(lexer);
			Symbol symbol = parser.parse();
			Program program = (Program) symbol.value;

			//ispis AST
			log.info(program.toString(""));
			log.info("=========================================");
			
			//Inicijalizacija tabele simbola
			
			Tab.init();
			
			Struct boolType = new Struct(Struct.Bool);
			Obj boolObj = Tab.insert(Obj.Type, "bool", boolType);
			boolObj.setAdr(-1);
			boolObj.setLevel(-1);

			
			//semanticka analiza
			SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
			program.traverseBottomUp(semanticAnalyzer);
			
			
			//Ispis tabele simbola
			log.info("=========================================");
			Tab.dump();

			if(!parser.errorDetected && semanticAnalyzer.passed()) {
				//log.info("Parsiranje uspesno zavrseno!");
				
				
				// Generisanje koda
				
				File objFile = new File ("program.obj");
				
				if(objFile.exists()) objFile.delete();
				
				CodeGenerator codeGenerator = new CodeGenerator();
				program.traverseBottomUp(codeGenerator);
				
				Code.dataSize = semanticAnalyzer.nVars;
				Code.mainPc = codeGenerator.getMainPc();
				
				Code.write(new FileOutputStream(objFile));
				
				
				log.info("Generisanje uspesno zavrseno!");
				
				

				
			}
			else {
				log.error("Parsiranje NIJE uspesno zavrseno!");
			}


		} finally {
			if(br!=null) try {br.close();} catch (IOException e) {log.error(e.getMessage());}
		}

	}

}