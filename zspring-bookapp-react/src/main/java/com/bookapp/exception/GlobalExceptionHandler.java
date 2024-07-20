package com.bookapp.exception;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bookapp.model.ApiErrors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// add info to existing headers object
	    headers.add("info","method not allowed");
		String error = ex.getMessage();
		int statusCode =status.value();
		List<String> messages = Arrays.asList(error,"method not supported");
		ApiErrors errors= new  ApiErrors(LocalDateTime.now(),error,statusCode,messages,status);
		return ResponseEntity.status(status).body(errors);
	}
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		    headers.add("info","Media type not supported");
			String error = ex.getMessage();
			int statusCode =status.value();
			List<String> messages = Arrays.asList(error,"Media type not supported");
			ApiErrors errors= new  ApiErrors(LocalDateTime.now(),error,statusCode,messages,status);
			return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		    headers.add("info","Missing Path varable");
			String error = ex.getMessage();
			int statusCode =status.value();
			List<String> messages = Arrays.asList(error,"Missing Path varable");
			ApiErrors errors= new  ApiErrors(LocalDateTime.now(),error,statusCode,messages,status);
			return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		    headers.add("info","Missing Servlet Request Parameter");
			String error = ex.getMessage();
			int statusCode =status.value();
			List<String> messages = Arrays.asList(error,"Missing Servlet Request Parameter");
			ApiErrors errors= new  ApiErrors(LocalDateTime.now(),error,statusCode,messages,status);
			return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		    headers.add("info","Type Mismatch");
			String error = ex.getMessage();
			int statusCode =status.value();
			List<String> messages = Arrays.asList(error,"Type Mismatch");
			ApiErrors errors= new  ApiErrors(LocalDateTime.now(),error,statusCode,messages,status);
			return ResponseEntity.status(status).body(errors);
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	protected ResponseEntity<Object> handleBookNotFound(BookNotFoundException ex){
		HttpHeaders headers = new HttpHeaders();
		headers.add("info","Book not found");
		String error = ex.getMessage();
		int statusCode = HttpStatus.FAILED_DEPENDENCY.value();
		HttpStatusCode status =  HttpStatusCode.valueOf(statusCode);
		List<String> messages = Arrays.asList(error,"Book not found");
		ApiErrors errors= new  ApiErrors(LocalDateTime.now(),error,statusCode,messages,status);
		return ResponseEntity.status(status).body(errors);
		
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	protected ResponseEntity<Object> handleBookNotFound(IdNotFoundException ex){
		HttpHeaders headers = new HttpHeaders();
		headers.add("info","Id not found");
		String error = ex.getMessage();
		int statusCode = HttpStatus.CONFLICT.value();
		HttpStatusCode status =  HttpStatusCode.valueOf(statusCode);
		List<String> messages = Arrays.asList(error,"Id not found");
		ApiErrors errors= new  ApiErrors(LocalDateTime.now(),error,statusCode,messages,status);
		return ResponseEntity.status(status).body(errors);
		
	}


}
