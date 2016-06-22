package com.test.gabrielk.glspheretest;

import android.util.Log;

/**
 * Created by GabrielK on 6/21/2016.
 */

//          Sphere Trapezoid
public class SphereTrap {


    private double theta, phi;
    private double[][] spherePoints;
    private double[][] vertexPoints;
    private Triangle tri1;
    private Triangle tri2;


    public SphereTrap(int zoom, int row, int col) {
        double inc = Math.PI * 2 / Math.pow(2, zoom);
        theta = row * inc - Math.PI;
        //phi = col * inc - Math.PI;
        phi = col * inc / 2;

        spherePoints = new double[][] {{theta, phi}, {theta + inc, phi}, {theta + inc, phi + inc / 2}, {theta, phi + inc / 2}};
        vertexPoints = new double[4][3];
        for (int i = 0; i < spherePoints.length; i ++)
            vertexPoints[i] = sphereToXYZ(spherePoints[i]);

        tri1 = new Triangle(new float[] {
                (float) (vertexPoints[0][0]),(float) (vertexPoints[0][1]), (float) (vertexPoints[0][2]),
                1.0f, 1.0f, 1.0f, 1.0f,

                (float) (vertexPoints[1][0]),(float) (vertexPoints[1][1]), (float) (vertexPoints[1][2]),
                0.0f, 0.0f, 0.0f, 1.0f,

                (float) (vertexPoints[3][0]),(float) (vertexPoints[3][1]), (float) (vertexPoints[3][2]),
                1.0f, 1.0f, 1.0f, 1.0f});

        tri2 = new Triangle(new float[] {
                (float) (vertexPoints[3][0]),(float) (vertexPoints[3][1]), (float) (vertexPoints[3][2]),
                1.0f, 1.0f, 1.0f, 1.0f,

                (float) (vertexPoints[1][0]),(float) (vertexPoints[1][1]), (float) (vertexPoints[1][2]),
                0.0f, 0.0f, 0.0f, 1.0f,

                (float) (vertexPoints[2][0]),(float) (vertexPoints[2][1]), (float) (vertexPoints[2][2]),
                1.0f, 1.0f, 1.0f, 1.0f,});
    }

    private double[] sphereToXYZ(double[] p) {
        if (p.length != 2)
            Log.e("DEBUG", "you dun goofed");

        return new double[] {Math.cos(p[0]) * Math.sin(p[1]), Math.sin(p[0]) * Math.sin(p[1]), Math.cos(p[1])};

    }

    public Triangle getTri1() {
        return tri1;
    }

    public Triangle getTri2() {
        return tri2;
    }
}
