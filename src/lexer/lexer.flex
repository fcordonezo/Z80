/* Archivo con las definiciones léxicas */

/**
 *
 * @author Fabián Ordóñez
 * Jair Villalba
 * Luis Guzman
 */

package lexer;
import static lexer.Tokens.*;
%%

%class Lexer
%type Tokens
H = [0-9A-F]
REG = [ABCDEHL]
/*S = [\|\°\¬\!\"\#\$\%\&\/\(\)\=\'\?\\\¿\¡\<\>\´\¨\+\*\~\{\[\^\}\]\`\,\;\.\:\-\_]*/
/*D = [0-9]*/
espacio = [\t\r\n]
%{
    public String lexeme;
%}

%%

"NOP" {return NOP;}
"LD "{REG}{1}","{REG}{1} {lexeme = yytext(); return LD1;}
"LD "{REG}{1}","{H}{2} {lexeme = yytext(); return LD2;}
"LD ("{REG}{2}"),"{H}{4} {lexeme = yytext(); return LD3;}
"LD ("{H}{4}"),A" {lexeme = yytext(); return LD4;}
"LD ("{H}{4}"),HL" {lexeme = yytext(); return LD5;}

"ADD A,"{REG}{1} {lexeme = yytext(); return ADD1;}
"ADD A,(HL)" {lexeme = yytext(); return ADD2;}
"ADD A," {H}{2} {lexeme = yytext(); return ADD3;}

"AND "{REG}{1} {lexeme = yytext(); return AND1;}
"AND (HL)" {lexeme = yytext(); return AND2;}
"AND " {H}{2} {lexeme = yytext(); return AND3;}

"OR "{REG}{1} {lexeme = yytext(); return OR1;}
"OR (HL)" {lexeme = yytext(); return OR2;}
"OR " {H}{2} {lexeme = yytext(); return OR3;}

"XOR "{REG}{1} {lexeme = yytext(); return XOR1;}
"XOR (HL)" {lexeme = yytext(); return XOR2;}
"XOR " {H}{2} {lexeme = yytext(); return XOR3;}

"SUB A,"{REG}{1} {lexeme = yytext(); return SUB1;}
"SUB A,(HL)" {lexeme = yytext(); return SUB2;}
"SUB A," {H}{2} {lexeme = yytext(); return SUB3;}

"INC "{REG}{1} {lexeme = yytext(); return INC1;}
"INC (HL)" {lexeme = yytext(); return INC2;}

"DEC "{REG}{1} {lexeme = yytext(); return DEC1;}
"DEC (HL)" {lexeme = yytext(); return DEC2;}

"CPL" {lexeme = yytext(); return CPL;}
"NEG" {lexeme = yytext(); return NEG;}

"IN A,("{H}{2}")" {lexeme = yytext(); return IN;}
"OUT ("{H}{2}"),A" {lexeme = yytext(); return OUT;}

"JR "{H}{2} {lexeme = yytext(); return JR1;}
"JR Z,"{H}{2} {lexeme = yytext(); return JR2;}
"JR C,"{H}{2} {lexeme = yytext(); return JR3;}
"JR NZ"{H}{2} {lexeme = yytext(); return JR4;}
"JR NC"{H}{2} {lexeme = yytext(); return JR5;}

"RRCA" {lexeme = yytext(); return RRCA;}
"RLCA" {lexeme = yytext(); return RLCA;}

"HALT" {lexeme = yytext(); return HALT;}

"ORG "{H}{4} {lexeme = yytext(); return ORG;}

 . |{espacio}+ {lexeme = yytext(); return Other;}