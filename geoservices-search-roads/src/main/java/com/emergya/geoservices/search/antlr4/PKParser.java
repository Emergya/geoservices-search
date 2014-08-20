// Generated from PK.g4 by ANTLR 4.0

    package com.emergya.geoservices.search.antlr4;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PKParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__3=1, T__2=2, T__1=3, T__0=4, Name=5, Int=6, WS=7, NL=8;
	public static final String[] tokenNames = {
		"<INVALID>", "'km'", "'pk'", "','", "'\"'", "Name", "Int", "WS", "'\n'"
	};
	public static final int
		RULE_file = 0, RULE_pk = 1, RULE_item = 2, RULE_rest = 3, RULE_sepString = 4;
	public static final String[] ruleNames = {
		"file", "pk", "item", "rest", "sepString"
	};

	@Override
	public String getGrammarFileName() { return "PK.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public PKParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public PkContext pk() {
			return getRuleContext(PkContext.class,0);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PKListener ) ((PKListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PKListener ) ((PKListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10); pk();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PkContext extends ParserRuleContext {
		public ItemContext item() {
			return getRuleContext(ItemContext.class,0);
		}
		public PkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pk; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PKListener ) ((PKListener)listener).enterPk(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PKListener ) ((PKListener)listener).exitPk(this);
		}
	}

	public final PkContext pk() throws RecognitionException {
		PkContext _localctx = new PkContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			_la = _input.LA(1);
			if (_la==4) {
				{
				setState(12); match(4);
				}
			}

			setState(15); item();
			setState(17);
			_la = _input.LA(1);
			if (_la==4) {
				{
				setState(16); match(4);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ItemContext extends ParserRuleContext {
		public Token waycode;
		public TerminalNode Name() { return getToken(PKParser.Name, 0); }
		public TerminalNode WS() { return getToken(PKParser.WS, 0); }
		public RestContext rest() {
			return getRuleContext(RestContext.class,0);
		}
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PKListener ) ((PKListener)listener).enterItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PKListener ) ((PKListener)listener).exitItem(this);
		}
	}

	public final ItemContext item() throws RecognitionException {
		ItemContext _localctx = new ItemContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19); ((ItemContext)_localctx).waycode = match(Name);
			setState(21);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(20); match(WS);
				}
			}

			setState(24);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3))) != 0)) {
				{
				setState(23); rest();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RestContext extends ParserRuleContext {
		public Token kmvalue;
		public SepStringContext sepString() {
			return getRuleContext(SepStringContext.class,0);
		}
		public TerminalNode WS() { return getToken(PKParser.WS, 0); }
		public TerminalNode Int() { return getToken(PKParser.Int, 0); }
		public RestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PKListener ) ((PKListener)listener).enterRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PKListener ) ((PKListener)listener).exitRest(this);
		}
	}

	public final RestContext rest() throws RecognitionException {
		RestContext _localctx = new RestContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_rest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26); sepString();
			setState(28);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(27); match(WS);
				}
			}

			setState(30); ((RestContext)_localctx).kmvalue = match(Int);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SepStringContext extends ParserRuleContext {
		public TerminalNode WS() { return getToken(PKParser.WS, 0); }
		public SepStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sepString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PKListener ) ((PKListener)listener).enterSepString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PKListener ) ((PKListener)listener).exitSepString(this);
		}
	}

	public final SepStringContext sepString() throws RecognitionException {
		SepStringContext _localctx = new SepStringContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sepString);
		try {
			setState(41);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(32); match(3);
				setState(33); match(WS);
				setState(34); match(1);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(35); match(1);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(36); match(3);
				setState(37); match(WS);
				setState(38); match(2);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(39); match(2);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(40); match(3);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\2\3\n.\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\3\5\3\20\n\3"+
		"\3\3\3\3\5\3\24\n\3\3\4\3\4\5\4\30\n\4\3\4\5\4\33\n\4\3\5\3\5\5\5\37\n"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6,\n\6\3\6\2\7\2\4\6"+
		"\b\n\2\2\61\2\f\3\2\2\2\4\17\3\2\2\2\6\25\3\2\2\2\b\34\3\2\2\2\n+\3\2"+
		"\2\2\f\r\5\4\3\2\r\3\3\2\2\2\16\20\7\6\2\2\17\16\3\2\2\2\17\20\3\2\2\2"+
		"\20\21\3\2\2\2\21\23\5\6\4\2\22\24\7\6\2\2\23\22\3\2\2\2\23\24\3\2\2\2"+
		"\24\5\3\2\2\2\25\27\7\7\2\2\26\30\7\t\2\2\27\26\3\2\2\2\27\30\3\2\2\2"+
		"\30\32\3\2\2\2\31\33\5\b\5\2\32\31\3\2\2\2\32\33\3\2\2\2\33\7\3\2\2\2"+
		"\34\36\5\n\6\2\35\37\7\t\2\2\36\35\3\2\2\2\36\37\3\2\2\2\37 \3\2\2\2 "+
		"!\7\b\2\2!\t\3\2\2\2\"#\7\5\2\2#$\7\t\2\2$,\7\3\2\2%,\7\3\2\2&\'\7\5\2"+
		"\2\'(\7\t\2\2(,\7\4\2\2),\7\4\2\2*,\7\5\2\2+\"\3\2\2\2+%\3\2\2\2+&\3\2"+
		"\2\2+)\3\2\2\2+*\3\2\2\2,\13\3\2\2\2\b\17\23\27\32\36+";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}