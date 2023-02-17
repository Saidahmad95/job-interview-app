package com.example.jobinterview.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.jobinterview.domain.enums.ExceptionMessage;
import com.example.jobinterview.exception.domain.InterviewNotFoundException;
import com.example.jobinterview.exception.domain.InterviewTypeNotFoundException;
import com.example.jobinterview.exception.domain.LocationNotFoundException;
import com.example.jobinterview.exception.domain.TemplateNotFoundException;

@ControllerAdvice
public class ExceptionHandlerController {

        @ExceptionHandler(value = LocationNotFoundException.class)
        public ResponseEntity<ErrorMessage> locationNotFoundException(
                        LocationNotFoundException ex) {
                HttpStatus status = HttpStatus.NOT_FOUND;

                return createExResponse(
                                status.value(),
                                status.getReasonPhrase(),
                                ExceptionMessage.LOCATION_NOT_FOUND);

        }

        @ExceptionHandler(value = TemplateNotFoundException.class)
        public ResponseEntity<ErrorMessage> templateNotFoundException(
                        TemplateNotFoundException ex) {
                HttpStatus status = HttpStatus.NOT_FOUND;

                return createExResponse(
                                status.value(),
                                status.getReasonPhrase(),
                                ExceptionMessage.TEMPLATE_NOT_FOUND);

        }

        @ExceptionHandler(value = InterviewTypeNotFoundException.class)
        public ResponseEntity<ErrorMessage> interviewTypeNotFoundException(
                        InterviewTypeNotFoundException ex) {
                HttpStatus status = HttpStatus.NOT_FOUND;
                return createExResponse(
                                status.value(),
                                status.getReasonPhrase(),
                                ExceptionMessage.INTERVIEW_TYPE_NOT_FOUND);
        }

        @ExceptionHandler(value = InterviewNotFoundException.class)
        public ResponseEntity<ErrorMessage> interviewNotFoundException(
                        InterviewNotFoundException ex) {
                HttpStatus status = HttpStatus.NOT_FOUND;
                return createExResponse(
                                status.value(),
                                status.getReasonPhrase(),
                                ExceptionMessage.INTERVIEW_NOT_FOUND);
        }


        
        public ResponseEntity<ErrorMessage> createExResponse(
                        int statusCode, String message, String description) {
                ErrorMessage errorMessage = new ErrorMessage(
                                statusCode,
                                new Date(),
                                message,
                                description);

                return ResponseEntity.status(statusCode).body(errorMessage);

        }
}
