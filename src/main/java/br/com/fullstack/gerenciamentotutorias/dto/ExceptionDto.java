package br.com.fullstack.gerenciamentotutorias.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionDto {
    private int codigo;
    private String mensagem;
}
