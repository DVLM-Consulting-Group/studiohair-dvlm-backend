package br.com.dvlm.studiohair.controllers.excecoes;

import br.com.dvlm.studiohair.services.excecoes.DataIntegratyViolationException;
import br.com.dvlm.studiohair.services.excecoes.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e){
        StandardError error = new StandardError(System.currentTimeMillis(),
                HttpStatus.NOT_FOUND.value(), e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegratyViolationException.class)
    public ResponseEntity<StandardError> objectNotFoundException(DataIntegratyViolationException e){
        StandardError error = new StandardError(System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(), e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> objectNotFoundException(MethodArgumentNotValidException e){
        ValidationError error = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro na validação dos campos");

        for(FieldError x : e.getBindingResult().getFieldErrors()){
            error.addErro(x.getField(), x.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
