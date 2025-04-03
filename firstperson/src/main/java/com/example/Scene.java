package com.example;

public class Scene {
    private static final int DEFUALT_FOV = 60;
    private Vector camera;
    private ImagePane imagePane;
    private Image image;


    private void initialCamera(int fov){
        //clamp fov from 60 to 120
        fov = Math.min(120, fov);
        fov = Math.max(fov, 60);

        camera = new Vector(0,0);
        Vector leftVector = new Vector(0,1);
        Vector righVector = new Vector(0,1);
        righVector.rotate(fov);
        imagePane = new ImagePane(leftVector, righVector);
    }
    private void initialCamera(){
        initialCamera(DEFUALT_FOV);
    }

    
    

}
