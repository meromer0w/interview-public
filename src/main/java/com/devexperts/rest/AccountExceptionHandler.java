package com.devexperts.rest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice(assignableTypes = AccountController.class)
public class AccountExceptionHandler {

    @ResponseBody
    @ExceptionHandler({NullPointerException.class})
    public void handleNotFoundException(NullPointerException e, HttpServletResponse response) throws IOException {
        response.sendError(NOT_FOUND.value(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler({IllegalArgumentException.class})
    public void handleBadRequestException(Exception e, HttpServletResponse response) throws IOException {
        response.sendError(BAD_REQUEST.value(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler({Exception.class})
    public void handleInternalServerErrorException(Exception e, HttpServletResponse response) throws IOException {
        response.sendError(INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }
}
