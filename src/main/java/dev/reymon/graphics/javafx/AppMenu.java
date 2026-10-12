package dev.reymon.graphics.javafx;

import java.util.List;
import java.util.function.Supplier;

import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class AppMenu extends Menu {

	public AppMenu() {
	}

	public AppMenu(String text) {
		super(text);
	}

	public AppMenu(String text, Node graphic) {
		super(text, graphic);
	}

	public AppMenu(String text, Node graphic, MenuItem... items) {
		super(text, graphic, items);
	}
		
	public void add(Supplier<List<AppMenuItem>> list) {
		
		this.getItems().addAll(list.get());
		
	}

}
