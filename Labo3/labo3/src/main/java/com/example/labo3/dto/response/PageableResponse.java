package com.example.labo3.dto.response;

import lombok.*;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Estructura generica para envolver cualquier respuesta paginada.
 * Convierte un Page<T> de Spring Data en un formato limpio para el cliente.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageableResponse<T> {
    private List<T> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean isLast;

    public static <T> PageableResponse<T> fromPage(Page<T> page) {
        return PageableResponse.<T>builder()
                .content(page.getContent())
                .pageNumber(page.getNumber())
                .pageSize(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .isLast(page.isLast())
                .build();
    }
}
