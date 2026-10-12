package dev.reymon.graphics.javafx;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.Priority;

public class AppViews {

	private static final double LABEL_WIDTH = 160;
	private static final double FIELD_HEIGHT = 30;
	
	private static List<AppTextArea> fields = new ArrayList<AppTextArea>();
	private static AppTextArea iterationsField;
	private static AppTextArea digitsField;
	
	// Create Fields
	private static AppTextArea createField() {
		AppTextArea field = new AppTextArea();
		field.setPrefRowCount(1);
		field.setPrefHeight(FIELD_HEIGHT);
		field.setMinHeight(FIELD_HEIGHT);
		field.setMaxHeight(FIELD_HEIGHT);
		return field;
	}
	
	// Create Rows
	private static AppHBox row(String text, AppTextArea field) {
		AppLabel label = new AppLabel(text);
		label.setMinWidth(LABEL_WIDTH);
		label.setPrefWidth(LABEL_WIDTH);

		AppHBox.setHgrow(field, Priority.ALWAYS);

		AppHBox box = new AppHBox(8);
		box.setAlignment(Pos.CENTER_LEFT);
		box.getChildren().addAll(label, field);
		return box;
	}
	
	// Show mid square
	public static Node midSquareView() {
		
		fields.clear();
		
		fields.addFirst(createField());
		iterationsField = createField();
		digitsField = createField();

		AppVBox verticalBox = new AppVBox(8);

		verticalBox.setAlignment(Pos.CENTER);

		verticalBox.getChildren().addAll(
				row("Semilla", fields.getFirst()),
				row("Número de dígitos", digitsField),
				row("Número de Iteraciones", iterationsField)
			);

		return verticalBox;
	}
	
	// Show mid product
	public static Node midProductView() {
		
		fields.clear();
		
		fields.add(createField());
		fields.add(createField());
		digitsField = createField();
		iterationsField = createField();
		
		AppVBox verticalBox = new AppVBox(8);
		
		verticalBox.setAlignment(Pos.CENTER);
		
		verticalBox.getChildren().addAll(
				row("Semilla 1", fields.get(0)),
				row("Semilla 2", fields.get(1)),
				row("Número de dígitos", digitsField),
				row("Número de iteraciones", iterationsField)
			);
		
		return verticalBox;
	}
	
	// Show Quadratic Congruential
	public static Node quadraticCongruentialView() {
		fields.clear();
		
		fields.add(createField()); // Seed
		fields.add(createField()); // M
		fields.add(createField()); // A
		fields.add(createField()); // B
		fields.add(createField()); // C
		iterationsField = createField();
		
		AppVBox verticalBox = new AppVBox(8);
		
		verticalBox.setAlignment(Pos.CENTER);
		
		verticalBox.getChildren().addAll(
				row("Semilla", fields.get(0)),
				row("Iteraciones", iterationsField),
				row("M", fields.get(1)),
				row("A", fields.get(2)),
				row("B", fields.get(3)),
				row("C", fields.get(4))
			);
		
		return verticalBox;
	}
	
	// Show Constant Multiply
	public static Node constantMultiplicativeView() {
		fields.clear();
		
		fields.add(createField()); // Seed
		fields.add(createField()); // Constant
		digitsField = createField();
		iterationsField = createField();
		
		AppVBox verticalBox = new AppVBox(8);
		
		verticalBox.setAlignment(Pos.CENTER);
		
		verticalBox.getChildren().addAll(
				row("Semilla", fields.get(0)),
				row("Constante", fields.get(1)),
				row("Número de dígitos", digitsField),
				row("Número de iteraciones", iterationsField)
			);
		
		return verticalBox;
	}
	
	// Show Constant Multiply Lineal
	public static Node congruentialLinealView() {
		fields.clear();
			
		fields.add(createField()); // Seed
		fields.add(createField()); // Module
		fields.add(createField()); // Multiplier
		fields.add(createField()); // Constant
		iterationsField = createField();
			
		AppVBox verticalBox = new AppVBox(8);
			
		verticalBox.setAlignment(Pos.CENTER);
			
		verticalBox.getChildren().addAll(
				row("Semilla", fields.get(0)),
				row("Modulo",  fields.get(1)),
				row("Multiplicador", fields.get(2)),
				row("Constante", fields.get(3)),
				row("Número de iteraciones", iterationsField)
			);
			
		return verticalBox;
	}
	
	// Show Constant Multiply Lineal
	public static Node congruentialMultiplicativeView() {
		fields.clear();
					
		fields.add(createField()); // Seed
		fields.add(createField()); // k
		fields.add(createField()); // g
		iterationsField = createField();
					
		AppVBox verticalBox = new AppVBox(8);
					
		verticalBox.setAlignment(Pos.CENTER);
					
		verticalBox.getChildren().addAll(
			row("Semilla", fields.get(0)),
			row("K",  fields.get(1)),
			row("G", fields.get(2)),
			row("Número de iteraciones", iterationsField)
		);
					
		return verticalBox;
	}
	
	// Show Constant Multiply Lineal
	public static Node congruentialAdditiveView() {
		fields.clear();
						
		fields.add(createField()); // Seed
		fields.add(createField()); // Module
		iterationsField = createField();
						
		AppVBox verticalBox = new AppVBox(8);
						
		verticalBox.setAlignment(Pos.CENTER);
						
		verticalBox.getChildren().addAll(
			row("Semilla", fields.get(0)),
			row("Módulo",  fields.get(1)),
			row("Número de iteraciones", iterationsField)
		);
						
		return verticalBox;
	}
	
	// Return parameters of Mid Square
	public static List<String> getParametersOfMidSquare() {
		return List.of(
			fields.get(0).getText().replaceAll("\\s+", ""),  // Seed
			digitsField.getText().replaceAll("\\s+", ""),    // Digits
			iterationsField.getText().replaceAll("\\s+", "") // Iterations
		);
	}
	
	// Return parameters of Mid Product
	public static List<String> getParametersOfMidProduct() {
		return List.of(
			fields.get(0).getText().replaceAll("\\s+", ""),  // Seed
			fields.get(1).getText().replaceAll("\\s+", ""),  // Seed 2
			digitsField.getText().replaceAll("\\s+", ""),    // Digits
			iterationsField.getText().replaceAll("\\s+", "") // Iterations
		);
	}
	
	// Return parameters of the Quadratic Congruential
	public static List<String> getParametersOfQuadraticCongruential() {
		return List.of(
			fields.get(0).getText().replaceAll("\\s+", ""),  // Seed
			fields.get(1).getText().replaceAll("\\s+", ""),  // M
			fields.get(2).getText().replaceAll("\\s+", ""),  // A
			fields.get(3).getText().replaceAll("\\s+", ""),  // B
			fields.get(4).getText().replaceAll("\\s+", ""),  // C
			iterationsField.getText().replaceAll("\\s+", "") // Iterations
		);
	}
	
	// Return parameters of the Constant Multiply
	public static List<String> getParametersOfConstantMultiplicative() {
		return List.of(
			fields.get(0).getText().replaceAll("\\s+", ""), // Seed
			fields.get(1).getText().replaceAll("\\s+", ""), // Constant
			digitsField.getText().replaceAll("\\s+", ""),   // Digits
			iterationsField.getText().replaceAll("\\s+", "")// Iterations
		);
	}
	
	// Return parameters of the Congruential Lineal
	public static List<String> getParametersOfCongruentialLineal() {
		return List.of(
			fields.get(0).getText().replaceAll("\\s+", ""), // Seed
			fields.get(1).getText().replaceAll("\\s+", ""), // Module
			fields.get(2).getText().replaceAll("\\s+", ""), // Multiplier
			fields.get(3).getText().replaceAll("\\s+", ""), // Constant
			iterationsField.getText().replaceAll("\\s+", "")// Iterations
		);
	}

	// Return parameters of the Congruential Multiplicative
	public static List<String> getParametersOfCongruentialMultiplicative() {
		return List.of(
			fields.get(0).getText().replaceAll("\\s+", ""),  // Seed
			fields.get(1).getText().replaceAll("\\s+", ""),  // k
			fields.get(2).getText().replaceAll("\\s+", ""),  // g
			iterationsField.getText().replaceAll("\\s+", "") // Iterations
		);
	}
	
	// Return parameters of the Congruential Multiplicative
	public static List<String> getParametersOfCongruentialAdditive() {
		return List.of(
			fields.get(0).getText().replaceAll("\\s+", ""),  // Seed
			fields.get(1).getText().replaceAll("\\s+", ""),  // Module
			iterationsField.getText().replaceAll("\\s+", "") // Iterations
		);
	}
}