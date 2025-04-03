package com.example;

public class Scene {
    private static final int DEFUALT_FOV = 60;
    private Vector camera;
    private ImagePane imagePane;
    private Image image;
    private static final int[][] walls={{3,1,0,0,0,1,2},
                                        {0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0},
                                        {3,4,0,0,0,4,2}};


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

    public Scene(int w, int h, int scale,int fov){
        image = new Image(w, h, scale);
        initialCamera(fov);
    }
    public Scene(int w, int h, int scale){
        this(w, h, scale, DEFUALT_FOV);
    }

}
