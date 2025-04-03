package com.example;

public class ColorDistancePair {
    private Color color;
    private float distance;
    
    public ColorDistancePair(Color color, float distance){
        this.color = color;
        this.distance = distance;
    }

    public Color getColor() {
        return color;
    }

    public float getDistance() {
        return distance;
    }
}
