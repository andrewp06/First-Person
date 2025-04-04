package com.example;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public class Image {
    private final int height,width,scale,screenWidth,screenHeight;
    private WritableImage image;
    private BufferedImage bufferedImage;

    public Image(int w, int h, int n){
        height = h;
        width = w;
        scale = 4/n;
        screenHeight = scale*height;
        screenWidth = scale*width;
        image = new WritableImage(width, height);
        bufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
    }

    public void plotPixel(int x, int y, Color color){
        int rgb = (Math.round(color.getR()*255) << 16) | (Math.round(color.getG()*255) << 8) | Math.round(color.getB()*255);
        image.getPixelWriter().setArgb(x, y, rgb);
    } 
    public void plotPixel(int x,int yStart, int height, Color color){
        int yEnd = yStart + height;
        int rgb = (Math.round(color.getR()*255) << 16) | (Math.round(color.getG()*255) << 8) | Math.round(color.getB()*255);
        for(int i = yStart; i<yEnd; i++){
            image.getPixelWriter().setArgb(x, i, rgb);
            bufferedImage.setRGB(x,i,rgb);
        }
    }
    public int getScreenHeight() {
        return screenHeight;
    }
    public int getScreenWidth() {
        return screenWidth;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public WritableImage getImage() {
        return image;
    }
    public  void saveWritableImageToPNG(String filePath) {
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        // Create a BufferedImage manually
        BufferedImage bImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        PixelReader reader = image.getPixelReader();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int argb = reader.getArgb(x, y);
                bImage.setRGB(x, y, argb);
            }
        }

        try {
            ImageIO.write(bImage, "png", new File(filePath));
            System.out.println("Saved image to: " + filePath);
        } catch (IOException e) {
            System.err.println("Failed to save image: " + e.getMessage());
        }
    }
    public void saveBufferedImageToPNG(String filePath) {
        // Create a File object to specify the output file path
        File outputFile = new File(filePath);
        
        try {
            // Write the BufferedImage to the file in PNG format
            ImageIO.write(bufferedImage, "PNG", outputFile);
            System.out.println("Image saved to: " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving image: " + e.getMessage());
        }
    }

}
