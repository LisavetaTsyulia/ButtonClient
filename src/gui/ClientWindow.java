package gui;

import client.Client;
import control.Controller;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class ClientWindow extends Application{
    public Controller controller;
    public Label lbl;


    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        primaryStage.setTitle("THE BUTTON");
        controller = new Controller();
        ButtonScene buttonScene = new ButtonScene(root, 400, 400, controller);
        buttonScene.fillScene();
        primaryStage.setScene(buttonScene);
        primaryStage.show();
        Client client = new Client(controller);
    }

    public static void main(String[] args) {
        //controller.setCounterLbl(lbl);
        launch(args);
    }
}
