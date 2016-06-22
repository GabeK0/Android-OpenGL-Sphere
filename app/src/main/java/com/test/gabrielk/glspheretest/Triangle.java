package com.test.gabrielk.glspheretest;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * Created by GabrielK on 6/21/2016.
 */

public class Triangle {





    private FloatBuffer vertexBuffer;
    private final int mBytesPerFloat = 4;


    public Triangle(float [] verticesData) {


        vertexBuffer = ByteBuffer.allocateDirect(verticesData.length * mBytesPerFloat)
                .order(ByteOrder.nativeOrder()).asFloatBuffer();
        vertexBuffer.put(verticesData).position(0);
    }

    public FloatBuffer getVertexBuffer() {
        return vertexBuffer;
    }
}
