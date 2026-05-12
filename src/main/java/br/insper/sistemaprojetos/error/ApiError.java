package br.insper.sistemaprojetos.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ApiError {
    private String mensagem;
    private Integer status;
    private LocalDateTime timestamp;

}
