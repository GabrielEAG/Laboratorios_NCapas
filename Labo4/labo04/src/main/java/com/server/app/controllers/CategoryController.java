package com.server.app.controllers;

import com.server.app.dto.request.CategoryRequest;
import com.server.app.services.CategoryService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @GetMapping
    public Object findAll() {
        return service.findAll();
    }

    @PostMapping
    public Object create(
            @RequestBody CategoryRequest request
    ) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public Object update(
            @PathVariable Long id,
            @RequestBody CategoryRequest request
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