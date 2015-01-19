package by.library.invoke;

import by.library.services.configuration.ScreensConfig;
import by.library.services.configuration.SpringConfiguration;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Application entry point.
 *
 * @author Ilya Skiba.
 */

public class Data extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Platform.setImplicitExit(true);

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        ScreensConfig screens = context.getBean(ScreensConfig.class);

        screens.setPrimaryStage(primaryStage);
        screens.showMainScreen();
        screens.loadFirst();
    }
}
