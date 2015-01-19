package by.library.invoke;

import by.library.controller.layout.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Optional;

/**
 * Application entry point.
 *
 * @author Ilya Skiba.
 */

public class Data extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader == null) {
            throw new IllegalAccessError("Class loader isn't initialized");
        }
        Parent root = FXMLLoader.load(classLoader.getResource("main.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
