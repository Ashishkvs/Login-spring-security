package com.imagegrafia.exception;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@ToString
public class CustomizedGlobalException extends ResponseEntityExceptionHandler {

	private static final String EXCEPTION_RESPONSE_FORMAT = "Exception_response= {}";

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception exception, WebRequest request) {
		log.error(exception.getMessage(), exception);

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), exception.getMessage(),
				request.getDescription(false));

		log.info(EXCEPTION_RESPONSE_FORMAT, exceptionResponse);
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> handleNotFoundException(NotFoundException exception, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), exception.getMessage(),
				request.getDescription(false));

		log.info(EXCEPTION_RESPONSE_FORMAT, exceptionResponse);
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AlreadyExistException.class)
	public ResponseEntity<Object> handleAlreadyExistException(AlreadyExistException exception, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), exception.getMessage(),
				request.getDescription(false));

		log.warn(EXCEPTION_RESPONSE_FORMAT, exceptionResponse.getMessage());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<Object> handleInvalidDataException(InvalidDataException exception, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), exception.getMessage(),
				request.getDescription(false));

		log.warn(EXCEPTION_RESPONSE_FORMAT, exceptionResponse.getMessage());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> handleArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception,
			WebRequest request) {
		String error=exception.getName() + " should be of type " + exception.getRequiredType().getName();
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), error,
				request.getDescription(false));

		log.info(EXCEPTION_RESPONSE_FORMAT, exceptionResponse);
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.error(ex.getMessage(), ex);
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("status", status.value());

		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
				.collect(Collectors.toList());
		body.put("fieldValidationErrors", errors);
		log.info(EXCEPTION_RESPONSE_FORMAT, body);
		return new ResponseEntity<Object>(body, HttpStatus.BAD_REQUEST);
	}

}
