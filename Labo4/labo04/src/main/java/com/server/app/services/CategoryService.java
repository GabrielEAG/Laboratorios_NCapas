package com.server.app.services;

import com.server.app.dto.request.CategoryRequest;
import com.server.app.entities.Category;

import java.util.List;

public interface CategoryService {

    Category create(CategoryRequest request);

    Category update(Long id, CategoryRequest request);

    void delete(Long id);

    List<Category> findAll();
}