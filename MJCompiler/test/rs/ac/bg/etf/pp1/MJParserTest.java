package rs.ac.bg.etf.pp1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.MJParser;
import rs.ac.bg.etf.pp1.Yylex;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.util.ErrorMessage;
import rs.ac.bg.etf.pp1.util.Log4JUtils;

class MJParserTest {
	Logger log;

	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}

	@BeforeEach
	void setUp() throws Exception {
		log = Logger.getLogger(MJParserTest.class);
		System.out.println("_____________________");
		System.out.println("Test zapocet");		
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Test zavrsen");
		System.out.println("_____________________");
	}

	@ParameterizedTest()
	@CsvFileSource(resources = "../../../../../parserTestResources/fileNames.csv", numLinesToSkip = 1)
	void test(String testName, String fileName) {
		System.out.println("Test sa imenom: " + testName + " je zapocet") ;
		runTest("test/parserTestResources/" + fileName);
		System.out.println("Parsiranje fajla uspeno zavrseno");
	}

	private void runTest(String fileName) {

		File sourceCode = new File(fileName);
		log.info("Compiling source file: " + fileName);

		try (Reader br = new BufferedReader(new FileReader(sourceCode))) {
			Yylex lexer = new Yylex(br);

			MJParser parser = new MJParser(lexer);
			Symbol symbolsRoot = parser.parse();

			Program prog = (Program) (symbolsRoot.value);

			// ispis sintaksnog stabla
			log.info(prog.toString(""));
			log.info("===================================");

		} catch (FileNotFoundException e) {
			ErrorMessage.reportError("Fajl sa imenom " + fileName + " nije pronadjen.");
			fail("Fajl sa imenom " + fileName + " nije pronadjen.");
		} catch (IOException e) {
			ErrorMessage.reportError("Greska prilikom citanja fajla");
			fail("Greska prilikom citanja fajla");
		} catch (Exception e) {
			ErrorMessage.reportError("Greska prilikom parsiranja fajla, sintaksna greska");
			fail("Greska prilikom parsiranja fajla, sintaksna greska");
		}

	}

}
