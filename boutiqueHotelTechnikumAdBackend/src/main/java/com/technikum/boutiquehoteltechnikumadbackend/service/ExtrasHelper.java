package com.technikum.boutiquehoteltechnikumadbackend.service;

import com.technikum.boutiquehoteltechnikumadbackend.domain.Extra;
import com.technikum.boutiquehoteltechnikumadbackend.model.ExtraDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExtrasHelper {

    static List<ExtraDto> createExtras(List<Extra> extras) {
        List<ExtraDto> extraDtos = new ArrayList<>();

        for (Extra extra: extras) {
            ExtraDto extraDto = new ExtraDto();
            extraDto.setName(extra.getName().name());
            extraDtos.add(extraDto);
        }
        return extraDtos;
    }
}
