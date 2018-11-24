package com;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CSS extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
      //  Application.setUserAgentStylesheet(getClass().getResource("mycss.css").toExternalForm());
        Button button=new Button("press");
        button.setId("my-button");
       // button.setStyle("-fx-font-size: 60;");
     //   button.getStyleClass().add("mystyle");
        Group root=new Group();
        Scene scene=new Scene(root,700,400);
        scene.getStylesheets().add(getClass().getResource("mycss.css").toExternalForm());
        root.getChildren().add(button);
        primaryStage.setTitle("Hello World !!!");
        primaryStage.setScene ( scene);
        primaryStage.show();
    }
}








































