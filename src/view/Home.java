package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import jdk.internal.util.xml.impl.Pair;

/**
 * Created by Amans on 25/03/2017.
 */
public class Home extends ScrollPane{
    private final VBox vbUp;

    public Home(){
        setId("home");
        String[][] boxDefinition = new String[][]{
                {"Home","images/world-icon.png","Do what you want!"},
                {"Notices","images/setting-icon.png","Be yourself and dont let anybody."},
                {"Analytics","images/view-icon.png","Please be yourself!"},
                {"Home","images/world-icon.png","Do what you want!"},
                {"Notices","images/setting-icon.png","Be yourself and dont let anybody."},
                {"Analytics","images/view-icon.png","Please be yourself!"},

        };
        vbUp = new VBox();
        vbUp.setId("home-grid");
        vbUp.setSpacing(30);
        setUpGrid(boxDefinition,3);
        BorderPane bpStructure = new BorderPane();
        bpStructure.setCenter(vbUp);
        setContent(bpStructure);
        setFitToWidth(true);
        setFitToHeight(true);




    }

    public HBox createBox(String name,String iconURL,String description){
        HBox box = new HBox();
        box.setAlignment(Pos.CENTER);
        box.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        HBox.setHgrow(box, Priority.ALWAYS);
        box.getStyleClass().add("home-boxes");
        VBox vbStack = new VBox();
        vbStack.getStyleClass().add("home-boxes-content");
        vbStack.setAlignment(Pos.CENTER);
        vbStack.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        HBox.setHgrow(vbStack,Priority.ALWAYS);
        vbStack.getChildren().add(createIcon(new Image(iconURL)));
        vbStack.getChildren().add(new Label(name));
        TextArea boxDescription = new TextArea(description);
        boxDescription.setEditable(false);
        vbStack.getChildren().add(boxDescription);
        Button button = new Button("View");
        button.getStyleClass().add("green-button-theme");
        vbStack.getChildren().add(button);
        box.getChildren().add(vbStack);
        return box;

    }

    private Label createIcon(Image icon){
        ImageView graphic = new ImageView(icon);
        graphic.setFitHeight(60);
        graphic.setFitWidth(60);
        Label labelIcon = new Label("", graphic);
        return labelIcon;
    }


    public void setUpGrid(String[][] boxes,int boxesInRow){
        int columnCount = 0;
        HBox currentRow = createRow();
        vbUp.getChildren().add(currentRow);
        for(int i = 0 ; i< boxes.length; ++i){
            currentRow.getChildren().add(createBox(boxes[i][0],boxes[i][1],boxes[i][2]));
            columnCount++;
            if(columnCount == boxesInRow){
                columnCount = 0;
                currentRow = createRow();
                vbUp.getChildren().add(currentRow);
            }
        }
    }

    public HBox createRow(){
        HBox row = new HBox();
        row.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(row,Priority.ALWAYS);
        row.setSpacing(30);
        return row;
    }


}
