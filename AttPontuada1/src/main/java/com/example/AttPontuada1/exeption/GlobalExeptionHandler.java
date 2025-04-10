package com.example.AttPontuada1.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Map;

@RestControllerAdvice
public class GlobalExeptionHandler {

    // Vai retornar uma mensagem enquanto está rodando o servidor.
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handlerRunTimerException(RuntimeException erro) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("mensagem", erro.getMessage()));
    }

    // uma mensagem para não válidos.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> MethodArgumentNotValidException(MethodArgumentNotValidException erro) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("mensagem", erro.getFieldErrors().get(0).getDefaultMessage()));
    }

    // para evitar ataques de caminhos.
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException erro) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("mensagem","Recurso não encontrado."));
    }

    // não sei muito bem o que faz mas é quando não encontra um certo recurso.

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Map<String, Object>> handlerNoResourceFoundException(NoResourceFoundException erro) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("mensagem", "Recurso não encontrado."));
    }

    // como na mensagem ali diz aqui vai impedir do usuario mandar informações em branco ou com espaços inuteis.

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> handlerHttpMessageNotReadableException(HttpMessageNotReadableException erro) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("mensagem", "Corpo da requisição ausente ou mal formatado."));
    }
}
