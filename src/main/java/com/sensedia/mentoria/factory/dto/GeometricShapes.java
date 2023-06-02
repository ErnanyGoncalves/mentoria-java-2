package com.sensedia.mentoria.factory.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@AllArgsConstructor
@SuperBuilder
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "geometric_shapes_type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Rectangle.class, name = "rectangle"),
        @JsonSubTypes.Type(value = Square.class, name = "square"),
        @JsonSubTypes.Type(value = Triangle.class, name = "triangle"),
        @JsonSubTypes.Type(value = Circle.class, name = "circle")
})
public class GeometricShapes implements Serializable {

    GeometricShapesType geometricShapesType;
}
