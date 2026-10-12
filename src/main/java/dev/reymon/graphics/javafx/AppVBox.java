package dev.reymon.graphics.javafx;

import java.util.List;
import java.util.function.Supplier;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class AppVBox extends VBox {

	public AppVBox() {
		super();
	}

	public AppVBox(double spacing, Node... children) {
		super(spacing, children);
	}

	public AppVBox(double spacing) {
		super(spacing);
	}

	public AppVBox(Node... children) {
		super(children);
	}

	public void addCenter(Supplier<List<Node>> list) {
		this.setPadding(new Insets(15));
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(list.get());
	}

}
