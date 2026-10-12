package dev.reymon.graphics.javafx;

import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class AppHBox extends HBox {

	public AppHBox() {
		super();
	}

	public AppHBox(double spacing, Node... children) {
		super(spacing, children);
	}

	public AppHBox(double spacing) {
		super(spacing);
	}

	public AppHBox(Node... children) {
		super(children);
	}

}
