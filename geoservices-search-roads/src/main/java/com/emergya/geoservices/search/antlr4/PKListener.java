// Generated from PK.g4 by ANTLR 4.0

    package com.emergya.geoservices.search.antlr4;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface PKListener extends ParseTreeListener {
	void enterSepString(PKParser.SepStringContext ctx);
	void exitSepString(PKParser.SepStringContext ctx);

	void enterFile(PKParser.FileContext ctx);
	void exitFile(PKParser.FileContext ctx);

	void enterItem(PKParser.ItemContext ctx);
	void exitItem(PKParser.ItemContext ctx);

	void enterRest(PKParser.RestContext ctx);
	void exitRest(PKParser.RestContext ctx);

	void enterPk(PKParser.PkContext ctx);
	void exitPk(PKParser.PkContext ctx);
}