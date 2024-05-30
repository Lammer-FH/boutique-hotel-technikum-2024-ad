package com.technikum.boutiquehoteltechnikumadbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class RoomDto {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("imagePath")
    private String imagePath;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("extras")
    private List<ExtraDto> extras;
}
