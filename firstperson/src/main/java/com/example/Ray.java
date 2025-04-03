package com.example;

public class Ray {
    private Vector origin;
    private Vector direction;

    public Ray(Vector origin, Vector direction){
        this.direction = direction;
        this.origin = origin;
    }

    public Vector getDirection() {
        return direction;
    }public Vector getOrigin() {
        return origin;
    }
}
