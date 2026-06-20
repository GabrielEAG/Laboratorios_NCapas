package com.server.app.services;

import com.server.app.dto.request.ProductRequest;
import com.server.app.dto.response.ProductPageResponse;
import com.server.app.entities.Product;
import org.springframework.data.domain.Page;

public interface ProductService {

    Product create(ProductRequest request, String username);

    Product update(Long id,
                   ProductRequest request);

    void delete(Long id);

    ProductPageResponse findAll(
            int page,
            int size,
            String sort
    );
}