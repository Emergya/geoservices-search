package com.emergya.geoservices.search.antlr4;

import java.util.concurrent.atomic.AtomicReference;

import junit.framework.Assert;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.junit.Test;


public class PKTest {

	@Test
	public void test() throws Exception {
		final AtomicReference<String> wayCode = new AtomicReference<>();
    	final AtomicReference<String> km = new AtomicReference<>();
		PKLexer l = new PKLexer(new ANTLRInputStream(getClass().getResourceAsStream("/test.pk")));
	    PKParser p = new PKParser(new CommonTokenStream(l));
	    p.addErrorListener(new BaseErrorListener() {
	        @Override
	        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
	            throw new IllegalStateException("failed to parse at line " + line + " due to " + msg, e);
	        }
	    });
	    p.addParseListener(new PKBaseListener(){
	    	@Override
	    	public void exitItem(PKParser.ItemContext ctx){
	    		wayCode.set(ctx.waycode.getText());
	    	}
	    	@Override
	    	public void exitRest(PKParser.RestContext ctx){
	    		km.set(ctx.kmvalue.getText());
	    	}
	    });
	    p.pk();
	    // Check way code was not null
	    Assert.assertNotNull(wayCode.get());
	    System.out.println("Hightway code: " + wayCode.get());
	    // Check km number was not null
	    Assert.assertNotNull(Integer.parseInt(km.get()));
	    System.out.println("Kilometer point: " + Integer.parseInt(km.get()));
	}
}
