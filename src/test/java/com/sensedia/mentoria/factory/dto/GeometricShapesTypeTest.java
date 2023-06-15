package com.sensedia.mentoria.factory.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeometricShapesTypeTest {


    @Test
    public void testValorEnum() {
        GeometricShapesType shapesType1 = GeometricShapesType.CIRCLE;
        Assertions.assertEquals(GeometricShapesType.CIRCLE, shapesType1);
        Assertions.assertEquals(GeometricShapesType.CIRCLE, GeometricShapesType.valueOf("CIRCLE"));

        GeometricShapesType shapesType2 = GeometricShapesType.RECTANGLE;
        Assertions.assertEquals(GeometricShapesType.RECTANGLE, shapesType2);
        Assertions.assertEquals(GeometricShapesType.RECTANGLE, GeometricShapesType.valueOf("RECTANGLE"));

        GeometricShapesType shapesType3 = GeometricShapesType.SQUARE;
        Assertions.assertEquals(GeometricShapesType.SQUARE, shapesType3);
        Assertions.assertEquals(GeometricShapesType.SQUARE, GeometricShapesType.valueOf("SQUARE"));

        GeometricShapesType shapesType4 = GeometricShapesType.TRIANGLE;
        Assertions.assertEquals(GeometricShapesType.TRIANGLE, shapesType4);
        Assertions.assertEquals(GeometricShapesType.TRIANGLE, GeometricShapesType.valueOf("TRIANGLE"));
    }
}
