package com.sensedia.mentoria.factory.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


public class Area {
    @Getter
    @JsonProperty("area")
    private double area;

    @JsonCreator
    public Area(@JsonProperty("area") double area) {
        this.area = area;
    }
}
