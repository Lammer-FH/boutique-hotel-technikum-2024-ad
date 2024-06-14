package com.technikum.boutiquehoteltechnikumadbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExtraDto {
    @JsonProperty("name")
    private String name;
}
