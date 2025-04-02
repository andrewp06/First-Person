package com.example;

public class ImagePane {
    @SuppressWarnings("unused")
    private Vector topLeft;
    @SuppressWarnings("unused")
    private Vector topRight;
    @SuppressWarnings("unused")
    private Vector bottomRight;
    @SuppressWarnings("unused")
    private Vector bottomLeft;

    public ImagePane(Vector topLeft, Vector topRight, Vector bottomRight, Vector bottomLeft){
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight  = bottomRight;
    }
}
