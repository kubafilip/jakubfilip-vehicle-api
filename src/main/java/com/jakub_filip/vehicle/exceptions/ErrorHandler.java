package com.jakub_filip.vehicle.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

//    @ExceptionHandler(AssignmentException.class)
//    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
//    public AssignmentException handleAssignmentException(AssignmentException assignmentException) {
//        return assignmentException;
//    }
//
//    @ExceptionHandler(UpdateCarStatusException.class)
//    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
//    public UpdateCarStatusException handleUpdateCarStatusException(UpdateCarStatusException statusException) {
//        return statusException;
//    }
}
