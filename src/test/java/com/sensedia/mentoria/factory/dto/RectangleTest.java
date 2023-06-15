package com.sensedia.mentoria.factory.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class RectangleTest {
    @Test
    void testConstructor() {
        Rectangle rectangle = new Rectangle();
        Assertions.assertEquals(GeometricShapesType.RECTANGLE, rectangle.getGeometricShapesType());
        Assertions.assertEquals(0.0, rectangle.getBase());
        Assertions.assertEquals(0.0, rectangle.getHeight());
    }

    @Test
    void testParameterizedConstructor() {
        double base = 5.0;
        double height = 10.0;
        Rectangle rectangle = Rectangle.builder().geometricShapesType(GeometricShapesType.RECTANGLE).base(base).height(height).build();
        Assertions.assertEquals(GeometricShapesType.RECTANGLE, rectangle.getGeometricShapesType());
        Assertions.assertEquals(base, rectangle.getBase());
        Assertions.assertEquals(height, rectangle.getHeight());
    }

    @Test
    void testGettersAndSetters() {
        Rectangle rectangle = new Rectangle();
        double base = 10.0;
        double height = 20.0;
        rectangle.setBase(base);
        rectangle.setHeight(height);

        Assertions.assertEquals(base, rectangle.getBase());
        Assertions.assertEquals(height, rectangle.getHeight());
    }
    
}
