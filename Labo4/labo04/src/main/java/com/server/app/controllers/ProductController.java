package com.server.app.controllers;

import com.server.app.dto.request.ProductRequest;
import com.server.app.services.ProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping
    public Object findAll(
            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "10")
            int size,

            @RequestParam(defaultValue = "id")
            String sort
    ) {

        return service.findAll(
                page,
                size,
                sort
        );
    }

    @PostMapping
    public Object create(
            @RequestBody ProductRequest request,
            Authentication authentication
    ) {

        return service.create(
                request,
                authentication.getName()
        );
    }

    @PutMapping("/{id}")
    public Object update(
            @PathVariable Long id,
            @RequestBody ProductRequest request
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