package ru.dpopkov.apatheia.pomodoro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Main class.
 * VM options for IDE Run configuration:
 * --module-path C:\path-to-javafx\javafx-sdk-11\lib --add-modules=javafx.controls,javafx.fxml,javafx.media
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        root.getChildren().add(new Label("Hello FX!!!"));
        primaryStage.setTitle("Pomodoro");
        primaryStage.setScene(new Scene(root, 500, 320));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
