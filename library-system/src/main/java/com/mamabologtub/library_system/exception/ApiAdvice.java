package com.mamabologtub.library_system.exception;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.mamabologtub.library_system.dtos.response.BaseResponse;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author Tshepo M Mahudu on Sep 7, 2025.
 */
@Slf4j
@ControllerAdvice
public class ApiAdvice {

    @Value("${api.source}")
    private String source;

    @ResponseBody
    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<BaseResponse<ErrorResponse>> customException(CustomException exception) {
        if (exception.getCode() == -1) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(BaseResponse.<ErrorResponse>builder().code(HttpStatus.UNPROCESSABLE_ENTITY.value())
                            .message(exception.getMessage()).source(source).build());
        } else {
            return ResponseEntity.status(HttpStatus.valueOf(exception.getCode()))
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(BaseResponse.<ErrorResponse>builder().code(exception.getCode())
                            .message(exception.getMessage()).source(source).build());
        }
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseEntity<BaseResponse<ErrorResponse>> jsonParseException(Exception e) {
        log.error("JSON Parse exception: {}", e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BaseResponse.<ErrorResponse>builder().code(400)
                .message("Error reading request").source(source).build());
    }

    @ExceptionHandler(value = AttributeNotFoundException.class)
    @ResponseBody
    public ResponseEntity<BaseResponse<ErrorResponse>> notFoundException(AttributeNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(BaseResponse.<ErrorResponse>builder().code(404)
                .message("The entity requested does not exists").source(source).build());

    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    @ResponseBody
    public ResponseEntity<BaseResponse<ErrorResponse>> internalServerErrorException(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(BaseResponse.<ErrorResponse>builder().code(500)
                .message("We don't have this entity in our records").source(source).build());
    }

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    public ResponseEntity<BaseResponse<ErrorResponse>> handleInvalidTypes(MethodArgumentTypeMismatchException e, WebRequest request) {
        String message = new StringBuilder().append("Invalid data type provided for ").append(e.getName()).append(". ").append(e.getName())
                .append(" must be a number.").toString();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BaseResponse.<ErrorResponse>builder().code(400)
                .message(message).source(source).build());
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    @ResponseBody
    public ResponseEntity<BaseResponse<ErrorResponse>> handleDataViolation(DataIntegrityViolationException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(BaseResponse.<ErrorResponse>builder().code(500)
                .message("Must be unique").source(source).build());
    }
}

