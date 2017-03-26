package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.util.ArrayList;

/**
 * Created by Amans on 25/03/2017.
 */
public class ToolBarPartial extends HBox{
    private Button[] buttonRow;
    public ToolBarPartial(){
        setId("tool-bar");
        setIcon(new Image("images/icon.png"));
        buttonRow = createButtonRow(new String[]{"Home","Search","Access","Login"});
    }

    private void setIcon(Image icon){
        ImageView graphic = new ImageView(icon);
        graphic.setFitHeight(70);
        graphic.setFitWidth(70);
        Label labelIcon = new Label("", graphic);
        labelIcon.setId("icon");
        getChildren().add(labelIcon);
    }

    private Button[] createButtonRow(String[] buttonName){
        Button[] row = new Button[buttonName.length];
        HBox hbButtonRow = new HBox();
        hbButtonRow.setId("button-row");
        hbButtonRow.setMaxWidth(Double.MAX_VALUE);
        setHgrow(hbButtonRow,Priority.ALWAYS);
        for(int i = 0 ; i< buttonName.length;i++){
           Button btNew =  new Button(buttonName[i]);
           btNew.getStyleClass().add("menu-button");
           hbButtonRow.getChildren().add(btNew);
           btNew.setMaxHeight(Double.MAX_VALUE);
           btNew.setMaxWidth(Double.MAX_VALUE);
           HBox.setHgrow(btNew, Priority.ALWAYS);
           row[i] = btNew;
        }
        getChildren().add(hbButtonRow);
        return row;
    }



}
