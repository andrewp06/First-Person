package com.example;

public class Vector {
    private float x;
    private float y;
    private float z;

    public Vector(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return String.format("<%d, %d, %d>", x,y,z);
    }

    public static Vector vectorAddition(Vector vectorA, Vector vectorB){
        return new Vector(vectorB.x+vectorA.x, vectorB.y+vectorA.y, vectorB.z+vectorA.z);
    }

    public static Vector scalarMult(Vector vector, float scalar){
        return new Vector(vector.x*scalar, vector.y*scalar, vector.z*scalar);
    }

    public static Vector vectorSubtraction(Vector vectorA, Vector vectorB){
        return vectorAddition(vectorA, scalarMult(vectorB, -1));
    }
}
