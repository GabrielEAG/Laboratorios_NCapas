package com.server.app.services.impl;

import com.server.app.dto.request.CategoryRequest;
import com.server.app.entities.Category;
import com.server.app.repositories.CategoryRepository;
import com.server.app.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Override
    public Category create(CategoryRequest request) {

        Category category = new Category();

        category.setName(request.getName());

        return repository.save(category);
    }

    @Override
    public Category update(Long id, CategoryRequest request) {

        Category category =
                repository.findById(id)
                        .orElseThrow();

        category.setName(request.getName());

        return repository.save(category);
    }

    @Override
    public void delete(Long id) {

        repository.deleteById(id);
    }

    @Override
    public List<Category> findAll() {

        return repository.findAll();
    }
}