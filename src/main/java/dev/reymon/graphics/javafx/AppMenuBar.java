package dev.reymon.graphics.javafx;

import java.util.List;
import java.util.function.Supplier;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class AppMenuBar extends MenuBar {

	public AppMenuBar() {
	}

	public AppMenuBar(Menu... menus) {
		super(menus);
	}
	
	public void add(Supplier<List<AppMenu>> list) {
		
		this.getMenus().addAll(list.get());
		
	}

}
