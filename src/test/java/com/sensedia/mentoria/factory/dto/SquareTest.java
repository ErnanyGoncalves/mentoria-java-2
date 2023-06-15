package com.sensedia.mentoria.factory.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SquareTest {
    @Test
    void testConstructor() {
        Square square = new Square();
        Assertions.assertEquals(GeometricShapesType.SQUARE, square.getGeometricShapesType());
        Assertions.assertEquals(0.0, square.getSide());
    }

    @Test
    void testParameterizedConstructor() {
        double side = 5.0;
        Square square = Square.builder().geometricShapesType(GeometricShapesType.SQUARE).side(side).build();
        Assertions.assertEquals(GeometricShapesType.SQUARE, square.getGeometricShapesType());
        Assertions.assertEquals(side, square.getSide());
    }

    @Test
    void testGettersAndSetters() {
        Square square = new Square();
        double side = 10.0;
        square.setSide(side);
        Assertions.assertEquals(side, square.getSide());
    }
    
}
