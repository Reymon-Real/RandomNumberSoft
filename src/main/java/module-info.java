module app.reymon.RandomNumberSoft {
	
	requires transitive javafx.graphics;
	requires transitive javafx.controls;
	requires transitive javafx.fxml;
	
	opens dev.reymon.graphics.javafx to javafx.controls, javafx.graphics, javafx.fxml;
	exports dev.reymon.graphics.javafx to app.reymon;
	exports app.reymon to javafx.controls, javafx.graphics, javafx.fxml;

}