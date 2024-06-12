package com.technikum.boutiquehoteltechnikumadbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationRequestBody {
    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("eMail")
    private String eMail;

    @JsonProperty("doBreakfast")
    private Boolean doBreakfast;

    @JsonProperty("from")
    private LocalDate from;

    @JsonProperty("to")
    private LocalDate to;
}
