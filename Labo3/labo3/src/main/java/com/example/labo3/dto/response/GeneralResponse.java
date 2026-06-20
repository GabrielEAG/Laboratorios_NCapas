package com.example.labo3.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Estructura generica que envuelve TODAS las respuestas exitosas de la API.
 * Incluye metadata obligatoria: mensaje, status HTTP, timestamp y la URI consultada.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneralResponse<T> {
    private String message;
    private int status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    private String path;
    private T data;
}
