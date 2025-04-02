package com.example;

public class Scene {
    private Vector camera;
    private ImagePane imagePane;
    private Image image;

    private void initialCamera(int fov){
        //clamp fov from 60 to 120
        fov = Math.min(120, fov);
        fov = Math.max(fov, 60);

        camera = new Vector(0,0);
        Vector leftVector = new Vector(0,1);
        Vector righVector = new Vector( (float)Math.sin(fov), (float)Math.cos(fov));
        imagePane = new ImagePane(leftVector, righVector);
    }

    

}
