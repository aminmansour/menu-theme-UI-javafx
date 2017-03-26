package view;

import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * Created by Amans on 25/03/2017.
 */
public class GlobalLayout extends BorderPane{
    public GlobalLayout(Pane currentPage){
           getStylesheets().add("style/interface.css");
           setId("global");
           setTop(new ToolBarPartial());
           setBottom(new FooterPartial());
           setCenter(new Home());

    }

}
