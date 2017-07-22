package gui;

import control.Controller;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import static java.lang.Thread.sleep;

public class ButtonScene extends Scene{
    private Group group;
    private Label lblCount;
    private Controller controller;

    public ButtonScene(Parent root, double width, double height, Controller controller) {
        super(root, width, height);
        this.group = (Group) root;
        this.controller = controller;
        this.getStylesheets().add("css/styles.css");
    }

    public void fillScene() {
        VBox vBox = new VBox();
        vBox.setLayoutX(20);
        vBox.setSpacing(10);
        vBox.setPrefSize(350, 350);
        vBox.setAlignment(Pos.CENTER);

        lblCount = new Label("");
        lblCount.setAlignment(Pos.CENTER);
        lblCount.getStyleClass().add("header");
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        controller.setCounterLbl(lblCount);

        Button button = new Button("Push");
        button.setAlignment(Pos.CENTER);
        button.setShape(new Circle(100));
        button.setPrefSize(200, 200);
        button.setOnAction(e->{
            controller.pushButton();
        });

        vBox.getChildren().addAll(lblCount, button);
        group.getChildren().addAll(vBox);
    }


}
