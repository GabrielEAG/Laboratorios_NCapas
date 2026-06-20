package com.server.app.services;

import com.server.app.dto.request.CatalogRequest;
import com.server.app.entities.Catalog;

import java.util.List;

public interface CatalogService {

    Catalog create(CatalogRequest request);

    Catalog update(Long id, CatalogRequest request);

    void delete(Long id);

    List<Catalog> findAll();
}