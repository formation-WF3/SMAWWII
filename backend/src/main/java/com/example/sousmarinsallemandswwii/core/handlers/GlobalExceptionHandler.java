package com.example.sousmarinsallemandswwii.core.handlers;

import com.example.sousmarinsallemandswwii.core.exceptions.SmawwiiException;
import com.example.sousmarinsallemandswwii.core.rest.dtos.ErreurReponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.security.sasl.AuthenticationException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = SmawwiiException.class)
    public ResponseEntity<ErreurReponse> handleSmawwiiException(SmawwiiException ex) {
        return ResponseEntity
                .status(ex.getHttpStatus())
                .body(ErreurReponse.builder().message(ex.getMessage()).build());
    }

    @ExceptionHandler(value = AuthenticationException.class)
    public ResponseEntity<ErreurReponse> handleAuthenticationException(AuthenticationException ex) {
        return ResponseEntity
                .status(403)
                .body(ErreurReponse.builder().message(ex.getMessage()).build());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErreurReponse> handleException(Exception ex) {
        return ResponseEntity
                .status(500)
                .body(ErreurReponse.builder().message(ex.getMessage()).build());
    }
}
