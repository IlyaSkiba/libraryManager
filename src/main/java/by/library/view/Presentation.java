package by.library.view;

import by.library.services.configuration.ScreensConfig;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by homeUser on 19.01.2015.
 */
public abstract class Presentation {
    @Autowired
    protected ScreensConfig config;

}