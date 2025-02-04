package com.wafa.ms_order.common.exception.handler;

import com.wafa.ms_order.common.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<ProblemDetail> handleException(NotFoundException exp) {
        var problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exp.getMessage());
        return ResponseEntity.of(problem).build();
    }
}
