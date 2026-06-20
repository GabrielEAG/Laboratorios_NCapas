package com.server.app.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ProductResponse {

    private Long id;

    private String name;

    private Double price;

    private LocalDateTime createdAt;

    private CatalogDto catalog;

    private CategoryDto category;

    private UserDto createdBy;
}