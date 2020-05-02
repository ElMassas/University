import java_cup.runtime.Symbol;

%%

%char
%line

%type Symbol

%{
  private Symbol token(int id, Object value) {
    return new Symbol(id, yychar, yyline, value);
  }

  private Symbol token(int id) {
    return token(id, yytext());
  }
%}

%eofval{
  return token(sym.EOF);
%eofval}

%%

add			{ return token(sym.ADD); }
sub			{ return token(sym.SUB); }
mult		{ return token(sym.MULT); }
div			{ return token(sym.DIV); }
mod			{ return token(sym.MOD); }
exp			{ return token(sym.EXP); }

push_int		{ return token(sym.PUSH_INT); }
push_var		{ return token(sym.PUSH_VAR); }
push_arg		{ return token(sym.PUSH_ARG); }

store_var		{ return token(sym.STORE_VAR); }
store_arg		{ return token(sym.STORE_ARG); }

set_arg			{ return token(sym.SET_ARG); }
call			{ return token(sym.CALL); }
locals			{ return token(sym.LOCALS); }
return			{ return token(sym.RETURN); }

jump			{ return token(sym.JUMP); }
jeq			{ return token(sym.JEQ); }
jlt			{ return token(sym.JLT); }

print			{ return token(sym.PRINT); }
print_str			{ return token(sym.PRINT_STR); }
print_nl			{ return token(sym.PRINT_NL); }

[a-zA-Z][a-zA-Z0-9_]*	{ return token(sym.IDENTIFIER, yytext()); }

:			{ return token(sym.TWO_POINTS); }

-?[0-9]+		{ return token(sym.INTEGER, yytext()); }
\"(\\[\\\"]|[^\"\\])*\"	{
			  String s = yytext();

			  return token(sym.STRING, s.substring(1,s.length()-1));
			}

[\ \n\t]		{ /* ignore white spaces */ }

#.*			{ /* e comments */ }

.	      {
	        System.err.println("** Invalid Charecter: `" + yytext() + "'");

		return token(sym.ERROR);
	      }
