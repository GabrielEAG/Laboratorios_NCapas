package com.server.app.dto.request;

import lombok.Data;

@Data
public class ProductRequest {

    private String name;

    private Double price;

    private Long catalogId;

    private Long categoryId;
}