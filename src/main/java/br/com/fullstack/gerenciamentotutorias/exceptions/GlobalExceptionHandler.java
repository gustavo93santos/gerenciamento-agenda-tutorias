package br.com.fullstack.gerenciamentotutorias.exceptions;

import br.com.fullstack.gerenciamentotutorias.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFountException.class)
    public ResponseEntity<ExceptionDto> handler(NotFountException e) {
        ExceptionDto exception = ExceptionDto.builder()
                .codigo(HttpStatus.NOT_FOUND.value())
                .mensagem(e.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(exception);
    }

}
