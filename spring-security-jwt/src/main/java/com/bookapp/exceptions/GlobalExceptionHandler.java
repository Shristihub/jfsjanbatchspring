package com.bookapp.exceptions;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bookapp.controllers.BookController;
import com.bookapp.model.ApiErrors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		String error = "Request Method not supported";
		ApiErrors errors = new ApiErrors(LocalDateTime.now(),message, status,status.value(),error);
		headers.add("info",message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		String error = "Media type not supported";
		ApiErrors errors = new ApiErrors(LocalDateTime.now(),message, status,status.value(),error);
		headers.add("info",message);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		String error = "Missing path variable";
		ApiErrors errors = new ApiErrors(LocalDateTime.now(),message, status,status.value(),error);
		headers.add("info",message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		String error = "Missing request parameter";
		ApiErrors errors = new ApiErrors(LocalDateTime.now(),message, status,status.value(),error);
		headers.add("info",message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		String error = "Type mismatch";
		ApiErrors errors = new ApiErrors(LocalDateTime.now(),message, status,status.value(),error);
		headers.add("info",message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

//	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<Object> handleBookNotFound(BookNotFoundException ex){
		String message = ex.getMessage();
		String error = "Book Not Found Exception";
		ApiErrors errors = new ApiErrors(LocalDateTime.now(),message,HttpStatus.CONFLICT,HttpStatus.CONFLICT.value(),error);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info",message);
		return ResponseEntity.status(HttpStatus.CONFLICT).headers(headers).body(errors);
		
	}
//	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object> handleIdNotFound(IdNotFoundException ex){
		logger.error(ex.getMessage());
		logger.error("invalid Id");
		String message = ex.getMessage();
		String error = "Id Not Found Exception";
		ApiErrors errors = new ApiErrors(LocalDateTime.now(),message,HttpStatus.GONE,HttpStatus.GONE.value(),error);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info",message);
		return ResponseEntity.status(HttpStatus.GONE).headers(headers).body(errors);
		
	}
}
