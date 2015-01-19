package by.library.services.configuration;

import by.library.view.Presentation;
import by.library.view.main.FirstPresentation;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by homeUser on 19.01.2015.
 */
@Configuration
@Lazy
public class ScreensConfig implements Observer {
    public static final int WIDTH = 480;
    public static final int HEIGHT = 320;
    public static final String STYLE_FILE = "main.css";
    private static Logger logger = LoggerFactory.getLogger(ScreensConfig.class);
    private Stage stage;
    private Scene scene;
    private StackPane root;
    @Autowired
    private FirstPresentation firstPresentation;

    public void setPrimaryStage(Stage primaryStage) {
        this.stage = primaryStage;
    }

    public void showMainScreen() {
        root = new StackPane();
        //root.getStylesheets().add(STYLE_FILE);
        root.getStyleClass().add("main-window");
        stage.setTitle("SpringFX");
        scene = new Scene(root, WIDTH, HEIGHT);
        stage.setScene(scene);
        // stage.setOnHiding(event -> System.exit(0));
        stage.show();
    }

    private void setNode(Node node) {
        root.getChildren().setAll(node);
    }

    public void removeNode(Node node) {
        root.getChildren().remove(node);
    }

    public void loadFirst() {
        setNode(getNode(firstPresentation, getClass().getClassLoader().getResource("main.fxml")));
    }

    private Node getNode(final Presentation control, URL location) {
        FXMLLoader loader = new FXMLLoader(location);
        loader.setControllerFactory(aClass -> control);
        try {
            return (Node) loader.load();
        } catch (Exception e) {
            logger.error("Error casting node", e);
            return null;
        }
    }

    public Stage getStage() {
        return stage;
    }

    @Override
    public void update(Observable o, Object arg) {
        loadFirst();
    }
}