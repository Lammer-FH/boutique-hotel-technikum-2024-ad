package com.technikum.boutiquehoteltechnikumadbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExtraDto {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;
}
