package com.server.app.services.impl;

import com.server.app.dto.request.CatalogRequest;
import com.server.app.entities.Catalog;
import com.server.app.repositories.CatalogRepository;
import com.server.app.services.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository repository;

    @Override
    public Catalog create(CatalogRequest request) {

        Catalog catalog = new Catalog();

        catalog.setName(request.getName());

        return repository.save(catalog);
    }

    @Override
    public Catalog update(Long id, CatalogRequest request) {

        Catalog catalog =
                repository.findById(id)
                        .orElseThrow();

        catalog.setName(request.getName());

        return repository.save(catalog);
    }

    @Override
    public void delete(Long id) {

        repository.deleteById(id);
    }

    @Override
    public List<Catalog> findAll() {

        return repository.findAll();
    }
}