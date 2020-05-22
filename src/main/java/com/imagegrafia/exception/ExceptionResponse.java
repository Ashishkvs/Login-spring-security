package com.imagegrafia.exception;

import java.util.Date;

import lombok.Getter;

public class ExceptionResponse {
	@Getter
	private String error;
	@Getter
	private String message;
	@Getter
	private Date timestamp;
	
	public ExceptionResponse(Date timestamp, String message, String error) {
		super();
		this.error = error;
		this.message = message;
		this.timestamp = timestamp;
	}
	
	
}
