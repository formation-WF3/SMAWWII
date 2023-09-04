package com.example.ww2germansubmarines.core.handlers;

import com.example.ww2germansubmarines.core.exceptions.Ww2gsException;
import com.example.ww2germansubmarines.core.rest.dtos.ErreurReponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Ww2gsException.class)
    public ResponseEntity<ErreurReponse> handleWw2gsException(Ww2gsException ex) {
        logger.error(ex.getMessage());
        return ResponseEntity
                .status(ex.getHttpStatus())
                .body(ErreurReponse.builder().message(ex.getMessage()).build());
    }

//    @ExceptionHandler(value = BadCredentialsException.class)
//    public ResponseEntity<ErreurReponse> handleBadCredentialsException(BadCredentialsException ex) {
//        logger.error(ex.getMessage());
//        throw new Ww2gsException(RaisonEnum.IDENTIFICATION_INCORRECTE, HttpStatus.FORBIDDEN);
//    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<ErreurReponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity
                .status(401)
                .body(ErreurReponse.builder().message(ex.getMessage()).build());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErreurReponse> handleException(Exception ex) {
        logger.error(ex.getMessage());
        return ResponseEntity
                .status(200)
                .body(ErreurReponse.builder().message(ex.getMessage()).build());
    }
}
