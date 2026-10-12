package dev.reymon.graphics.javafx;

import javafx.scene.Node;
import javafx.scene.control.MenuItem;

public class AppMenuItem extends MenuItem {

	public AppMenuItem() {
	}

	public AppMenuItem(String text) {
		super(text);
	}

	public AppMenuItem(String text, Node graphic) {
		super(text, graphic);
	}

}
