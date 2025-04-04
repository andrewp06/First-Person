package com.example;

import java.util.List;

public class RayIntersection {
    public static ColorDistancePair findFirstWall(Ray ray, List<Wall> walls){
        float closestT = Float.POSITIVE_INFINITY;
        Wall closestWall = null;

        float rayOX = ray.getOrigin().getX(), rayOY = ray.getOrigin().getY(), rayDX = ray.getDirection().getX(), rayDY = ray.getDirection().getY();
        int count = 0;
        for (Wall wall: walls){

            
            float wallAX = wall.getStart().getX(), wallAY = wall.getStart().getY(), wallBX = wall.getEnd().getX(), wallBY = wall.getEnd().getY();

            float rx = wallBX - wallAX, ry = wallBY - wallAY;

            float det = -rayDX * ry + rayDY * rx;
            
            
            
            if (Math.abs(det) < 1e-6f) continue;
            
            float invDet = 1.0f / det;
            
            float ox_ax = rayOX - wallAX, oy_ay = rayOY - wallAY;
            
            float t = (-ry * ox_ax + rx * oy_ay) * invDet;
            float u = (-rayDY * ox_ax + rayDX * oy_ay) * invDet;
            count++;

            if(count%2==1){
                System.out.println();
                System.out.print("rayDX = " + rayDX+", rayDY= "+rayDY);


                System.out.print("t= " + t + ", u= " + u);
            }

            if (t >= 0 && t < closestT) {
            
                    closestT = t; 
                    closestWall = wall;
                
            }
        }
        if(closestWall!=null){
            System.out.println("Closest intersection at t = " + closestT);
            return new ColorDistancePair(closestWall.getColor(), closestT);
        } else{
            return new ColorDistancePair(new Color(0, 0, 0), 0);
        }
    }
}
