package com.server.app.controllers;

import com.server.app.dto.request.CatalogRequest;
import com.server.app.services.CatalogService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/catalogos")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService service;

    @GetMapping
    public Object findAll() {
        return service.findAll();
    }

    @PostMapping
    public Object create(
            @RequestBody CatalogRequest request
    ) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public Object update(
            @PathVariable Long id,
            @RequestBody CatalogRequest request
    ) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) {
        service.delete(id);
    }
}