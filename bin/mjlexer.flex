package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;

%%

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

" " 	{ }
"\b" 	{ }
"\t" 	{ }
"\r\n" 	{ }
"\f" 	{ }

"program"   { return new_symbol(sym.PROGRAM, yytext()); }
"break"     { return new_symbol(sym.BREAK, yytext()); }
"else"     { return new_symbol(sym.ELSE, yytext()); }
"const"     { return new_symbol(sym.CONST, yytext()); }
"if"     { return new_symbol(sym.IF, yytext()); }
"new"     { return new_symbol(sym.NEW, yytext()); }
"print" 	{ return new_symbol(sym.PRINT, yytext()); }
"read" 	{ return new_symbol(sym.READ, yytext()); }
"return" 	{ return new_symbol(sym.RETURN, yytext()); }
"void" 		{ return new_symbol(sym.VOID, yytext()); }
"continue" 		{ return new_symbol(sym.CONTINUE, yytext()); }
"for" 		{ return new_symbol(sym.FOR, yytext()); }
"static" 		{ return new_symbol(sym.STATIC, yytext()); }
"namespace" 		{ return new_symbol(sym.NAMESPACE, yytext()); }



//Operators

"+" 		{ return new_symbol(sym.PLUS, yytext()); }
"-" 		{ return new_symbol(sym.MINUS, yytext()); }
"*" 		{ return new_symbol(sym.MULTIPLY, yytext()); }
"/" 		{ return new_symbol(sym.DIVIDE, yytext()); }
"%" 		{ return new_symbol(sym.REM, yytext()); }

"==" 		{ return new_symbol(sym.EQUAL, yytext()); }
"!=" 		{ return new_symbol(sym.NOT_EQUAL, yytext()); }
">" 		{ return new_symbol(sym.GREATER, yytext()); }
">=" 		{ return new_symbol(sym.GREATER_EQUAL, yytext()); }
"<" 		{ return new_symbol(sym.LESS, yytext()); }
"<=" 		{ return new_symbol(sym.LESS_EQUAL, yytext()); }

"&&" 		{ return new_symbol(sym.AND, yytext()); }
"||" 		{ return new_symbol(sym.OR, yytext()); }

"=" 		{ return new_symbol(sym.ASSIGNMENT, yytext()); }

"++" 		{ return new_symbol(sym.INC, yytext()); }
"--" 		{ return new_symbol(sym.DEC, yytext()); }

";" 		{ return new_symbol(sym.SEMI_COLON, yytext()); }
":" 		{ return new_symbol(sym.COLON, yytext()); }
"," 		{ return new_symbol(sym.COMMA, yytext()); }
"." 		{ return new_symbol(sym.DOT, yytext()); }

"(" 		{ return new_symbol(sym.LEFT_ROUND_BRACKET, yytext()); }
")" 		{ return new_symbol(sym.RIGHT_ROUND_BRACKET, yytext()); }
"[" 		{ return new_symbol(sym.LEFT_SQUARE_BRACKET, yytext()); }
"]" 		{ return new_symbol(sym.RIGHT_SQUARE_BRACKET, yytext()); }
"{" 		{ return new_symbol(sym.LEFT_CURLY_BRACKET, yytext()); }
"}"			{ return new_symbol(sym.RIGHT_CURLY_BRACKET, yytext()); }

"::"			{ return new_symbol(sym.DBLCOLON, yytext()); }





"//" 		     { yybegin(COMMENT); }
<COMMENT> .      { yybegin(COMMENT); }
<COMMENT> "\r\n" { yybegin(YYINITIAL); }

[0-9]+  						{ return new_symbol(sym.NUMBER, new Integer (yytext())); }
("true"|"false") 				{ return new_symbol(sym.BOOL, yytext().equals("true")? 1 : 0); }
([a-z]|[A-Z])[a-z|A-Z|0-9|_]* 	{ return new_symbol(sym.IDENT, yytext()); }
"'"."'"							{ return new_symbol(sym.CHAR, new Character (yytext().charAt(1))); }

. { System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1)); }




