// Generated from PK.g4 by ANTLR 4.0

    package com.emergya.geoservices.search.antlr4;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PKLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__3=1, T__2=2, T__1=3, T__0=4, Name=5, Int=6, WS=7, NL=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'km'", "'pk'", "','", "'\"'", "Name", "Int", "WS", "'\n'"
	};
	public static final String[] ruleNames = {
		"T__3", "T__2", "T__1", "T__0", "Name", "Int", "WS", "NL"
	};


	public PKLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PK.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\2\4\n\61\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\6\6\37\n\6\r\6\16"+
		"\6 \3\6\3\6\3\6\3\7\6\7\'\n\7\r\7\16\7(\3\b\6\b,\n\b\r\b\16\b-\3\t\3\t"+
		"\2\n\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\3\2\4\4C\\c|\4"+
		"\13\13\"\"\63\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3\23\3\2\2\2\5\26\3\2\2\2\7"+
		"\31\3\2\2\2\t\33\3\2\2\2\13\36\3\2\2\2\r&\3\2\2\2\17+\3\2\2\2\21/\3\2"+
		"\2\2\23\24\7m\2\2\24\25\7o\2\2\25\4\3\2\2\2\26\27\7r\2\2\27\30\7m\2\2"+
		"\30\6\3\2\2\2\31\32\7.\2\2\32\b\3\2\2\2\33\34\7$\2\2\34\n\3\2\2\2\35\37"+
		"\t\2\2\2\36\35\3\2\2\2\37 \3\2\2\2 \36\3\2\2\2 !\3\2\2\2!\"\3\2\2\2\""+
		"#\7/\2\2#$\5\r\7\2$\f\3\2\2\2%\'\4\62;\2&%\3\2\2\2\'(\3\2\2\2(&\3\2\2"+
		"\2()\3\2\2\2)\16\3\2\2\2*,\t\3\2\2+*\3\2\2\2,-\3\2\2\2-+\3\2\2\2-.\3\2"+
		"\2\2.\20\3\2\2\2/\60\7\f\2\2\60\22\3\2\2\2\6\2 (-";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}