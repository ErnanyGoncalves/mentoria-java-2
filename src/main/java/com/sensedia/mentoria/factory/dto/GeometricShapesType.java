package com.sensedia.mentoria.factory.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum GeometricShapesType {

    @JsonProperty("rectangle")
    RECTANGLE,
    @JsonProperty("square")
    SQUARE,
    @JsonProperty("triangle")
    TRIANGLE,
    @JsonProperty("circle")
    CIRCLE

}
