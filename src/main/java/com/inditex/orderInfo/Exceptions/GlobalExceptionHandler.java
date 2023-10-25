package com.inditex.orderInfo.Exceptions;

import com.inditex.orderInfo.repository.ItemRepositoryCustom;
import com.inditex.orderInfo.service.OrderInfoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.nio.file.AccessDeniedException;

@ControllerAdvice(assignableTypes ={ItemRepositoryCustom.class, OrderInfoService.class})
public class GlobalExceptionHandler {

    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<Object> handleAccessDeniedException(
            Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                "Access denied", new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
}
