package com.server.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaginationResponse {

    private int page;

    private int pageSize;

    private int pageCount;

    private long total;
}