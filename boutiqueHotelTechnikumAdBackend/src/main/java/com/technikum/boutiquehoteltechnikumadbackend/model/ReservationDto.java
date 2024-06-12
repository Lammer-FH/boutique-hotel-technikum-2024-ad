package com.technikum.boutiquehoteltechnikumadbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ReservationDto {
    @JsonProperty("reservationId")
    private Integer reservationId;

    @JsonProperty("roomTitle")
    private String roomTitle;
}
