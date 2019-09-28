package co.edu.udea.tecnicas.cuentas;


import java.awt.geom.Rectangle2D;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/contenedor-principal.fxml"));
        primaryStage.setTitle("Sucursal Virtual");
        primaryStage.setScene(new Scene(root, 300, 315));
        primaryStage.show();
        
        
    }


    public static void main(String[] args) {
        launch(args);
    }
}