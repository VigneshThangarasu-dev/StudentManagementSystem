package com.StudentManagement.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorMessage> studentNotFoundHandled(StudentNotFoundException exception){
        ErrorMessage errorMessage=new ErrorMessage(
                "STU_404",exception.getMessage(),"Student is not found"
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<ErrorMessage> handleDuplicateEmail(DuplicateEmailException exception){
        ErrorMessage errorMessage=new ErrorMessage("STU_409", exception.getMessage(), "Use a different email address.");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleGenericException(Exception exception) {

        ErrorMessage errorMessage = new ErrorMessage("INTERNAL_SERVER_ERROR", "An unexpected error occurred.", "Please try again later or contact support if the issue persists."
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }
}
