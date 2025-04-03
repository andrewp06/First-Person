package com.example;

public class Vector {
    private float x;
    private float y;


    public Vector(float x, float y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("<%d, %d>", x,y);
    }

    public static Vector vectorAddition(Vector vectorA, Vector vectorB){
        return new Vector(vectorB.x+vectorA.x, vectorB.y+vectorA.y);
    }

    public static Vector scalarMult(Vector vector, float scalar){
        return new Vector(vector.x*scalar, vector.y*scalar);
    }

    public static Vector vectorSubtraction(Vector vectorA, Vector vectorB){
        return vectorAddition(vectorA, scalarMult(vectorB, -1));
    }
    
    public void rotate(float degree){
        x = ((float)Math.cos(degree)*x) - ((float)Math.sin(degree)*y);
        y = ((float)Math.sin(degree)*x) + ((float)Math.cos(degree)*y);
    }
}
