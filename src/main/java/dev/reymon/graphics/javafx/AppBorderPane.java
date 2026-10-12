package dev.reymon.graphics.javafx;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class AppBorderPane extends BorderPane {

	public AppBorderPane() {
	}

	public AppBorderPane(Node center) {
		super(center);
	}

	public AppBorderPane(Node center, Node top, Node right, Node bottom, Node left) {
		super(center, top, right, bottom, left);
	}

}
