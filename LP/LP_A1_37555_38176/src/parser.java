
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

import java_cup.runtime.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\032\000\002\002\005\000\002\002\004\000\002\002" +
    "\002\000\002\003\004\000\002\003\002\000\002\004\003" +
    "\000\002\004\003\000\002\004\003\000\002\004\003\000" +
    "\002\004\003\000\002\004\003\000\002\004\004\000\002" +
    "\004\005\000\002\004\005\000\002\004\005\000\002\004" +
    "\005\000\002\004\004\000\002\004\005\000\002\004\005" +
    "\000\002\004\003\000\002\004\004\000\002\004\004\000" +
    "\002\004\004\000\002\004\003\000\002\004\004\000\002" +
    "\004\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\056\000\060\002\uffff\004\uffff\005\uffff\006\uffff\007" +
    "\uffff\010\uffff\011\uffff\012\uffff\013\uffff\014\uffff\015\uffff" +
    "\016\uffff\017\uffff\020\uffff\021\uffff\022\uffff\023\uffff\024" +
    "\uffff\025\uffff\026\uffff\027\uffff\030\uffff\031\uffff\001\002" +
    "\000\060\002\007\004\ufffd\005\ufffd\006\ufffd\007\ufffd\010" +
    "\ufffd\011\ufffd\012\ufffd\013\ufffd\014\ufffd\015\ufffd\016\ufffd" +
    "\017\ufffd\020\ufffd\021\ufffd\022\ufffd\023\ufffd\024\ufffd\025" +
    "\ufffd\026\ufffd\027\ufffd\030\ufffd\031\006\001\002\000\054" +
    "\004\031\005\024\006\026\007\030\010\013\011\022\012" +
    "\015\013\012\014\020\015\023\016\034\017\016\020\014" +
    "\021\036\022\017\023\025\024\032\025\011\026\033\027" +
    "\021\030\027\001\002\000\004\034\010\001\002\000\004" +
    "\002\000\001\002\000\054\004\ufffe\005\ufffe\006\ufffe\007" +
    "\ufffe\010\ufffe\011\ufffe\012\ufffe\013\ufffe\014\ufffe\015\ufffe" +
    "\016\ufffe\017\ufffe\020\ufffe\021\ufffe\022\ufffe\023\ufffe\024" +
    "\ufffe\025\ufffe\026\ufffe\027\ufffe\030\ufffe\001\002\000\004" +
    "\031\060\001\002\000\004\032\056\001\002\000\060\002" +
    "\ufff8\004\ufff8\005\ufff8\006\ufff8\007\ufff8\010\ufff8\011\ufff8" +
    "\012\ufff8\013\ufff8\014\ufff8\015\ufff8\016\ufff8\017\ufff8\020" +
    "\ufff8\021\ufff8\022\ufff8\023\ufff8\024\ufff8\025\ufff8\026\ufff8" +
    "\027\ufff8\030\ufff8\031\ufff8\001\002\000\004\032\054\001" +
    "\002\000\004\032\053\001\002\000\004\032\052\001\002" +
    "\000\060\002\uffee\004\uffee\005\uffee\006\uffee\007\uffee\010" +
    "\uffee\011\uffee\012\uffee\013\uffee\014\uffee\015\uffee\016\uffee" +
    "\017\uffee\020\uffee\021\uffee\022\uffee\023\uffee\024\uffee\025" +
    "\uffee\026\uffee\027\uffee\030\uffee\031\uffee\001\002\000\004" +
    "\032\050\001\002\000\004\033\047\001\002\000\060\002" +
    "\ufff7\004\ufff7\005\ufff7\006\ufff7\007\ufff7\010\ufff7\011\ufff7" +
    "\012\ufff7\013\ufff7\014\ufff7\015\ufff7\016\ufff7\017\ufff7\020" +
    "\ufff7\021\ufff7\022\ufff7\023\ufff7\024\ufff7\025\ufff7\026\ufff7" +
    "\027\ufff7\030\ufff7\031\ufff7\001\002\000\004\032\045\001" +
    "\002\000\060\002\ufffb\004\ufffb\005\ufffb\006\ufffb\007\ufffb" +
    "\010\ufffb\011\ufffb\012\ufffb\013\ufffb\014\ufffb\015\ufffb\016" +
    "\ufffb\017\ufffb\020\ufffb\021\ufffb\022\ufffb\023\ufffb\024\ufffb" +
    "\025\ufffb\026\ufffb\027\ufffb\030\ufffb\031\ufffb\001\002\000" +
    "\004\031\044\001\002\000\060\002\ufffa\004\ufffa\005\ufffa" +
    "\006\ufffa\007\ufffa\010\ufffa\011\ufffa\012\ufffa\013\ufffa\014" +
    "\ufffa\015\ufffa\016\ufffa\017\ufffa\020\ufffa\021\ufffa\022\ufffa" +
    "\023\ufffa\024\ufffa\025\ufffa\026\ufffa\027\ufffa\030\ufffa\031" +
    "\ufffa\001\002\000\060\002\uffe8\004\uffe8\005\uffe8\006\uffe8" +
    "\007\uffe8\010\uffe8\011\uffe8\012\uffe8\013\uffe8\014\uffe8\015" +
    "\uffe8\016\uffe8\017\uffe8\020\uffe8\021\uffe8\022\uffe8\023\uffe8" +
    "\024\uffe8\025\uffe8\026\uffe8\027\uffe8\030\uffe8\031\uffe8\001" +
    "\002\000\060\002\ufff9\004\ufff9\005\ufff9\006\ufff9\007\ufff9" +
    "\010\ufff9\011\ufff9\012\ufff9\013\ufff9\014\ufff9\015\ufff9\016" +
    "\ufff9\017\ufff9\020\ufff9\021\ufff9\022\ufff9\023\ufff9\024\ufff9" +
    "\025\ufff9\026\ufff9\027\ufff9\030\ufff9\031\ufff9\001\002\000" +
    "\060\002\ufffc\004\ufffc\005\ufffc\006\ufffc\007\ufffc\010\ufffc" +
    "\011\ufffc\012\ufffc\013\ufffc\014\ufffc\015\ufffc\016\ufffc\017" +
    "\ufffc\020\ufffc\021\ufffc\022\ufffc\023\ufffc\024\ufffc\025\ufffc" +
    "\026\ufffc\027\ufffc\030\ufffc\031\ufffc\001\002\000\004\031" +
    "\043\001\002\000\060\002\uffea\004\uffea\005\uffea\006\uffea" +
    "\007\uffea\010\uffea\011\uffea\012\uffea\013\uffea\014\uffea\015" +
    "\uffea\016\uffea\017\uffea\020\uffea\021\uffea\022\uffea\023\uffea" +
    "\024\uffea\025\uffea\026\uffea\027\uffea\030\uffea\031\uffea\001" +
    "\002\000\004\032\041\001\002\000\060\002\001\004\001" +
    "\005\001\006\001\007\001\010\001\011\001\012\001\013" +
    "\001\014\001\015\001\016\001\017\001\020\001\021\001" +
    "\022\001\023\001\024\001\025\001\026\001\027\001\030" +
    "\001\031\001\001\002\000\004\032\037\001\002\000\004" +
    "\031\040\001\002\000\060\002\uffef\004\uffef\005\uffef\006" +
    "\uffef\007\uffef\010\uffef\011\uffef\012\uffef\013\uffef\014\uffef" +
    "\015\uffef\016\uffef\017\uffef\020\uffef\021\uffef\022\uffef\023" +
    "\uffef\024\uffef\025\uffef\026\uffef\027\uffef\030\uffef\031\uffef" +
    "\001\002\000\004\032\042\001\002\000\060\002\ufff2\004" +
    "\ufff2\005\ufff2\006\ufff2\007\ufff2\010\ufff2\011\ufff2\012\ufff2" +
    "\013\ufff2\014\ufff2\015\ufff2\016\ufff2\017\ufff2\020\ufff2\021" +
    "\ufff2\022\ufff2\023\ufff2\024\ufff2\025\ufff2\026\ufff2\027\ufff2" +
    "\030\ufff2\031\ufff2\001\002\000\060\002\uffec\004\uffec\005" +
    "\uffec\006\uffec\007\uffec\010\uffec\011\uffec\012\uffec\013\uffec" +
    "\014\uffec\015\uffec\016\uffec\017\uffec\020\uffec\021\uffec\022" +
    "\uffec\023\uffec\024\uffec\025\uffec\026\uffec\027\uffec\030\uffec" +
    "\031\uffec\001\002\000\060\002\uffed\004\uffed\005\uffed\006" +
    "\uffed\007\uffed\010\uffed\011\uffed\012\uffed\013\uffed\014\uffed" +
    "\015\uffed\016\uffed\017\uffed\020\uffed\021\uffed\022\uffed\023" +
    "\uffed\024\uffed\025\uffed\026\uffed\027\uffed\030\uffed\031\uffed" +
    "\001\002\000\004\032\046\001\002\000\060\002\ufff4\004" +
    "\ufff4\005\ufff4\006\ufff4\007\ufff4\010\ufff4\011\ufff4\012\ufff4" +
    "\013\ufff4\014\ufff4\015\ufff4\016\ufff4\017\ufff4\020\ufff4\021" +
    "\ufff4\022\ufff4\023\ufff4\024\ufff4\025\ufff4\026\ufff4\027\ufff4" +
    "\030\ufff4\031\ufff4\001\002\000\060\002\uffe9\004\uffe9\005" +
    "\uffe9\006\uffe9\007\uffe9\010\uffe9\011\uffe9\012\uffe9\013\uffe9" +
    "\014\uffe9\015\uffe9\016\uffe9\017\uffe9\020\uffe9\021\uffe9\022" +
    "\uffe9\023\uffe9\024\uffe9\025\uffe9\026\uffe9\027\uffe9\030\uffe9" +
    "\031\uffe9\001\002\000\004\032\051\001\002\000\060\002" +
    "\ufff3\004\ufff3\005\ufff3\006\ufff3\007\ufff3\010\ufff3\011\ufff3" +
    "\012\ufff3\013\ufff3\014\ufff3\015\ufff3\016\ufff3\017\ufff3\020" +
    "\ufff3\021\ufff3\022\ufff3\023\ufff3\024\ufff3\025\ufff3\026\ufff3" +
    "\027\ufff3\030\ufff3\031\ufff3\001\002\000\060\002\ufff1\004" +
    "\ufff1\005\ufff1\006\ufff1\007\ufff1\010\ufff1\011\ufff1\012\ufff1" +
    "\013\ufff1\014\ufff1\015\ufff1\016\ufff1\017\ufff1\020\ufff1\021" +
    "\ufff1\022\ufff1\023\ufff1\024\ufff1\025\ufff1\026\ufff1\027\ufff1" +
    "\030\ufff1\031\ufff1\001\002\000\060\002\ufff6\004\ufff6\005" +
    "\ufff6\006\ufff6\007\ufff6\010\ufff6\011\ufff6\012\ufff6\013\ufff6" +
    "\014\ufff6\015\ufff6\016\ufff6\017\ufff6\020\ufff6\021\ufff6\022" +
    "\ufff6\023\ufff6\024\ufff6\025\ufff6\026\ufff6\027\ufff6\030\ufff6" +
    "\031\ufff6\001\002\000\004\031\055\001\002\000\060\002" +
    "\ufff0\004\ufff0\005\ufff0\006\ufff0\007\ufff0\010\ufff0\011\ufff0" +
    "\012\ufff0\013\ufff0\014\ufff0\015\ufff0\016\ufff0\017\ufff0\020" +
    "\ufff0\021\ufff0\022\ufff0\023\ufff0\024\ufff0\025\ufff0\026\ufff0" +
    "\027\ufff0\030\ufff0\031\ufff0\001\002\000\004\032\057\001" +
    "\002\000\060\002\ufff5\004\ufff5\005\ufff5\006\ufff5\007\ufff5" +
    "\010\ufff5\011\ufff5\012\ufff5\013\ufff5\014\ufff5\015\ufff5\016" +
    "\ufff5\017\ufff5\020\ufff5\021\ufff5\022\ufff5\023\ufff5\024\ufff5" +
    "\025\ufff5\026\ufff5\027\ufff5\030\ufff5\031\ufff5\001\002\000" +
    "\060\002\uffeb\004\uffeb\005\uffeb\006\uffeb\007\uffeb\010\uffeb" +
    "\011\uffeb\012\uffeb\013\uffeb\014\uffeb\015\uffeb\016\uffeb\017" +
    "\uffeb\020\uffeb\021\uffeb\022\uffeb\023\uffeb\024\uffeb\025\uffeb" +
    "\026\uffeb\027\uffeb\030\uffeb\031\uffeb\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\056\000\004\002\003\001\001\000\004\003\004\001" +
    "\001\000\004\004\034\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  /** User initialization code. */
  public void user_init() throws java.lang.Exception
    {
 lexer = new Yylex(System.in); 
    }

  /** Scan to get the next Symbol. */
  public java_cup.runtime.Symbol scan()
    throws java.lang.Exception
    {
 return lexer.yylex(); 
    }


  Yylex lexer;

  public void report_error(String message, Object error_info) {
    Symbol info = (Symbol) error_info;

    System.err.print("** " + message);
    System.err.println(" at `" + info.value + "' in position " + info.left
		       + " **");
  }

  public void report_fatal_error(String message, Object empty) {
    System.err.println("** " + message);
  }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {


  // creates an instance of the TISC
  TISC program = new TISC();

  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // program ::= program tag instruction 
            {
              TISC RESULT =null;
		 RESULT = TISC; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("program",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= program EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		TISC start_val = (TISC)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // program ::= 
            {
              TISC RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("program",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // tag ::= IDENTIFIER TWO_POINTS 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("tag",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // tag ::= 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("tag",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // instruction ::= ADD 
            {
              Object RESULT =null;
		 TISC.getOperationsList().add(new Add()); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruction",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // instruction ::= SUB 
            {
              Object RESULT =null;
		 TISC.getOperationsList().add(new Sub()); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruction",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // instruction ::= MULT 
            {
              Object RESULT =null;
		 TISC.getOperationsList().add(new Mult()); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruction",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // instruction ::= DIV 
            {
              Object RESULT =null;
		 TISC.getOperationsList().add(new Div()); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruction",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // instruction ::= MOD 
            {
              Object RESULT =null;
		 TISC.getOperationsList().add(new Mod()); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruction",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // instruction ::= EXP 
            {
              Object RESULT =null;
		 TISC.getOperationsList().add(new Exp()); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruction",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // instruction ::= PUSH_INT INTEGER 
            {
              Object RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 TISC.getOperationsList().add(new PushInt(i)); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruction",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // instruction ::= PUSH_VAR INTEGER INTEGER 
            {
              Object RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String d = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int nleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String n = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 TISC.getOperationsList().add(new PushVariables(d, n)); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruction",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // instruction ::= PUSH_ARG INTEGER INTEGER 
            {
              Object RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String d = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int nleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String n = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 TISC.getOperationsList().add(new PushArguments(d, n)); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruction",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // instruction ::= STORE_VAR INTEGER INTEGER 
            {
              Object RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String d = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int nleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String n = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 TISC.getOperationsList().add(new StoreVariables(d, n)); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruction",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // instruction ::= STORE_ARG INTEGER INTEGER 
            {
              Object RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String d = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int nleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String n = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 TISC.getOperationsList().add(new StoreArguments(d, n)); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruction",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // instruction ::= SET_ARG INTEGER 
            {
              Object RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String n = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 TISC.getOperationsList().add(new SetArguments(n)); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruction",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // instruction ::= CALL INTEGER IDENTIFIER 
            {
              Object RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String d = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int pleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int pright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String p = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 TISC.getOperationsList().add(new Call(d, p)); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruction",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // instruction ::= LOCALS INTEGER IDENTIFIER 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int vleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String v = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 TISC.getOperationsList().add(new Locals(a, v)); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruction",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // instruction ::= RETURN 
            {
              Object RESULT =null;
		 TISC.getOperationsList().add(new Return()); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruction",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // instruction ::= JUMP IDENTIFIER 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 TISC.getOperationsList().add(new Jump(e)); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruction",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // instruction ::= JEQ IDENTIFIER 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 TISC.getOperationsList().add(new Jeq(e)); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruction",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // instruction ::= JLT IDENTIFIER 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 TISC.getOperationsList().add(new Jlt(e)); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruction",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // instruction ::= PRINT 
            {
              Object RESULT =null;
		 TISC.getOperationsList().add(new Print()); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruction",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // instruction ::= PRINT_STR STRING 
            {
              Object RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String s = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 TISC.getOperationsList().add(new PrintString(s)); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruction",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // instruction ::= PRINT_NL 
            {
              Object RESULT =null;
		 TISC.getOperationsList().add(new PrintNewLine()); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruction",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}
