package com.sensedia.mentoria.factory.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Square extends GeometricShapes implements Serializable {

    private double side;

    public Square() {
        super(GeometricShapesType.SQUARE);
    }
}
