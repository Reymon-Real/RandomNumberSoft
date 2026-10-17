package app.reymon;

import java.util.List;
import java.util.Map;

import dev.reymon.graphics.javafx.Application;
import dev.reymon.graphics.javafx.BorderPane;
import dev.reymon.graphics.javafx.Button;
import dev.reymon.graphics.javafx.HostServices;
import dev.reymon.graphics.javafx.Menu;
import dev.reymon.graphics.javafx.MenuBar;
import dev.reymon.graphics.javafx.MenuItem;
import dev.reymon.graphics.javafx.TextArea;
import dev.reymon.graphics.javafx.VBox;
import dev.reymon.math.RandomNumber;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RandomNumberSoft extends Application {

	private HostServices hostServices = new HostServices();
	private CurrentView currentView = CurrentView.MID_SQUARE;

	private MenuBar menu;
	private BorderPane pane;

	private VBox leftMenuBox;
	private TextArea results;

	@Override
	public void init() {

		hostServices.setHostServices(getHostServices()); // Initialize the host services

		menu = new MenuBar();
		pane = new BorderPane();

		// Create result area
		results = new TextArea();

		results.prefWidthProperty().bind(pane.widthProperty().multiply(0.25));
		results.setMinWidth(160);

		results.setEditable(false);
		results.setPrefRowCount(8);

		// Crear aspecto del menú
		leftMenuBox = new VBox(4);

		leftMenuBox.prefWidthProperty().bind(pane.widthProperty().multiply(0.25));
		leftMenuBox.setMinWidth(160);

		leftMenuBox.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
	}

	@Override
	public void start(Stage primaryStage) {

		// Lambda functions are used to avoid polluting the global scope
		// and to encapsulate logic within its own “bubbles.”

		menu.add(() -> {

			// A menu that provides contact information for support
			// and assistance with specific questions
			Menu help = new Menu("Help");

			// A menu that provides the another perspectives
			// for the methods of generate random numbers
			Menu perspective = new Menu("Perspective");

			// Create a help menu
			help.add(() -> {

				// Open the customer's email
				MenuItem support = new MenuItem("Support");

				support.setOnAction(
						_ -> hostServices.getHostServices().showDocument("mailto:support@reymon.app?subject=Ticket"));

				// Close the application
				MenuItem exit = new MenuItem("Exit");

				exit.setOnAction(_ -> Platform.exit());

				// Return list
				return List.of(support, exit);
			});

			// Create a perspective menu
			perspective.add(() -> {

				// Perspective
				MenuItem midSquare = new MenuItem("Cuadrados Medios");
				MenuItem midProduct = new MenuItem("Productos Medios");
				MenuItem constantMultiplicative = new MenuItem("Constante Multiplicativa");
				MenuItem congruentialLineal = new MenuItem("Congruencial Lineal");
				MenuItem congruentialMultiplicative = new MenuItem("Congruencial Multiplicativa");
				MenuItem congruentialAdditive = new MenuItem("Congruencial Aditivo");
				MenuItem quadraticCongruential = new MenuItem("Congruencial Cuadrático");
				MenuItem averageTest = new MenuItem("Prueba de Medias");
				MenuItem varianceTest = new MenuItem("Prueba de Varianza");
				MenuItem squareChi = new MenuItem("Chi Cuadrada");
				MenuItem kolmogorovSmirnov = new MenuItem("Kolmogorov Smirnov");

				// Change perspectives
				midSquare.setOnAction(_ -> {
					currentView = CurrentView.MID_SQUARE;
					pane.setCenter(AppViews.midSquareView());
				});

				midProduct.setOnAction(_ -> {
					currentView = CurrentView.MID_PRODUCT;
					pane.setCenter(AppViews.midProductView());
				});

				constantMultiplicative.setOnAction(_ -> {
					currentView = CurrentView.CONSTANT_MULTIPLICATIVE;
					pane.setCenter(AppViews.constantMultiplicativeView());
				});

				congruentialLineal.setOnAction(_ -> {
					currentView = CurrentView.CONGRUENTIAL_LINEAL;
					pane.setCenter(AppViews.congruentialLinealView());
				});

				congruentialMultiplicative.setOnAction(_ -> {
					currentView = CurrentView.CONGRUENTIAL_MULTIPLICATIVE;
					pane.setCenter(AppViews.congruentialMultiplicativeView());
				});

				congruentialAdditive.setOnAction(_ -> {
					currentView = CurrentView.CONGRUENTIAL_ADDITIVE;
					pane.setCenter(AppViews.congruentialAdditiveView());
				});

				quadraticCongruential.setOnAction(_ -> {
					currentView = CurrentView.QUADRATIC_CONGRUENTIAL;
					pane.setCenter(AppViews.quadraticCongruentialView());
				});

				averageTest.setOnAction(_ -> {
					currentView = CurrentView.AVERAGE_TEST;
					pane.setCenter(AppViews.averageTestView());
				});

				varianceTest.setOnAction(_ -> {
					currentView = CurrentView.VARIANCE_TEST;
					pane.setCenter(AppViews.varianceTestView());
				});

				squareChi.setOnAction(_ -> {
					currentView = CurrentView.SQUARE_CHI;
					pane.setCenter(AppViews.squareChiView());
				});

				kolmogorovSmirnov.setOnAction(_ -> {
					currentView = CurrentView.KOLMOGOROV_SMIRNOV;
					pane.setCenter(AppViews.kolmogorovSmirnovView());
				});

				// Return the perspectives
				return List.of(midSquare, midProduct, constantMultiplicative, congruentialLineal,
						congruentialMultiplicative, congruentialAdditive, quadraticCongruential, averageTest,
						varianceTest, squareChi, kolmogorovSmirnov);
			});

			// Return of the list of menus
			return List.of(perspective, help);
		});

		// Add to center of the menu the interactions

		leftMenuBox.addCenter(() -> {

			Button calculate = new Button("Calcular");
			calculate.setMaxWidth(Double.MAX_VALUE);

			calculate.setOnAction(_ -> {
				results.clear();

				switch (currentView) {

				case CurrentView.MID_SQUARE:

					for (var number : RandomNumber.midSquare(AppViews.getParametersOfMidSquare()))
						results.appendText(String.format("%f,%n", number));
					break;

				case CurrentView.MID_PRODUCT:

					for (var number : RandomNumber.midProduct(AppViews.getParametersOfMidProduct()))
						results.appendText(String.format("%f,%n", number));
					break;

				case CurrentView.QUADRATIC_CONGRUENTIAL:

					for (var number : RandomNumber
							.quadraticCongruential(AppViews.getParametersOfQuadraticCongruential()))
						results.appendText(String.format("%f,%n", number));
					break;

				case CurrentView.CONSTANT_MULTIPLICATIVE:

					for (var number : RandomNumber
							.constantMultiplicative(AppViews.getParametersOfConstantMultiplicative()))
						results.appendText(String.format("%f,%n", number));
					break;

				case CurrentView.CONGRUENTIAL_LINEAL:

					for (var number : RandomNumber.congruentialLineal(AppViews.getParametersOfCongruentialLineal()))
						results.appendText(String.format("%f,%n", number));
					break;

				case CurrentView.CONGRUENTIAL_MULTIPLICATIVE:

					for (var number : RandomNumber
							.congruentialMultiplicative(AppViews.getParametersOfCongruentialMultiplicative()))
						results.appendText(String.format("%f,%n", number));
					break;

				case CurrentView.CONGRUENTIAL_ADDITIVE:

					for (var number : RandomNumber.congruentialAdditive(AppViews.getParametersOfCongruentialAdditive()))
						results.appendText(String.format("%f,%n", number));
					break;
				
				case CurrentView.AVERAGE_TEST: {

					Map<String, Double> map = RandomNumber.averageTest(AppViews.getParametersOfAverageTest());

					double lowerLimit = map.get("LowerLimit");
					double upperLimit = map.get("UpperLimit");
					double media = map.get("Media");
					
					if (lowerLimit < media && media < upperLimit)
						results.appendText(String.format("""
								Media: %f
								Límite Inferior: %f
								Límite Superior: %f
								Se acepta la hipótesis
								""", media, lowerLimit, upperLimit));
					else
						results.appendText(String.format("""
								Media: %f
								Límite Inferior: %f
								Límite Superior: %f
								Se rechaza la hipótesis
								""", media, lowerLimit, upperLimit));

					break;
				}
				
				case CurrentView.VARIANCE_TEST: {

					Map<String, Double> map = RandomNumber.varianceTest(AppViews.getParametersOfVarianceTest());

					double variance = map.get("Variance");
					double media    = map.get("Media");
					double lowerLimit = map.get("LowerLimit");
					double upperLimit = map.get("UpperLimit");

					if (lowerLimit <= variance && variance <= upperLimit)
						results.appendText(String.format("""
								Varianza: %f
								Media: %f
								Límite Inferior: %f
								Límite Superior: %f
								Se acepta la hipótesis
								""", variance, media, lowerLimit, upperLimit));
					else
						results.appendText(String.format("""
								Varianza: %f
								Media: %f
								Límite Inferior: %f
								Límite Superior: %f
								Se rechaza la hipótesis
								""", variance, media, lowerLimit, upperLimit));

					break;
				}

				case CurrentView.SQUARE_CHI: {

					Map<String, Double> map = RandomNumber.squareChi(AppViews.getParametersOfSquareChi());

					double tableChi = map.get("TableChi");
					double calculateChi = map.get("CalculateChi");

					if (calculateChi < tableChi)
						results.appendText(String.format("""
								Calculo: %f
								Chi Tabla: %f
								Se acepta la hipótesis
								""", calculateChi, tableChi));
					else
						results.appendText(String.format("""
								Calculo: %f
								Chi Tabla: %f
								Se rechaza la hipótesis
								""", calculateChi, tableChi));

					break;
				}

				case CurrentView.KOLMOGOROV_SMIRNOV: {

					Map<String, Double> map = RandomNumber
							.kolmogorovSmirnov(AppViews.getParametersOfKolmogorovSmirnov());

					double d_plus = map.get("d_plus");
					double d_minus = map.get("d_minus");

					double d_max = map.get("d_max");
					double d_critic = map.get("d_critic");

					if (d_max < d_critic)
						results.appendText(String.format("""
								D+: %f
								D-: %f
								D Max: %f
								D Crítico: %f
								Se acepta la hipótesis
								""", d_plus, d_minus, d_max, d_critic));
					else
						results.appendText(String.format("""
								D+: %f
								D-: %f
								D Max: %f
								D Crítico: %f
								Se acepta la hipótesis
								""", d_plus, d_minus, d_max, d_critic));

					break;
				}

				}
			});

			return List.of(calculate);
		});

		/**
		 * Create content of the panel for the application
		 */

		pane.setTop(menu);
		pane.setLeft(leftMenuBox);
		pane.setCenter(AppViews.midSquareView()); // Set default view
		pane.setRight(results);

		/**
		 * Create Scene of the application and configure the scene
		 */

		Scene scene = new Scene(pane, 640, 480); // Create Scene

		/*************************************************************/
		primaryStage.setScene(scene);
		primaryStage.setTitle("RandomNumberSoft");
		primaryStage.show();
	}

	@Override
	public void stop() {

	}

	public static void main(String[] args) {
		launch(args);
	}

}