package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.util.ErrorMessage;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class Compiler {

	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}
	SemanticPass semanticPass = new SemanticPass();

	public static void main(String[] args) {
		Logger log = Logger.getLogger(Compiler.class);
		if (args.length != 2) {
			log.error("Broj ulaznih parametara nije odgovarajuci, ocekivano 2.");
			ErrorMessage.reportErrorAndExit("Broj ulaznih parametara nije odgovarajuci, ocekivano 2.");
			return;
		}
		String fileNameIn = args[0], fileNameOut = args[1];
		File sourceCode = new File(fileNameIn);

		try (Reader br = new BufferedReader(new FileReader(sourceCode))) {
			Yylex lexer = new Yylex(br);

			MJParser parser = new MJParser(lexer);
			Symbol symbolsRoot = parser.parse();

			Program prog = (Program) (symbolsRoot.value);
			Tab.init();
			setDefaultObjNodesInTabSymbol();
			// ispis sintaksnog stabla
			log.info(prog.toString(""));
			log.info("===================================");

			// Semanticka analiza

			if (!parser.errorDetected) {
				log.info("Parsiranje uspesno zavrseno!");
				SemanticPass semanticPass = new SemanticPass();
				prog.traverseBottomUp(semanticPass);
				if (semanticPass.passed()) {
					tsdump();
					log.info("Semanticka analiza uspesno zavrsena!");
					File objFile = new File(fileNameOut);
					if (objFile.exists())
						objFile.delete();
					CodeGenerator codeGenerator = new CodeGenerator();
					prog.traverseBottomUp(codeGenerator);
					Code.dataSize = semanticPass.numOfVariables;
					Code.mainPc = codeGenerator.getMainPC();
					Code.write(new FileOutputStream(objFile));
					log.info("Generisanje koda je uspesno!");
				} else {
					log.error("Semanticka analiza nije uspesno zavrsena!");
				}
			} else {
				log.error("Parsiranje NIJE uspesno zavrseno!");
			}
		
			
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			ErrorMessage.reportErrorAndExit("Fajl sa imenom " + fileNameIn + " nije pronadjen.");
		} catch (IOException e) {
			ErrorMessage.reportErrorAndExit("Greska prilikom citanja fajla");
		} catch (Exception e) {
			// e.printStackTrace();
			ErrorMessage.reportErrorAndExit(e.getMessage());
		}

	}

	public static void tsdump() {
		Tab.dump();
	}

	private static void setDefaultObjNodesInTabSymbol() {
		Struct boolType = new Struct(Struct.Bool);
		Tab.currentScope.addToLocals(new Obj(Obj.Type, "bool", boolType));
	}
}
