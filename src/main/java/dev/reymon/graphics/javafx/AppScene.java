package dev.reymon.graphics.javafx;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.paint.Paint;

public class AppScene extends Scene {
	
	//####################//
	//### Constructors ###//
	//####################//
	
	public AppScene(Parent root) {
		super(root);
	}

	public AppScene(Parent root, Paint fill) {
		super(root, fill);
	}

	public AppScene(Parent root, double width, double height) {
		super(root, width, height);
	}

	public AppScene(Parent root, double width, double height, Paint fill) {
		super(root, width, height, fill);
	}

	public AppScene(Parent root, double width, double height, boolean depthBuffer) {
		super(root, width, height, depthBuffer);
	}

	public AppScene(Parent root, double width, double height, boolean depthBuffer, SceneAntialiasing antiAliasing) {
		super(root, width, height, depthBuffer, antiAliasing);
	}

}
