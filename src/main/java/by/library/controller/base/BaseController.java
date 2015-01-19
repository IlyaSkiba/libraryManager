package by.library.controller.base;

import javafx.scene.Node;

/**
 * Created by Ilya on 11.01.2015.
 */
public interface BaseController<T extends Node> {
    T getView();
    void setView(T view);
}
