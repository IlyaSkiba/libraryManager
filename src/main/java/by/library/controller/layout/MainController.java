package by.library.controller.layout;

import by.library.controller.base.BaseController;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * Created by Ilya on 11.01.2015.
 */
public class MainController implements BaseController<GridPane> {
    public Button reindexInvoke;
    public GridPane layout;


    @Override
    public GridPane getView() {
        return layout;
    }

    @Override
    public void setView(GridPane view) {
        this.layout = view;
    }
}
