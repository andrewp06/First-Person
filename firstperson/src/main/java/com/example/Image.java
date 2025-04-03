package com.example;
import java.awt.image.BufferedImage;

public class Image {
    private final int height,width,scale,screenWidth,screenHeight;
    private BufferedImage image;

    public Image(int w, int h, int n){
        height = h;
        width = w;
        scale = 4/n;
        screenHeight = scale*height;
        screenWidth = scale*width;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    public void plotPixel(int x, int y, Color color){
        int rgb = (Math.round(color.getR()*255) << 16) | (Math.round(color.getG()*255) << 8) | Math.round(color.getB()*255);
        image.setRGB(x, y, rgb);
    } 

}
