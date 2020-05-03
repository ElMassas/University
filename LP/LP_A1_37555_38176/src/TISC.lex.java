import java_cup.runtime.Symbol;


class Yylex {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 128;
	private final int YY_EOF = 129;

  private Symbol token(int id, Object value) {
    return new Symbol(id, yychar, yyline, value);
  }
  private Symbol token(int id) {
    return token(id, yytext());
  }
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yychar;
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	Yylex (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	Yylex (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Yylex () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yychar = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yychar = yychar
			+ yy_buffer_index - yy_buffer_start;
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NOT_ACCEPT,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NOT_ACCEPT,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NO_ANCHOR,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NO_ANCHOR,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NO_ANCHOR,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NO_ANCHOR,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NO_ANCHOR,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NO_ANCHOR,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NO_ANCHOR,
		/* 92 */ YY_NO_ANCHOR,
		/* 93 */ YY_NO_ANCHOR,
		/* 94 */ YY_NO_ANCHOR,
		/* 95 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,130,
"32:9,33,30,32:2,29,32:18,33,32,27,31,32:9,26,32:2,24:10,25,32:6,23:26,32,28" +
",32:2,16,32,1,5,20,2,12,23,19,15,9,21,23,7,6,17,11,14,22,18,3,8,4,10,23,13," +
"23:2,32:5,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,96,
"0,1,2,1,3,1:2,4,1,5:10,6,5:10,7,8,3,9,10,7,11,12,13,14,15,16,17,18,19,20,21" +
",22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46" +
",47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,5,63,64,65,66,67,68,69")[0];

	private int yy_nxt[][] = unpackFromString(70,34,
"1,2,79,87,88:2,89,90,88:4,91,88,92,88,3,88,93,88,94,95,88:2,4,5,32,35,3,-1," +
"6,7,3,6,-1:35,88,31,88:22,-1:33,4,-1:10,7:28,-1:2,7:3,-1,88:24,-1:10,88:15," +
"70,88:8,-1:10,30:26,8,33,30:5,-1,88,9,88:22,-1:36,30:2,-1:6,88:9,10,88:14,-" +
"1:10,88:4,11,88:19,-1:10,88:10,48,88:13,-1:10,88:7,49,88:16,-1:10,88:6,50,8" +
"8:17,-1:10,88,12,88:22,-1:10,88:19,51,88:4,-1:10,88:13,13,88:10,-1:10,88:2," +
"52,88:21,-1:10,88:8,53,88:15,-1:10,88:5,56,88:18,-1:10,88:7,14,88:16,-1:10," +
"88:21,15,88:2,-1:10,88:17,57,88:6,-1:10,88:15,82,88:8,-1:10,88:7,16,88:16,-" +
"1:10,58,88:23,-1:10,88:14,59,88:9,-1:10,88:16,60,88:7,-1:10,88:3,61,88:20,-" +
"1:10,88:6,17,88:17,-1:10,88:13,18,88:10,-1:10,88:11,83,88:12,-1:10,88:6,62," +
"88:17,-1:10,88:15,63,88:8,-1:10,88:7,19,88:16,-1:10,88:17,64,88:6,-1:10,88:" +
"2,20,88:21,-1:10,67,88:7,68,69,88:14,-1:10,88:16,21,88:7,-1:10,85,88:8,86,8" +
"8:14,-1:10,88:18,22,88:5,-1:10,88:17,71,88:6,-1:10,88:16,72,88:7,-1:10,73,8" +
"8:23,-1:10,88:2,74,88:13,75,88:7,-1:10,88:18,23,88:5,-1:10,88:7,24,88:16,-1" +
":10,88:17,25,88:6,-1:10,88:7,78,88:16,-1:10,88:6,26,88:17,-1:10,88:18,27,88" +
":5,-1:10,88:17,28,88:6,-1:10,88:17,29,88:6,-1:10,88:8,34,88:15,-1:10,88:7,5" +
"4,88:16,-1:10,88:6,55,88:17,-1:10,84,88:23,-1:10,88:15,65,88:8,-1:10,88:17," +
"66,88:6,-1:10,88:17,76,88:6,-1:10,77,88:23,-1:10,88:3,36,88:3,37,88:3,38,88" +
":12,-1:10,88:3,39,88:6,40,88:13,-1:10,88:10,41,88:13,-1:10,88:12,42,88:11,-" +
"1:10,88:3,43,88:13,44,88:6,-1:10,88:11,80,88:12,-1:10,81,88:23,-1:10,88:3,4" +
"5,88:2,46,88:4,47,88:12,-1:9");

	public Symbol yylex ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {

  return token(sym.EOF);
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -3:
						break;
					case 3:
						{
	        System.err.println("** Invalid Charecter: `" + yytext() + "'");
		return token(sym.ERROR);
	      }
					case -4:
						break;
					case 4:
						{ return token(sym.INTEGER, yytext()); }
					case -5:
						break;
					case 5:
						{ return token(sym.TWO_POINTS); }
					case -6:
						break;
					case 6:
						{ /* ignore white spaces */ }
					case -7:
						break;
					case 7:
						{ /* e comments */ }
					case -8:
						break;
					case 8:
						{
			  String s = yytext();
			  return token(sym.STRING, s.substring(1,s.length()-1));
			}
					case -9:
						break;
					case 9:
						{ return token(sym.ADD); }
					case -10:
						break;
					case 10:
						{ return token(sym.DIV); }
					case -11:
						break;
					case 11:
						{ return token(sym.SUB); }
					case -12:
						break;
					case 12:
						{ return token(sym.MOD); }
					case -13:
						break;
					case 13:
						{ return token(sym.EXP); }
					case -14:
						break;
					case 14:
						{ return token(sym.JLT); }
					case -15:
						break;
					case 15:
						{ return token(sym.JEQ); }
					case -16:
						break;
					case 16:
						{ return token(sym.MULT); }
					case -17:
						break;
					case 17:
						{ return token(sym.CALL); }
					case -18:
						break;
					case 18:
						{ return token(sym.JUMP); }
					case -19:
						break;
					case 19:
						{ return token(sym.PRINT); }
					case -20:
						break;
					case 20:
						{ return token(sym.LOCALS); }
					case -21:
						break;
					case 21:
						{ return token(sym.RETURN); }
					case -22:
						break;
					case 22:
						{ return token(sym.SET_ARG); }
					case -23:
						break;
					case 23:
						{ return token(sym.PUSH_ARG); }
					case -24:
						break;
					case 24:
						{ return token(sym.PUSH_INT); }
					case -25:
						break;
					case 25:
						{ return token(sym.PUSH_VAR); }
					case -26:
						break;
					case 26:
						{ return token(sym.PRINT_NL); }
					case -27:
						break;
					case 27:
						{ return token(sym.STORE_ARG); }
					case -28:
						break;
					case 28:
						{ return token(sym.STORE_VAR); }
					case -29:
						break;
					case 29:
						{ return token(sym.PRINT_STR); }
					case -30:
						break;
					case 31:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -31:
						break;
					case 32:
						{
	        System.err.println("** Invalid Charecter: `" + yytext() + "'");
		return token(sym.ERROR);
	      }
					case -32:
						break;
					case 34:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -33:
						break;
					case 35:
						{
	        System.err.println("** Invalid Charecter: `" + yytext() + "'");
		return token(sym.ERROR);
	      }
					case -34:
						break;
					case 36:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -35:
						break;
					case 37:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -36:
						break;
					case 38:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -37:
						break;
					case 39:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -38:
						break;
					case 40:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -39:
						break;
					case 41:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -40:
						break;
					case 42:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -41:
						break;
					case 43:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -42:
						break;
					case 44:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -43:
						break;
					case 45:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -44:
						break;
					case 46:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -45:
						break;
					case 47:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -46:
						break;
					case 48:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -47:
						break;
					case 49:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -48:
						break;
					case 50:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -49:
						break;
					case 51:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -50:
						break;
					case 52:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -51:
						break;
					case 53:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -52:
						break;
					case 54:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -53:
						break;
					case 55:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -54:
						break;
					case 56:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -55:
						break;
					case 57:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -56:
						break;
					case 58:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -57:
						break;
					case 59:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -58:
						break;
					case 60:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -59:
						break;
					case 61:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -60:
						break;
					case 62:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -61:
						break;
					case 63:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -62:
						break;
					case 64:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -63:
						break;
					case 65:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -64:
						break;
					case 66:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -65:
						break;
					case 67:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -66:
						break;
					case 68:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -67:
						break;
					case 69:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -68:
						break;
					case 70:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -69:
						break;
					case 71:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -70:
						break;
					case 72:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -71:
						break;
					case 73:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -72:
						break;
					case 74:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -73:
						break;
					case 75:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -74:
						break;
					case 76:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -75:
						break;
					case 77:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -76:
						break;
					case 78:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -77:
						break;
					case 79:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -78:
						break;
					case 80:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -79:
						break;
					case 81:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -80:
						break;
					case 82:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -81:
						break;
					case 83:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -82:
						break;
					case 84:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -83:
						break;
					case 85:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -84:
						break;
					case 86:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -85:
						break;
					case 87:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -86:
						break;
					case 88:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -87:
						break;
					case 89:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -88:
						break;
					case 90:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -89:
						break;
					case 91:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -90:
						break;
					case 92:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -91:
						break;
					case 93:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -92:
						break;
					case 94:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -93:
						break;
					case 95:
						{ return token(sym.IDENTIFIER, yytext()); }
					case -94:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
