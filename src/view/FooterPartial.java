package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 * Created by Amans on 25/03/2017.
 */
public class FooterPartial extends HBox {

    public FooterPartial(){
        setId("footer");

        FlowPane fpIcons = new FlowPane();
        FlowPane fpOther = new FlowPane();

        populateIcons(fpIcons);
        populateOther(fpOther,new String[]{"About","Terms","Help"});
    }

    private void populateOther(FlowPane fpOther,String[] names) {
        fpOther.setAlignment(Pos.CENTER_RIGHT);
        fpOther.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(fpOther, Priority.ALWAYS);
        fpOther.setHgap(30);

        for(int i = 0 ; i< names.length; ++i){
            Button button = new Button(names[i]);
            button.getStyleClass().add("footer-other-button");
            fpOther.getChildren().add(button);
        }

        getChildren().add(fpOther);
        fpOther.setId("footer-others");

    }

    private void populateIcons(FlowPane fpIcons) {
        fpIcons.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(fpIcons,Priority.ALWAYS);
        fpIcons.setId("footer-icons");
        fpIcons.setHgap(10);

        fpIcons.getChildren().add(createIcon(new Image("images/world-icon.png")));
        fpIcons.getChildren().add(createIcon(new Image("images/view-icon.png")));
        fpIcons.getChildren().add(createIcon(new Image("images/setting-icon.png")));

        getChildren().add(fpIcons);

    }

    private Label createIcon(Image icon){
        ImageView graphic = new ImageView(icon);
        graphic.setFitHeight(30);
        graphic.setFitWidth(30);
        Label labelIcon = new Label("", graphic);
        labelIcon.setId("icon");
        return labelIcon;
    }

}
