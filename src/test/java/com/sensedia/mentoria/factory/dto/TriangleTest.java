package com.sensedia.mentoria.factory.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TriangleTest {
    @Test
    void testConstructor() {
        Triangle triangle = new Triangle();
        Assertions.assertEquals(GeometricShapesType.TRIANGLE, triangle.getGeometricShapesType());
        Assertions.assertEquals(0.0, triangle.getBase());
        Assertions.assertEquals(0.0, triangle.getHeight());
    }

    @Test
    void testParameterizedConstructor() {
        double base = 5.0;
        double height = 10.0;
        Triangle triangle = Triangle.builder().geometricShapesType(GeometricShapesType.TRIANGLE).base(base).height(height).build();
        Assertions.assertEquals(GeometricShapesType.TRIANGLE, triangle.getGeometricShapesType());
        Assertions.assertEquals(base, triangle.getBase());
        Assertions.assertEquals(height, triangle.getHeight());
    }

    @Test
    void testGettersAndSetters() {
        Triangle triangle = new Triangle();
        double base = 10.0;
        double height = 20.0;
        triangle.setBase(base);
        triangle.setHeight(height);

        Assertions.assertEquals(base, triangle.getBase());
        Assertions.assertEquals(height, triangle.getHeight());
    }
    
}
