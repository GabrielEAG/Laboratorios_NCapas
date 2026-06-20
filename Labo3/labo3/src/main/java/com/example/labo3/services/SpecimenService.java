package com.example.labo3.services;

import com.example.labo3.dto.CreateSpecimenRequest;
import com.example.labo3.dto.SpecimenResponse;
import com.example.labo3.dto.UpdateSpecimenRequest;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface SpecimenService {
    SpecimenResponse createSpecimen(CreateSpecimenRequest request);

    Page<SpecimenResponse> getAllSpecimens(int page, int size, String sortBy, String sortOrder);

    SpecimenResponse getSpecimenById(UUID id);

    SpecimenResponse updateSpecimen(UUID id, UpdateSpecimenRequest request);

    SpecimenResponse deleteSpecimen(UUID id);
}
