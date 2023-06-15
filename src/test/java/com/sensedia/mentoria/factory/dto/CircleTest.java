package com.sensedia.mentoria.factory.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class CircleTest {
    @Test
    void testConstructor() {
        Circle circle = new Circle();
        Assertions.assertEquals(GeometricShapesType.CIRCLE, circle.getGeometricShapesType());
        Assertions.assertEquals(0.0, circle.getRadius());
    }

    @Test
    void testParameterizedConstructor() {
        double radius = 5.0;
        Circle circle = Circle.builder().geometricShapesType(GeometricShapesType.CIRCLE).radius(radius).build();
        Assertions.assertEquals(GeometricShapesType.CIRCLE, circle.getGeometricShapesType());
        Assertions.assertEquals(radius, circle.getRadius());
    }

    @Test
    void testGettersAndSetters() {
        Circle circle = new Circle();
        double radius = 10.0;
        circle.setRadius(radius);
        Assertions.assertEquals(radius, circle.getRadius());
    }
    
}
