package com.sensedia.mentoria.factory.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

    @Data
    @SuperBuilder
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public class Circle extends GeometricShapes implements Serializable {

        private double radius;

        public Circle() {
            super(GeometricShapesType.CIRCLE);
        }
    }
