package app.reymon;

import java.util.List;

import dev.reymon.graphics.javafx.*;
import dev.reymon.math.RandomNumber;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RandomNumberSoft extends ReymonApplication {

	public static HostServices hostServices;
	public static CurrentView  currentView = CurrentView.MID_SQUARE;
	
	@Override
	public void start(Stage primaryStage) {
		
		
		hostServices = getHostServices(); // Initialize the host services
		
		AppMenuBar menu = new AppMenuBar(); // Menu on top for utilities
		AppBorderPane pane = new AppBorderPane();
		
		// Lambda functions are used to avoid polluting the global scope
		// and to encapsulate logic within its own “bubbles.”
		
		menu.add(() ->{
						
			// A menu that provides contact information for support
			// and assistance with specific questions
			AppMenu help = new AppMenu("Help");
			
			// A menu that provides the another perspectives
			// for the methods of generate random numbers
			AppMenu perspective = new AppMenu("Perspective");
			
			// Create a help menu
			help.add(() -> {
				
				// Open the customer's email
				AppMenuItem support = new AppMenuItem("Support");
				
				support.setOnAction(_ ->
					RandomNumberSoft.hostServices.showDocument("mailto:support@reymon.app?subject=Ticket")
				);
				
				// Close the application
				AppMenuItem exit = new AppMenuItem("Exit");
				
				exit.setOnAction(_ -> Platform.exit());
				
				// Return list
				return List.of(
					support,
					exit
				);
			});
			
			// Create a perspective menu
			perspective.add(() -> {
				
				// Perspective
				AppMenuItem midSquare = new AppMenuItem("Cuadrados Medios");
				AppMenuItem midProduct = new AppMenuItem("Productos Medios");
				AppMenuItem constantMultiplicative = new AppMenuItem("Constante Multiplicativa");
				AppMenuItem congruentialLineal = new AppMenuItem("Congruencial Lineal");
				AppMenuItem congruentialMultiplicative = new AppMenuItem("Congruencial Multiplicativa");
				AppMenuItem congruentialAdditive = new AppMenuItem("Congruencial Aditivo");
				AppMenuItem quadraticCongruential = new AppMenuItem("Congruencial Cuadrático");
				
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
				
				
				// Return the perspectives
				return List.of(
					midSquare,
					midProduct,
					constantMultiplicative,
					congruentialLineal,
					congruentialMultiplicative,
					congruentialAdditive,
					quadraticCongruential
				);
			});
			
			// Return of the list of menus
			return List.of(perspective, help);
		});		
		
		// Create a right area
		AppTextArea results = new AppTextArea();
		
		results.prefWidthProperty().bind(pane.widthProperty().multiply(0.25));
		results.setMinWidth(160);
		
		results.setEditable(false);
		results.setPrefRowCount(8);
		
		// Crear aspecto del menú
		AppVBox leftBox = new AppVBox(4);
		
		leftBox.prefWidthProperty().bind(pane.widthProperty().multiply(0.25));
		leftBox.setMinWidth(160);
		
		leftBox.setBorder(
				new Border(
						new BorderStroke(
								Color.BLACK,
								BorderStrokeStyle.SOLID,
								CornerRadii.EMPTY,
								new BorderWidths(1)
						)
				)
		);
		
		// Add to center of the menu the interactions
		
		leftBox.addCenter(() -> {
			
			AppButton calculate = new AppButton("Calcular");
			calculate.setMaxWidth(Double.MAX_VALUE);
			
				calculate.setOnAction(_ -> {
						results.clear();
						
						switch (currentView) {
							
						case CurrentView.MID_SQUARE:
						
							for (var number : RandomNumber.midSquare(AppViews.getParametersOfMidSquare()))
								results.appendText(String.format("%f%n", number));
							break;
							
						case CurrentView.MID_PRODUCT:
							
							for (var number : RandomNumber.midProduct(AppViews.getParametersOfMidProduct()))
								results.appendText(String.format("%f%n", number));
							break;
							
						case CurrentView.QUADRATIC_CONGRUENTIAL:
							
							for (var number : RandomNumber.quadraticCongruential(AppViews.getParametersOfQuadraticCongruential()))
								results.appendText(String.format("%f%n", number));
							break;
							
						case CurrentView.CONSTANT_MULTIPLICATIVE:
							
							for (var number : RandomNumber.constantMultiplicative(AppViews.getParametersOfConstantMultiplicative()))
								results.appendText(String.format("%f%n", number));
							break;
						
						case CurrentView.CONGRUENTIAL_LINEAL:
							
							for (var number : RandomNumber.congruentialLineal(AppViews.getParametersOfCongruentialLineal()))
								results.appendText(String.format("%f%n", number));
							break;
						
						case CurrentView.CONGRUENTIAL_MULTIPLICATIVE:
							
							for (var number : RandomNumber.congruentialMultiplicative(AppViews.getParametersOfCongruentialMultiplicative()))
								results.appendText(String.format("%f%n", number));
							break;
						
						case CurrentView.CONGRUENTIAL_ADDITIVE:
							
							for (var number : RandomNumber.congruentialAdditive(AppViews.getParametersOfCongruentialAdditive()))
								results.appendText(String.format("%f%n", number));
							break;
							
						}
					}
				);
			
			return List.of(
					calculate
				);
		});
		
		/**
		 * Create content of the panel
		 * for the application
		 * */
		
		pane.setTop(menu);
		pane.setLeft(leftBox);
		pane.setCenter(AppViews.midSquareView()); // Set default view
		pane.setRight(results);
		
		/**
		 * Create Scene of the application
		 * and configure the scene
		 * */
		
		
		AppScene scene = new AppScene(pane, 640, 480); // Create Scene
		
		
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