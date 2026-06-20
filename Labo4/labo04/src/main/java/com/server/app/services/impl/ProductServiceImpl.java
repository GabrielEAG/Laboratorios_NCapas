package com.server.app.services.impl;

import com.server.app.dto.request.ProductRequest;
import com.server.app.dto.response.*;
import com.server.app.entities.*;
import com.server.app.repositories.*;
import com.server.app.services.ProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final CatalogRepository catalogRepository;

    private final CategoryRepository categoryRepository;

    private final UserRepository userRepository;

    @Override
    public Product create(
            ProductRequest request,
            String username
    ) {

        User user =
                userRepository.findUserByUsername(username)
                        .orElseThrow();

        Catalog catalog =
                catalogRepository.findById(request.getCatalogId())
                        .orElseThrow();

        Category category =
                categoryRepository.findById(request.getCategoryId())
                        .orElseThrow();

        Product product = new Product();

        product.setName(request.getName());

        product.setPrice(request.getPrice());

        product.setCatalog(catalog);

        product.setCategory(category);

        product.setCreatedBy(user);

        product.setCreatedAt(LocalDateTime.now());

        return productRepository.save(product);
    }

    @Override
    public Product update(
            Long id,
            ProductRequest request
    ) {

        Product product =
                productRepository.findById(id)
                        .orElseThrow();

        product.setName(request.getName());

        product.setPrice(request.getPrice());

        product.setCatalog(
                catalogRepository.findById(
                        request.getCatalogId()
                ).orElseThrow()
        );

        product.setCategory(
                categoryRepository.findById(
                        request.getCategoryId()
                ).orElseThrow()
        );

        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {

        productRepository.deleteById(id);
    }

    @Override
    public ProductPageResponse findAll(
            int page,
            int size,
            String sort
    ) {

        Pageable pageable =
                PageRequest.of(
                        page,
                        size,
                        Sort.by(sort)
                );

        Page<Product> products =
                productRepository.findAll(pageable);

        List<ProductResponse> data =
                products.getContent()
                        .stream()
                        .map(product -> ProductResponse.builder()
                                .id(product.getId())
                                .name(product.getName())
                                .price(product.getPrice())
                                .createdAt(product.getCreatedAt())

                                .catalog(
                                        new CatalogDto(
                                                product.getCatalog().getId(),
                                                product.getCatalog().getName()
                                        )
                                )

                                .category(
                                        new CategoryDto(
                                                product.getCategory().getId(),
                                                product.getCategory().getName()
                                        )
                                )

                                .createdBy(
                                        new UserDto(
                                                (long) product.getCreatedBy().getId(),
                                                product.getCreatedBy().getUsername()
                                        )
                                )

                                .build())
                        .toList();

        PaginationResponse pagination =
                new PaginationResponse(
                        products.getNumber(),
                        products.getSize(),
                        products.getTotalPages(),
                        products.getTotalElements()
                );

        return new ProductPageResponse(
                data,
                pagination
        );
    }
}