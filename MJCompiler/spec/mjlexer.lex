package rs.ac.bg.etf.pp1;
import java_cup.runtime.Symbol;

//Sekcija import 

%%


//Sekcija Dirtektiva

%{
    // ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}
%}

%cup
%line
%column

%xstate COMMENT


%eofval{
	return new_symbol(sym.EOF);
%eofval}

%%
//Sekcija regularnih izraza

<YYINITIAL> " " 	{ }
<YYINITIAL> "\b" 	{ }
<YYINITIAL>  "\t" 	{ }
<YYINITIAL>  "\r\n" { }
<YYINITIAL>  "\f" 	{ }

//Program needed terminals
<YYINITIAL>  "program"   { return new_symbol(sym.PROG, yytext());}

//Function need terminals
<YYINITIAL>  "return" 	{ return new_symbol(sym.RETURN, yytext()); }
<YYINITIAL>  "void" 	{ return new_symbol(sym.VOID, yytext()); }

//Variable modificator needed terminals
<YYINITIAL>  "const"	{ return new_symbol(sym.CONST, yytext()); }

//Program controll terminals
<YYINITIAL>  "if"		{ return new_symbol(sym.IF, yytext()); }
<YYINITIAL>  "else"		{ return new_symbol(sym.ELSE, yytext()); }
//<YYINITIAL>  "switch"	{ return new_symbol(sym.SWITCH, yytext()); }
//<YYINITIAL>  "case"		{ return new_symbol(sym.CASE, yytext()); }

//Loop needed terminals
<YYINITIAL>  "do"		{ return new_symbol(sym.DO, yytext()); }
<YYINITIAL>  "for"		{ return new_symbol(sym.FOR, yytext()); }
<YYINITIAL>  "while"	{ return new_symbol(sym.WHILE, yytext()); }
<YYINITIAL>  "continue"	{ return new_symbol(sym.CONTINUE, yytext()); }
<YYINITIAL>  "break"	{ return new_symbol(sym.BREAK, yytext()); }


//Class needed terminals
//<YYINITIAL>  "class"	{ return new_symbol(sym.CLASS, yytext()); }
//<YYINITIAL>  "extends"	{ return new_symbol(sym.EXTENDS, yytext()); }
//<YYINITIAL>  "enum"		{ return new_symbol(sym.ENUM, yytext()); }

//Make new variable terminals
<YYINITIAL>  "new"		{ return new_symbol(sym.NEW, yytext()); }


//Predefined functions needed terminals
<YYINITIAL>  "print" 	{ return new_symbol(sym.PRINT, yytext()); }
<YYINITIAL>  "read"		{ return new_symbol(sym.READ, yytext()); }


//Seperators needed terminals
<YYINITIAL>  ";" 		{ return new_symbol(sym.SEMI, yytext()); }
<YYINITIAL>  "," 		{ return new_symbol(sym.COMMA, yytext()); }
//<YYINITIAL>  "."		{ return new_symbol(sym.DOT, yytext()); }
<YYINITIAL>  ":"		{ return new_symbol(sym.COLON, yytext()); }

//Brackets needed terminals
<YYINITIAL>  "(" 		{ return new_symbol(sym.LPAREN, yytext()); }
<YYINITIAL>  ")" 		{ return new_symbol(sym.RPAREN, yytext()); }
<YYINITIAL>  "{" 		{ return new_symbol(sym.LBRACE, yytext()); }
<YYINITIAL>  "}"		{ return new_symbol(sym.RBRACE, yytext()); }
<YYINITIAL>  "["		{ return new_symbol(sym.LSQUARE, yytext()); }
<YYINITIAL>  "]"		{ return new_symbol(sym.RSQUARE, yytext()); }

//Operators needed terminals
<YYINITIAL>  "=" 		{ return new_symbol(sym.EQUAL, yytext()); }
<YYINITIAL>  "+" 		{ return new_symbol(sym.PLUS, yytext()); }
<YYINITIAL>  "-"		{ return new_symbol(sym.MINUS, yytext()); }
<YYINITIAL>  "*"		{ return new_symbol(sym.MUL, yytext()); }
<YYINITIAL>  "/"		{ return new_symbol(sym.DIV, yytext()); }
<YYINITIAL>  "%"		{ return new_symbol(sym.MOD, yytext()); }
<YYINITIAL>  "=="		{ return new_symbol(sym.EQUAL_COMPARE, yytext()); }
<YYINITIAL>  "!="		{ return new_symbol(sym.NOT_EQUAL_COMPARE, yytext()); }
<YYINITIAL>  ">"		{ return new_symbol(sym.GREATER, yytext()); }
<YYINITIAL>  ">="		{ return new_symbol(sym.GREATER_EQUAL, yytext()); }
<YYINITIAL>  "<"		{ return new_symbol(sym.LESS, yytext()); }
<YYINITIAL>  "<="		{ return new_symbol(sym.LESS_EQUAL, yytext()); }
<YYINITIAL>  "&&"		{ return new_symbol(sym.AND, yytext()); }
<YYINITIAL>  "||"		{ return new_symbol(sym.OR, yytext()); }
<YYINITIAL>  "++"		{ return new_symbol(sym.INC, yytext()); }
<YYINITIAL>  "--"		{ return new_symbol(sym.DEC, yytext()); }
<YYINITIAL>  "?"		{ return new_symbol(sym.TERNAR, yytext()); }


//Number needed terminals
<YYINITIAL> [:digit:]+  		{ return new_symbol(sym.NUMBER, new Integer (yytext())); }

//Boolean needed terminals
<YYINITIAL> ("true"|"false")  {return new_symbol(sym.BOOLEAN, new String(yytext()));}

//Identifier needed terminals
<YYINITIAL> [:letter:]([:letter:]|[:digit:]|_)* 	{return new_symbol (sym.IDENT, yytext()); }

//Character needed terminals
<YYINITIAL> '[\x20-\x7E]' 							{return new_symbol(sym.CHAR, new Character(yytext().charAt(1)));}

//Comments 
<YYINITIAL> "//" {yybegin(COMMENT);}
<COMMENT> . {yybegin(COMMENT);}
<COMMENT> "\r\n" { yybegin(YYINITIAL); }

//Everything else
<YYINITIAL> [^] { System.err.println("Leksicka greska ("+ yytext() + ") u liniji "+ (yyline + 1) + " i u koloni " + (yycolumn + 1)); }


