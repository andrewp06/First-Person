package com.example;


import java.util.ArrayList;
import java.util.List;

public class Scene {
    private static final int DEFUALT_FOV = 60;
    private Vector camera;
    private ImagePane imagePane;
    private Image image;
    private final List<Wall> walls;


    private void initialCamera(int fov){
        //clamp fov from 60 to 120
        fov = Math.min(120, fov);
        fov = Math.max(fov, 60);
        System.out.println(fov);

        camera = new Vector(0,0);
        Vector leftVector = new Vector(0,1);
        Vector righVector = new Vector(0,1);
        righVector.rotate(fov);
        imagePane = new ImagePane(leftVector, righVector);
    }

    public Scene(int w, int h, int scale,int fov){ 
        walls = new ArrayList<>();
        walls.add(new Wall(new Vector(0, 4), new Vector(4, 4), new Color(1, 0, 0)));
        walls.add(new Wall(new Vector(4, 4), new Vector(4, 0), new Color(0, 1, 0)));

        image = new Image(w, h, scale);
        initialCamera(fov);
    }
    public Scene(int w, int h, int scale){
        this(w, h, scale, DEFUALT_FOV);
    }

    public void colorFrame(){
        for(int i = 0; i<image.getWidth();i++){
            float alpha = (float)i/image.getWidth();
            Vector point = Vector.vectorAddition(Vector.scalarMult(imagePane.getLeft(), 1-alpha), Vector.scalarMult(imagePane.getRight(), alpha));
            Ray ray = new Ray(point, Vector.vectorSubtraction(camera,point).normalize());
            ColorDistancePair colorDistance = RayIntersection.findFirstWall(ray, walls);
            colorColumn(colorDistance, i);
        }
    }

    private void colorColumn(ColorDistancePair colorDistance,int col){
        Color color = colorDistance.getColor();
        float distance  = colorDistance.getDistance();
        //TODO added calc for distance and wall height
        image.plotPixel(col, 0, image.getHeight(), color);
    }
    public Image getImage() {
        return image;
    }
    public ImagePane getImagePane() {
        return imagePane;
    }
    
    public static void main(String[] args) {
        Scene scene = new Scene(800,500,2,100);
        System.out.println(scene.imagePane.getLeft()+"  "+scene.imagePane.getRight());
        scene.colorFrame();
        scene.getImage().saveBufferedImageToPNG("photos.png");
    }
}
