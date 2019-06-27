/* The following code was generated by JFlex 1.7.0 */

/* Archivo con las definiciones léxicas */

/**
 *
 * @author Fabián Ordóñez
 * Jair Villalba
 * Luis Guzman
 */

package lexer;
import static lexer.Tokens.*;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>src/lexer/lexer.flex</tt>
 */
public class Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\4\1\4\1\32\1\32\1\4\22\0\1\12\7\0\1\14"+
    "\1\15\2\0\1\13\3\0\12\1\7\0\1\16\1\23\1\25\1\11"+
    "\1\3\1\1\1\26\1\2\1\24\1\30\1\0\1\10\1\0\1\5"+
    "\1\6\1\7\1\0\1\17\1\21\1\27\1\22\2\0\1\20\1\0"+
    "\1\31\52\0\1\32\u1fa2\0\1\32\1\32\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\16\1\21\0\1\2\1\3\15\0\1\4\1\0"+
    "\1\5\1\0\2\6\10\0\1\7\1\10\10\0\1\11"+
    "\7\0\1\12\2\0\2\13\3\0\2\14\3\0\1\15"+
    "\1\0\1\16\10\0\2\17\4\0\1\20\2\0\1\21"+
    "\10\0\1\22\2\0\1\23\5\0\2\24\3\0\2\25"+
    "\3\0\1\26\1\27\1\30\1\31\1\32\3\0\1\33"+
    "\1\34\1\35\1\0\1\36\1\37\2\0\1\40\5\0"+
    "\1\41\1\42\2\0\1\43\1\44\1\0\1\45\1\0"+
    "\1\46\1\47";

  private static int [] zzUnpackAction() {
    int [] result = new int[173];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\33\0\66\0\121\0\154\0\207\0\242\0\275"+
    "\0\330\0\363\0\u010e\0\u0129\0\u0144\0\u015f\0\u017a\0\u0195"+
    "\0\u01b0\0\u01cb\0\u01e6\0\u0201\0\u021c\0\u0237\0\u0252\0\u026d"+
    "\0\u0288\0\u02a3\0\u02be\0\u02d9\0\u02f4\0\u030f\0\u032a\0\u0345"+
    "\0\33\0\33\0\u0360\0\u037b\0\u0396\0\u03b1\0\u03cc\0\u03e7"+
    "\0\u0402\0\u041d\0\u0438\0\u0453\0\u046e\0\u0489\0\u04a4\0\33"+
    "\0\u04bf\0\33\0\u04da\0\33\0\u04da\0\u04f5\0\u0510\0\u052b"+
    "\0\u0546\0\u0561\0\u057c\0\u0597\0\u05b2\0\33\0\33\0\u05cd"+
    "\0\u05e8\0\u0603\0\u061e\0\u0639\0\u0654\0\u066f\0\u068a\0\33"+
    "\0\u06a5\0\u06c0\0\u06db\0\u06f6\0\u0711\0\u072c\0\u0747\0\33"+
    "\0\u0762\0\u077d\0\33\0\u077d\0\u0798\0\u07b3\0\u07ce\0\33"+
    "\0\u07ce\0\u07e9\0\u0804\0\u081f\0\33\0\u083a\0\33\0\u0855"+
    "\0\u0870\0\u088b\0\u08a6\0\u08c1\0\u08dc\0\u08f7\0\u0912\0\33"+
    "\0\u0912\0\u092d\0\u0948\0\u0963\0\u097e\0\33\0\u0999\0\u09b4"+
    "\0\33\0\u09cf\0\u09ea\0\u0a05\0\u0a20\0\u0a3b\0\u0a56\0\u0a71"+
    "\0\u0a8c\0\33\0\u0aa7\0\u0ac2\0\33\0\u0add\0\u0af8\0\u0b13"+
    "\0\u0b2e\0\u0b49\0\33\0\u0b49\0\u0b64\0\u0b7f\0\u0b9a\0\33"+
    "\0\u0b9a\0\u0bb5\0\u0bd0\0\u0beb\0\33\0\33\0\33\0\33"+
    "\0\33\0\u0c06\0\u0c21\0\u0c3c\0\33\0\33\0\33\0\u0c57"+
    "\0\33\0\33\0\u0c72\0\u0c8d\0\33\0\u0ca8\0\u0cc3\0\u0cde"+
    "\0\u0cf9\0\u0d14\0\33\0\33\0\u0d2f\0\u0d4a\0\33\0\33"+
    "\0\u0d65\0\33\0\u0d80\0\33\0\33";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[173];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\2\2\1\3\1\2\1\4\1\5\1\6\1\2\1\7"+
    "\1\10\4\2\1\11\1\12\1\13\1\14\2\2\1\15"+
    "\1\16\2\2\1\17\1\2\52\0\1\20\20\0\1\4"+
    "\31\0\1\21\2\0\1\22\43\0\1\23\2\0\1\24"+
    "\21\0\1\25\24\0\1\26\34\0\1\27\3\0\1\30"+
    "\31\0\1\31\6\0\1\32\21\0\1\33\46\0\1\34"+
    "\15\0\1\35\34\0\1\36\42\0\1\37\23\0\1\40"+
    "\50\0\1\41\13\0\1\42\35\0\1\43\13\0\1\44"+
    "\33\0\1\45\15\0\1\46\45\0\1\47\16\0\1\50"+
    "\32\0\1\51\46\0\1\52\32\0\1\53\24\0\1\54"+
    "\36\0\1\55\21\0\1\56\12\0\1\57\15\0\1\60"+
    "\34\0\1\61\47\0\1\62\4\0\1\63\1\64\1\65"+
    "\4\0\1\64\1\65\2\0\1\66\1\0\1\65\4\0"+
    "\1\65\1\0\1\65\17\0\1\67\32\0\1\70\22\0"+
    "\2\71\4\0\2\71\2\0\1\72\1\0\1\71\4\0"+
    "\1\71\1\0\1\71\17\0\1\73\32\0\1\74\32\0"+
    "\1\75\36\0\1\76\32\0\1\77\26\0\1\100\32\0"+
    "\1\101\36\0\1\102\26\0\1\103\21\0\1\104\1\0"+
    "\1\104\1\0\1\105\3\0\1\104\4\0\1\104\4\0"+
    "\1\104\1\0\1\106\3\0\1\107\2\0\1\110\1\0"+
    "\1\110\5\0\1\110\4\0\1\110\4\0\1\110\1\0"+
    "\1\110\7\0\1\111\31\0\1\112\1\0\1\112\5\0"+
    "\1\112\4\0\1\112\4\0\1\112\1\0\1\112\21\0"+
    "\1\113\31\0\1\114\20\0\1\115\1\116\1\117\4\0"+
    "\1\116\1\117\4\0\1\117\4\0\1\117\1\0\1\117"+
    "\7\0\2\120\4\0\2\120\2\0\1\121\1\0\1\120"+
    "\4\0\1\120\1\0\1\120\6\0\1\122\1\123\1\124"+
    "\4\0\1\123\1\124\2\0\1\125\1\0\1\124\4\0"+
    "\1\124\1\0\1\124\23\0\1\126\15\0\1\127\1\130"+
    "\1\131\4\0\1\130\1\131\2\0\1\132\1\0\1\131"+
    "\4\0\1\131\1\0\1\131\23\0\1\133\27\0\1\134"+
    "\21\0\2\135\4\0\2\135\2\0\1\136\1\0\1\135"+
    "\4\0\1\135\1\0\1\135\6\0\1\137\1\0\1\137"+
    "\5\0\1\137\4\0\1\137\4\0\1\137\1\0\1\137"+
    "\32\0\1\140\3\0\1\141\2\0\1\137\1\0\1\137"+
    "\5\0\1\137\1\0\1\142\2\0\1\137\4\0\1\137"+
    "\1\0\1\137\20\0\1\143\27\0\1\144\23\0\1\145"+
    "\1\0\1\145\5\0\1\145\4\0\1\145\4\0\1\145"+
    "\1\0\1\145\6\0\1\146\1\0\1\146\5\0\1\146"+
    "\4\0\1\146\4\0\1\146\1\0\1\146\6\0\1\147"+
    "\1\150\1\151\4\0\1\150\1\151\4\0\1\151\4\0"+
    "\1\151\1\0\1\151\6\0\1\152\1\0\1\152\5\0"+
    "\1\152\4\0\1\152\4\0\1\152\1\0\1\152\7\0"+
    "\2\153\4\0\2\153\4\0\1\153\4\0\1\153\1\0"+
    "\1\153\6\0\1\152\1\153\1\154\4\0\1\153\1\154"+
    "\4\0\1\154\4\0\1\154\1\0\1\154\7\0\1\155"+
    "\31\0\1\156\1\0\1\156\5\0\1\156\4\0\1\156"+
    "\4\0\1\156\1\0\1\156\7\0\1\157\43\0\1\160"+
    "\20\0\1\161\1\0\1\161\5\0\1\161\4\0\1\161"+
    "\4\0\1\161\1\0\1\161\7\0\1\162\43\0\1\163"+
    "\33\0\1\164\20\0\1\165\31\0\1\166\1\0\1\166"+
    "\5\0\1\166\4\0\1\166\4\0\1\166\1\0\1\166"+
    "\6\0\1\167\1\0\1\167\5\0\1\167\4\0\1\167"+
    "\4\0\1\167\1\0\1\167\6\0\1\170\1\0\1\170"+
    "\5\0\1\170\4\0\1\170\4\0\1\170\1\0\1\170"+
    "\6\0\1\171\1\0\1\171\5\0\1\171\4\0\1\171"+
    "\4\0\1\171\1\0\1\171\22\0\1\172\16\0\1\173"+
    "\1\0\1\173\5\0\1\173\4\0\1\173\4\0\1\173"+
    "\1\0\1\173\6\0\1\174\1\0\1\174\5\0\1\174"+
    "\4\0\1\174\4\0\1\174\1\0\1\174\6\0\1\175"+
    "\1\0\1\175\5\0\1\175\4\0\1\175\4\0\1\175"+
    "\1\0\1\175\6\0\1\176\1\0\1\176\5\0\1\176"+
    "\4\0\1\176\4\0\1\176\1\0\1\176\22\0\1\177"+
    "\16\0\1\176\1\0\1\176\5\0\1\176\3\0\1\177"+
    "\1\176\4\0\1\176\1\0\1\176\15\0\1\200\32\0"+
    "\1\201\23\0\1\202\1\203\1\204\4\0\1\203\1\204"+
    "\2\0\1\205\1\0\1\204\4\0\1\204\1\0\1\204"+
    "\15\0\1\206\23\0\1\207\1\210\1\211\4\0\1\210"+
    "\1\211\2\0\1\212\1\0\1\211\4\0\1\211\1\0"+
    "\1\211\6\0\1\213\1\0\1\213\5\0\1\213\4\0"+
    "\1\213\4\0\1\213\1\0\1\213\15\0\1\214\23\0"+
    "\1\215\1\0\1\215\5\0\1\215\4\0\1\215\4\0"+
    "\1\215\1\0\1\215\6\0\1\216\1\0\1\216\5\0"+
    "\1\216\4\0\1\216\4\0\1\216\1\0\1\216\6\0"+
    "\1\217\1\0\1\217\5\0\1\217\4\0\1\217\4\0"+
    "\1\217\1\0\1\217\6\0\1\220\1\0\1\220\5\0"+
    "\1\220\4\0\1\220\4\0\1\220\1\0\1\220\6\0"+
    "\1\221\1\0\1\221\5\0\1\221\4\0\1\221\4\0"+
    "\1\221\1\0\1\221\22\0\1\222\16\0\1\223\1\0"+
    "\1\223\5\0\1\223\4\0\1\223\4\0\1\223\1\0"+
    "\1\223\20\0\1\224\34\0\1\225\32\0\1\226\16\0"+
    "\1\227\1\0\1\227\5\0\1\227\4\0\1\227\4\0"+
    "\1\227\1\0\1\227\7\0\1\230\45\0\1\231\16\0"+
    "\1\232\1\0\1\232\5\0\1\232\4\0\1\232\4\0"+
    "\1\232\1\0\1\232\7\0\1\233\31\0\1\234\1\0"+
    "\1\234\5\0\1\234\4\0\1\234\4\0\1\234\1\0"+
    "\1\234\22\0\1\235\30\0\1\236\34\0\1\237\16\0"+
    "\1\240\1\0\1\240\5\0\1\240\4\0\1\240\4\0"+
    "\1\240\1\0\1\240\15\0\1\241\32\0\1\242\37\0"+
    "\1\243\33\0\1\244\27\0\1\245\20\0\1\246\1\0"+
    "\1\246\5\0\1\246\4\0\1\246\4\0\1\246\1\0"+
    "\1\246\22\0\1\247\32\0\1\250\17\0\1\251\13\0"+
    "\1\252\15\0\1\253\1\0\1\253\5\0\1\253\4\0"+
    "\1\253\4\0\1\253\1\0\1\253\15\0\1\254\23\0"+
    "\1\255\1\0\1\255\5\0\1\255\4\0\1\255\4\0"+
    "\1\255\1\0\1\255\5\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3483];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\15\1\21\0\2\11\15\0\1\11\1\0"+
    "\1\11\1\0\1\11\1\1\10\0\2\11\10\0\1\11"+
    "\7\0\1\11\2\0\1\11\1\1\3\0\1\11\1\1"+
    "\3\0\1\11\1\0\1\11\10\0\1\11\1\1\4\0"+
    "\1\11\2\0\1\11\10\0\1\11\2\0\1\11\5\0"+
    "\1\11\1\1\3\0\1\11\1\1\3\0\5\11\3\0"+
    "\3\11\1\0\2\11\2\0\1\11\5\0\2\11\2\0"+
    "\2\11\1\0\1\11\1\0\2\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[173];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true iff the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true iff the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
    public String lexeme;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 126) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Tokens yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { lexeme = yytext(); return Other;
            } 
            // fall through
          case 40: break;
          case 2: 
            { lexeme = yytext(); return NEG;
            } 
            // fall through
          case 41: break;
          case 3: 
            { return NOP;
            } 
            // fall through
          case 42: break;
          case 4: 
            { lexeme = yytext(); return CPL;
            } 
            // fall through
          case 43: break;
          case 5: 
            { lexeme = yytext(); return HALT;
            } 
            // fall through
          case 44: break;
          case 6: 
            { lexeme = yytext(); return OR1;
            } 
            // fall through
          case 45: break;
          case 7: 
            { lexeme = yytext(); return RLCA;
            } 
            // fall through
          case 46: break;
          case 8: 
            { lexeme = yytext(); return RRCA;
            } 
            // fall through
          case 47: break;
          case 9: 
            { lexeme = yytext(); return OR3;
            } 
            // fall through
          case 48: break;
          case 10: 
            { lexeme = yytext(); return DEC1;
            } 
            // fall through
          case 49: break;
          case 11: 
            { lexeme = yytext(); return AND1;
            } 
            // fall through
          case 50: break;
          case 12: 
            { lexeme = yytext(); return XOR1;
            } 
            // fall through
          case 51: break;
          case 13: 
            { lexeme = yytext(); return INC1;
            } 
            // fall through
          case 52: break;
          case 14: 
            { lexeme = yytext(); return JR1;
            } 
            // fall through
          case 53: break;
          case 15: 
            { lexeme = yytext(); return LD1;
            } 
            // fall through
          case 54: break;
          case 16: 
            { lexeme = yytext(); return AND3;
            } 
            // fall through
          case 55: break;
          case 17: 
            { lexeme = yytext(); return XOR3;
            } 
            // fall through
          case 56: break;
          case 18: 
            { lexeme = yytext(); return OR2;
            } 
            // fall through
          case 57: break;
          case 19: 
            { lexeme = yytext(); return LD2;
            } 
            // fall through
          case 58: break;
          case 20: 
            { lexeme = yytext(); return ADD1;
            } 
            // fall through
          case 59: break;
          case 21: 
            { lexeme = yytext(); return SUB1;
            } 
            // fall through
          case 60: break;
          case 22: 
            { lexeme = yytext(); return JR5;
            } 
            // fall through
          case 61: break;
          case 23: 
            { lexeme = yytext(); return JR4;
            } 
            // fall through
          case 62: break;
          case 24: 
            { lexeme = yytext(); return JR3;
            } 
            // fall through
          case 63: break;
          case 25: 
            { lexeme = yytext(); return JR2;
            } 
            // fall through
          case 64: break;
          case 26: 
            { lexeme = yytext(); return ORG;
            } 
            // fall through
          case 65: break;
          case 27: 
            { lexeme = yytext(); return DEC2;
            } 
            // fall through
          case 66: break;
          case 28: 
            { lexeme = yytext(); return AND2;
            } 
            // fall through
          case 67: break;
          case 29: 
            { lexeme = yytext(); return ADD3;
            } 
            // fall through
          case 68: break;
          case 30: 
            { lexeme = yytext(); return XOR2;
            } 
            // fall through
          case 69: break;
          case 31: 
            { lexeme = yytext(); return SUB3;
            } 
            // fall through
          case 70: break;
          case 32: 
            { lexeme = yytext(); return INC2;
            } 
            // fall through
          case 71: break;
          case 33: 
            { lexeme = yytext(); return IN;
            } 
            // fall through
          case 72: break;
          case 34: 
            { lexeme = yytext(); return OUT;
            } 
            // fall through
          case 73: break;
          case 35: 
            { lexeme = yytext(); return ADD2;
            } 
            // fall through
          case 74: break;
          case 36: 
            { lexeme = yytext(); return SUB2;
            } 
            // fall through
          case 75: break;
          case 37: 
            { lexeme = yytext(); return LD4;
            } 
            // fall through
          case 76: break;
          case 38: 
            { lexeme = yytext(); return LD5;
            } 
            // fall through
          case 77: break;
          case 39: 
            { lexeme = yytext(); return LD3;
            } 
            // fall through
          case 78: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
