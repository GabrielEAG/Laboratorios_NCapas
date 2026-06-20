package com.server.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProductPageResponse {

    private List<ProductResponse> data;

    private PaginationResponse pagination;
}