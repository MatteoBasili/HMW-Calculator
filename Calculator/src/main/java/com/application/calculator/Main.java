package com.application.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.util.Objects;
import org.apache.log4j.Logger;

public class Main extends Application {

    private static final Logger logger = Logger.getLogger(Main.class);

    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Interface.fxml")));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
            primaryStage.setTitle("Calculator");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch(Exception e) {
            logger.error("Error: ", e);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
