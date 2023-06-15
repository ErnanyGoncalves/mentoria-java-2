package com.sensedia.mentoria.factory.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Value;


@Value
public class Area {
    @JsonProperty("area")
    private double area;

    @JsonCreator
    public Area(@JsonProperty("area") double area) {
        this.area = area;
    }
}