package com.example;

public class ImagePane {
    private Vector left;
    private Vector right;

    public ImagePane(Vector left, Vector right){
        this.left = left;
        this.right = right;
    }

    public Vector getLeft() {
        return left;
    }
    public Vector getRight() {
        return right;
    }

    public void move(Vector movement){
        left = Vector.vectorAddition(left, movement);
        right = Vector.vectorAddition(right, movement);
    }

    public void rotate(float degrees){
        left.rotate(degrees);
        right.rotate(degrees);
    }
}
