package com.example.labo3.mappers;

import com.example.labo3.dto.CreateSpecimenRequest;
import com.example.labo3.dto.SpecimenResponse;
import com.example.labo3.dto.UpdateSpecimenRequest;
import com.example.labo3.entity.Specimen;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SpecimenMapper {

    public Specimen toEntityCreate(CreateSpecimenRequest request) {
        return Specimen.builder()
                .name(request.getName())
                .region(request.getRegion())
                .dangerLevel(request.getDangerLevel())
                .isFriendly(request.getIsFriendly())
                .build();
    }

    public Specimen toEntityUpdate(UpdateSpecimenRequest request, UUID id) {
        return Specimen.builder()
                .id(id)
                .name(request.getName())
                .region(request.getRegion())
                .dangerLevel(request.getDangerLevel())
                .isFriendly(request.getIsFriendly())
                .build();
    }

    public SpecimenResponse toDto(Specimen specimen) {
        return SpecimenResponse.builder()
                .id(specimen.getId())
                .name(specimen.getName())
                .region(specimen.getRegion())
                .dangerLevel(specimen.getDangerLevel())
                .isFriendly(specimen.getIsFriendly())
                .build();
    }

    // Reto de paginacion: convierte un Page<Specimen> en un Page<SpecimenResponse>
    public Page<SpecimenResponse> toDtoPage(Page<Specimen> specimenPage) {
        return specimenPage.map(this::toDto);
    }
}
