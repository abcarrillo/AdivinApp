package Vista;

import Modelo.Juego;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ventana extends Application {
	private Juego juego = new Juego();
	private TextField intento = new TextField();
	private Button boton = new Button();

	@Override
	public void start(Stage primaryStage) throws Exception {

		boton.setText("Enviar");

		boton.setOnAction(p -> {
			try {
				juego.hacerTrampa();
				String []resultado = juego.jugar(Integer.parseInt(this.intento.getText()));
				if (resultado[0] == "") {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("AdivinApp");
					alert.setHeaderText("¡Has acertado!");
					alert.setContentText(resultado[1] + " | Adelante, intentalo de nuevo");

					alert.showAndWait();
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("AdivinApp");
					alert.setHeaderText("¡Has fallado!");
					alert.setContentText(resultado[0]);

					alert.showAndWait();
				}
			} catch (Exception ex) {
				System.out.println("por favor escribe un numero");
			}
		});

		HBox textoBox = new HBox();
		textoBox.setAlignment(Pos.BASELINE_CENTER);
		textoBox.setSpacing(5);
		textoBox.getChildren().addAll(new Label("Introduce un numero del 1 al 100"));

		HBox intentoBox = new HBox();
		intentoBox.setAlignment(Pos.BASELINE_CENTER);
		intentoBox.setSpacing(5);
		intentoBox.getChildren().addAll(intento);

		HBox botonBox = new HBox();
		botonBox.setAlignment(Pos.BASELINE_CENTER);
		botonBox.setSpacing(5);
		botonBox.getChildren().addAll(boton);

		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(textoBox, intentoBox, botonBox);

		Scene escena = new Scene(root, 320, 200);

		primaryStage.setScene(escena);
		primaryStage.setTitle("AdivinApp");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
