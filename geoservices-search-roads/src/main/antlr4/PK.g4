grammar PK;

@header {
    package com.emergya.geoservices.search.antlr4;
}

file: pk;

pk: '"'? item '"'?;

item: waycode=Name WS? rest?;
	
rest: sepString WS? kmvalue=Int;

sepString
	: ',' WS 'km'
	| 'km'
	| ',' WS 'pk'
	| 'pk'
	| ','
	;
	
Name: ('A'..'Z' | 'a'..'z' )+ '-' number=Int;
Int: ('0'..'9')+;

WS: (' ' | '\t')+;
NL: '\n';