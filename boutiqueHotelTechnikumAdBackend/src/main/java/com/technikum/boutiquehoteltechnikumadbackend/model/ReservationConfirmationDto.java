package com.technikum.boutiquehoteltechnikumadbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ReservationConfirmationDto {
    @JsonProperty("from")
    private LocalDateTime from;

    @JsonProperty("to")
    private LocalDateTime to;

    @JsonProperty("roomTitle")
    private String roomTitle;

    @JsonProperty("roomDescription")
    private String roomDescription;

    @JsonProperty("imagePath")
    private String roomImage;

    @JsonProperty("roomPrice")
    private BigDecimal roomPrice;

    @JsonProperty("extras")
    private List<ExtraDto> extras;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("eMail")
    private String eMail;

    @JsonProperty("doBreakfast")
    private Boolean doBreakfast;
}
