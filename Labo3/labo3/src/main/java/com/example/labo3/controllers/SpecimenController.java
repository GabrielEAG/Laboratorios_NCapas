package com.example.labo3.controllers;

import com.example.labo3.dto.CreateSpecimenRequest;
import com.example.labo3.dto.SpecimenResponse;
import com.example.labo3.dto.UpdateSpecimenRequest;
import com.example.labo3.dto.response.GeneralResponse;
import com.example.labo3.dto.response.PageableResponse;
import com.example.labo3.services.SpecimenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/specimens")
@RequiredArgsConstructor
public class SpecimenController {

    private final SpecimenService specimenService;

    @PostMapping
    public ResponseEntity<GeneralResponse<SpecimenResponse>> createSpecimen(
            @Valid @RequestBody CreateSpecimenRequest request,
            HttpServletRequest httpRequest) {

        SpecimenResponse created = specimenService.createSpecimen(request);
        return buildResponse("Specimen successfully registered in the Sheikah Slate",
                HttpStatus.CREATED, created, httpRequest);
    }

    @GetMapping
    public ResponseEntity<GeneralResponse<PageableResponse<SpecimenResponse>>> getAllSpecimens(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder,
            HttpServletRequest httpRequest) {

        Page<SpecimenResponse> specimenPage =
                specimenService.getAllSpecimens(page, size, sortBy, sortOrder);

        PageableResponse<SpecimenResponse> pageableResponse = PageableResponse.fromPage(specimenPage);

        return buildResponse("Specimens retrieved successfully",
                HttpStatus.OK, pageableResponse, httpRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponse<SpecimenResponse>> getSpecimenById(
            @PathVariable UUID id,
            HttpServletRequest httpRequest) {

        SpecimenResponse specimen = specimenService.getSpecimenById(id);
        return buildResponse("Specimen retrieved successfully",
                HttpStatus.OK, specimen, httpRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneralResponse<SpecimenResponse>> updateSpecimen(
            @PathVariable UUID id,
            @RequestBody UpdateSpecimenRequest request,
            HttpServletRequest httpRequest) {

        SpecimenResponse updated = specimenService.updateSpecimen(id, request);
        return buildResponse("Specimen successfully updated",
                HttpStatus.OK, updated, httpRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GeneralResponse<SpecimenResponse>> deleteSpecimen(
            @PathVariable UUID id,
            HttpServletRequest httpRequest) {

        SpecimenResponse deleted = specimenService.deleteSpecimen(id);
        return buildResponse("Specimen successfully removed from Sheikah Slate records",
                HttpStatus.OK, deleted, httpRequest);
    }

    // Funcion utilitaria: estandariza TODAS las respuestas exitosas de la API
    private <T> ResponseEntity<GeneralResponse<T>> buildResponse(
            String message, HttpStatus status, T data, HttpServletRequest request) {

        GeneralResponse<T> response = GeneralResponse.<T>builder()
                .message(message)
                .status(status.value())
                .timestamp(LocalDateTime.now())
                .path(request.getRequestURI())
                .data(data)
                .build();

        return new ResponseEntity<>(response, status);
    }
}
