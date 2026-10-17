open module app.reymon.RandomNumberSoft {
	
	exports app.reymon;
	exports dev.reymon.math;
	
	requires transitive org.apache.commons.statistics.distribution;
	requires transitive smile.base;
	requires transitive smile.core;
	requires transitive smile.deep;
	requires transitive smile.nlp;
	requires transitive smile.plot;
	requires transitive javafx.controls;
	requires transitive javafx.graphics;
	requires transitive dev.reymon.graphics.javafx;
}