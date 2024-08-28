package com.weave.pokemon.exception;

import com.weave.pokemon.dto.ErrorResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class PokemonAppExceptionHandler {

    @ExceptionHandler(value = {PokemonAppException.class})
    protected ResponseEntity<ErrorResponseDTO> handleAppException(PokemonAppException ex) {
        log.error("Exception occured ", ex);
        ErrorResponseDTO error = ErrorResponseDTO.builder().erroCode(ex.getErrorCode())
                .errorMessage(ex.getMessage())
                .httpStatus(ex.getHttpStatus()).build();
        return new ResponseEntity<ErrorResponseDTO>(error, ex.getHttpStatus());
    }

    @ExceptionHandler(value = {Throwable.class})
    protected ResponseEntity<ErrorResponseDTO> handleRuntimeAppException(Throwable ex) {
        log.error("Runtime Exception occured ", ex);
        ErrorResponseDTO error = ErrorResponseDTO.builder().erroCode(9999)
                .errorMessage("generic Exception")
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return new ResponseEntity<ErrorResponseDTO>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}