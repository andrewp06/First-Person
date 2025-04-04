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
        return String.format("<%f, %f>", x,y);
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
        float radians = (float)Math.toRadians(-degree);
        float newX = ((float)Math.cos(radians)*x) - ((float)Math.sin(radians)*y);
        float newY = ((float)Math.sin(radians)*x) + ((float)Math.cos(radians)*y);
        x = newX;
        y = newY;
    }

    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }

    public float magnitude(){
        return (float)Math.sqrt(Math.pow(y, 2)+Math.pow(x, 2));
    }
    public Vector normalize(){
        return scalarMult(this, 1/this.magnitude());
        
    }
}
