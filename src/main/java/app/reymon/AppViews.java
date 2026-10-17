package app.reymon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.reymon.graphics.javafx.HBox;
import dev.reymon.graphics.javafx.TextArea;
import dev.reymon.graphics.javafx.VBox;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;

public class AppViews {

	private static final double LABEL_WIDTH = 160;
	private static final double FIELD_HEIGHT = 30;

	private static List<TextArea> fields = new ArrayList<TextArea>();
	private static TextArea iterationsField;
	private static TextArea digitsField;
	private static Map<String, TextArea> map = new HashMap<String, TextArea>();

	private static VBox verticalBox = new VBox(8);
	private static HBox HRow = new HBox(8);

	// Create Fields
	private static TextArea createField() {
		TextArea field = new TextArea();
		field.setPrefRowCount(1);
		field.setPrefHeight(FIELD_HEIGHT);
		field.setMinHeight(FIELD_HEIGHT);
		field.setMaxHeight(FIELD_HEIGHT);
		return field;
	}

	// Create Rows
	private static HBox row(String text, TextArea field) {
		Label label = new Label(text);
		label.setMinWidth(LABEL_WIDTH);
		label.setPrefWidth(LABEL_WIDTH);

		HBox.setHgrow(field, Priority.ALWAYS);

		HRow = new HBox(8);
		HRow.setAlignment(Pos.CENTER_LEFT);
		HRow.getChildren().addAll(label, field);
		return HRow;
	}

	private static void VBoxSettings() {
		verticalBox = new VBox(8);

		verticalBox.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));

		verticalBox.setAlignment(Pos.CENTER);
	}

	// Show mid square
	public static Node midSquareView() {

		fields.clear();

		fields.addFirst(createField());
		iterationsField = createField();
		digitsField = createField();

		VBoxSettings();

		verticalBox.getChildren().addAll(row("Semilla", fields.getFirst()), row("Número de dígitos", digitsField),
				row("Número de Iteraciones", iterationsField));

		return verticalBox;
	}

	// Show mid product
	public static Node midProductView() {

		fields.clear();

		fields.add(createField());
		fields.add(createField());
		digitsField = createField();
		iterationsField = createField();

		VBoxSettings();

		verticalBox.getChildren().addAll(row("Semilla 1", fields.getFirst()), row("Semilla 2", fields.getLast()),
				row("Número de dígitos", digitsField), row("Número de iteraciones", iterationsField));

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

		VBoxSettings();

		verticalBox.getChildren().addAll(row("Semilla", fields.getFirst()), row("Iteraciones", iterationsField),
				row("M", fields.get(1)), row("A", fields.get(2)), row("B", fields.get(3)), row("C", fields.getLast()));

		return verticalBox;
	}

	// Show Constant Multiply
	public static Node constantMultiplicativeView() {
		fields.clear();

		fields.add(createField()); // Seed
		fields.add(createField()); // Constant
		digitsField = createField();
		iterationsField = createField();

		VBoxSettings();

		verticalBox.getChildren().addAll(row("Semilla", fields.getFirst()), row("Constante", fields.getLast()),
				row("Número de dígitos", digitsField), row("Número de iteraciones", iterationsField));

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

		VBoxSettings();

		verticalBox.getChildren().addAll(row("Semilla", fields.getFirst()), row("Modulo", fields.get(1)),
				row("Multiplicador", fields.get(2)), row("Constante", fields.getLast()),
				row("Número de iteraciones", iterationsField));

		return verticalBox;
	}

	// Show Constant Multiply Lineal
	public static Node congruentialMultiplicativeView() {
		fields.clear();

		fields.add(createField()); // Seed
		fields.add(createField()); // k
		fields.add(createField()); // g
		iterationsField = createField();

		VBoxSettings();

		verticalBox.getChildren().addAll(row("Semilla", fields.getFirst()), row("K", fields.get(1)),
				row("G", fields.getLast()), row("Número de iteraciones", iterationsField));

		return verticalBox;
	}

	// Show Constant Multiply Lineal
	public static Node congruentialAdditiveView() {
		fields.clear();

		fields.add(createField()); // Seed
		fields.add(createField()); // Module
		iterationsField = createField();

		VBoxSettings();

		verticalBox.getChildren().addAll(row("Semilla", fields.getFirst()), row("Módulo", fields.getLast()),
				row("Número de iteraciones", iterationsField));

		return verticalBox;
	}

	// Average Test View
	public static Node averageTestView() {
		map.clear();

		map.put("Numbers", createField());
		map.put("Alpha", createField());

		VBoxSettings();

		verticalBox.getChildren().addAll(row("Números", map.get("Numbers")), row("Alfa", map.get("Alpha")));

		return verticalBox;
	}

	// Variance Test View
	public static Node varianceTestView() {
		map.clear();

		map.put("Numbers", createField());
		map.put("Alpha", createField());

		VBoxSettings();

		verticalBox.getChildren().addAll(row("Números", map.get("Numbers")), row("Alfa", map.get("Alpha")));

		return verticalBox;
	}

	// Square Chi View
	public static Node squareChiView() {
		map.clear();

		map.put("Numbers", createField());
		map.put("Alpha", createField());
		map.put("Inter", createField());

		VBoxSettings();

		verticalBox.getChildren().addAll(row("Números", map.get("Numbers")), row("Alfa", map.get("Alpha")),
				row("Intérvalos", map.get("Inter")));

		return verticalBox;
	}
	
	// Variance Test View
		public static Node kolmogorovSmirnovView() {
			map.clear();

			map.put("Numbers", createField());
			map.put("Alpha", createField());

			VBoxSettings();

			verticalBox.getChildren().addAll(row("Números", map.get("Numbers")), row("Alfa", map.get("Alpha")));

			return verticalBox;
		}

	// Return parameters of Mid Square
	public static List<String> getParametersOfMidSquare() {
		return List.of(fields.getFirst().getText().replaceAll("\\s+", ""), // Seed

				digitsField.getText().replaceAll("\\s+", ""), // Digits

				iterationsField.getText().replaceAll("\\s+", "") // Iterations
		);
	}

	// Return parameters of Mid Product
	public static List<String> getParametersOfMidProduct() {
		return List.of(fields.getFirst().getText().replaceAll("\\s+", ""), // Seed
				fields.getLast().getText().replaceAll("\\s+", ""), // Seed 2

				digitsField.getText().replaceAll("\\s+", ""), // Digits
				iterationsField.getText().replaceAll("\\s+", "") // Iterations
		);
	}

	// Return parameters of the Quadratic Congruential
	public static List<String> getParametersOfQuadraticCongruential() {
		return List.of(fields.getFirst().getText().replaceAll("\\s+", ""), // Seed
				fields.get(1).getText().replaceAll("\\s+", ""), // M
				fields.get(2).getText().replaceAll("\\s+", ""), // A
				fields.get(3).getText().replaceAll("\\s+", ""), // B
				fields.getLast().getText().replaceAll("\\s+", ""), // C
				iterationsField.getText().replaceAll("\\s+", "") // Iterations
		);
	}

	// Return parameters of the Constant Multiply
	public static List<String> getParametersOfConstantMultiplicative() {
		return List.of(fields.getFirst().getText().replaceAll("\\s+", ""), // Seed
				fields.getLast().getText().replaceAll("\\s+", ""), // Constant
				digitsField.getText().replaceAll("\\s+", ""), // Digits
				iterationsField.getText().replaceAll("\\s+", "") // Iterations
		);
	}

	// Return parameters of the Congruential Lineal
	public static List<String> getParametersOfCongruentialLineal() {
		return List.of(fields.getFirst().getText().replaceAll("\\s+", ""), // Seed
				fields.get(1).getText().replaceAll("\\s+", ""), // Module
				fields.get(2).getText().replaceAll("\\s+", ""), // Multiplier
				fields.getLast().getText().replaceAll("\\s+", ""), // Constant
				iterationsField.getText().replaceAll("\\s+", "") // Iterations
		);
	}

	// Return parameters of the Congruential Multiplicative
	public static List<String> getParametersOfCongruentialMultiplicative() {
		return List.of(fields.getFirst().getText().replaceAll("\\s+", ""), // Seed
				fields.get(1).getText().replaceAll("\\s+", ""), // k
				fields.getLast().getText().replaceAll("\\s+", ""), // g
				iterationsField.getText().replaceAll("\\s+", "") // Iterations
		);
	}

	// Return parameters of the Congruential Multiplicative
	public static List<String> getParametersOfCongruentialAdditive() {
		return List.of(fields.getFirst().getText().replaceAll("\\s+", ""), // Seed
				fields.getLast().getText().replaceAll("\\s+", ""), // Module
				iterationsField.getText().replaceAll("\\s+", "") // Iterations
		);
	}

	public static Map<String, String> getParametersOfAverageTest() {

		Map<String, String> localMap = new HashMap<String, String>();

		localMap.put("Numbers", map.get("Numbers").getText().replaceAll("\\s+", ""));
		localMap.put("Alpha", map.get("Alpha").getText().replaceAll("\\s+", ""));

		return localMap;
	}

	public static Map<String, String> getParametersOfVarianceTest() {

		Map<String, String> localMap = new HashMap<String, String>();

		localMap.put("Numbers", map.get("Numbers").getText().replaceAll("\\s+", ""));
		localMap.put("Alpha", map.get("Alpha").getText().replaceAll("\\s+", ""));

		return localMap;
	}

	public static Map<String, String> getParametersOfSquareChi() {

		Map<String, String> localMap = new HashMap<String, String>();

		localMap.put("Numbers", map.get("Numbers").getText().replaceAll("\\s+", ""));
		localMap.put("Alpha", map.get("Alpha").getText().replaceAll("\\s+", ""));
		localMap.put("Inter", map.get("Inter").getText().replaceAll("\\s+", ""));

		return localMap;
	}

	public static Map<String, String> getParametersOfKolmogorovSmirnov() {

		Map<String, String> localMap = new HashMap<String, String>();

		localMap.put("Numbers", map.get("Numbers").getText().replaceAll("\\s+", ""));
		localMap.put("Alpha", map.get("Alpha").getText().replaceAll("\\s+", ""));

		return localMap;
	}
}