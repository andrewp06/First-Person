package com.example;

public class Wall {
    private Vector start;
    private Vector end;
    private Color color;

    public Wall(Vector start, Vector end, Color color){
        this.start = start;
        this.end = end;
        this.color = color;
    }

    public Vector getEnd() {
        return end;
    }
    public Color getColor() {
        return color;
    }

    public Vector getStart() {
        return start;
    }
}

