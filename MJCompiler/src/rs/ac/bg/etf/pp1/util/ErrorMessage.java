package rs.ac.bg.etf.pp1.util;

public class ErrorMessage {

	private ErrorMessage() {};
	
	public static void reportError(String message) {
		System.err.println(message);
	}
	
	public static void reportErrorAndExit(String message) {
		reportError(message);
		System.exit(-2);
	}
}
