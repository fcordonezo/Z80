/* Archivo con las definiciones léxicas */

/**
 *
 * @author Fabián Ordóñez
 * Jair Villalba
 * Luis Guzman
 */

package z80;
import static z80.Tokens.*;
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
"LD "{REG}{2}","{H}{4} {lexeme = yytext(); return LD3;}
"LD ("{H}{2}"),"{H}{2} {lexeme = yytext(); return LD4;}
"LD ("{H}{4}"),"{H}{4} {lexeme = yytext(); return LD5;}

"ADD A,"{REG}{1} {lexeme = yytext(); return ADD1;}
"ADD A,(HL)" {lexeme = yytext(); return ADD2;}
"ADD A," {H}{2} {lexeme = yytext(); return ADD3;}

"SUB A,"{REG}{1} {lexeme = yytext(); return SUB1;}
"SUB A,(HL)" {lexeme = yytext(); return SUB2;}
"SUB A," {H}{2} {lexeme = yytext(); return SUB3;}

"ORG "{H}{4} {lexeme = yytext(); return ORG;}

 . |{espacio}+ {lexeme = yytext(); return Other;}