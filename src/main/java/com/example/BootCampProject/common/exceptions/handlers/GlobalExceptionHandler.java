package com.example.BootCampProject.common.exceptions.handlers;

import com.example.BootCampProject.common.exceptions.details.BusinessProblemDetails;
import com.example.BootCampProject.common.exceptions.details.InternalServerProblemDetails;
import com.example.BootCampProject.common.exceptions.types.BusinessException;
import com.example.BootCampProject.common.exceptions.types.InternalServerException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(HttpServletRequest request, Exception ex) {
        // Swagger'dan gelen isteği kontrol et
        String path = request.getRequestURI();
        if (path.startsWith("/v3/api-docs") || path.startsWith("/swagger")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        // Normal hata cevabı
        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleBusinessException(BusinessException businessException){
        BusinessProblemDetails details = new BusinessProblemDetails();
        details.setDetail(businessException.getMessage());
        return details;
    }


    @ExceptionHandler({InternalServerException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public InternalServerProblemDetails handleInternalServerException(InternalServerException internalServerException){
        InternalServerProblemDetails details = new InternalServerProblemDetails();
        details.setDetail(internalServerException.getMessage());
        return details;
    }
}
