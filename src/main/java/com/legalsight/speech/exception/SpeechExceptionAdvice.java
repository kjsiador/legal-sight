package com.legalsight.speech.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.legalsight.speech.controller.SpeechController;
import com.legalsight.speech.dto.ConstraintErrorDto;
import com.legalsight.speech.dto.ErrorDto;

import lombok.extern.slf4j.Slf4j;

/**
 * @author kristian.j.s.siador
 */

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice(assignableTypes = SpeechController.class)
@Slf4j
public class SpeechExceptionAdvice {
	
	private final String LOG_TEMPLATE = "{}::{}() - {}";
	
	@ExceptionHandler(SpeechException.class)
	    public ResponseEntity<ErrorDto> handleFlightsException(SpeechException ex) {

	        final ErrorDto error = ErrorDto.builder().errorId(ex.getErrId()).errorMessage(ex.getErrMessage()).build();

	        log.error(LOG_TEMPLATE,
	                getClass().getSimpleName(),
	                Thread.currentThread().getStackTrace()[1].getMethodName(),
	                ex.getMessage());

	        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	    }
	
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ConstraintErrorDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ConstraintErrorDto error = new ConstraintErrorDto();

        if (ex.getBindingResult().hasErrors()) {
        	List<String> errors = new ArrayList<>();
            for (final FieldError field : ex.getBindingResult().getFieldErrors()) {
            	errors.add(field.getDefaultMessage());
                
            }
            
            error = ConstraintErrorDto.builder().errorId("400").errorMessage(errors).build();
        }

        log.error(LOG_TEMPLATE,
                getClass().getSimpleName(),
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                ex.getMessage());

        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
