package com.example;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.image.ImageView;

import javafx.scene.layout.HBox;
import javafx.stage.Stage;



public class Screen extends Application {
    private long lastUpdate = 0;

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(800,500,2);
        ImageView imageView = new ImageView(scene.getImage().getImage());

        HBox hBox = new HBox();
        hBox.getChildren().add(imageView);
        javafx.scene.Scene fxScene = new javafx.scene.Scene(hBox);
        stage.setTitle("firstPerson");
        stage.setScene(fxScene);
        stage.show();


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Update every 500ms (to avoid excessive updates)
                if (now - lastUpdate >= 500_000_000) { // 500ms in nanoseconds
                    scene.colorFrame();
                    lastUpdate = now;
                    System.out.println("update");
                }
                
            }
        };

        timer.start();
        System.out.println("update");

    }

    public static void main(String[] args) {
        System.out.println("update");

        launch(args);
    }
    
}
