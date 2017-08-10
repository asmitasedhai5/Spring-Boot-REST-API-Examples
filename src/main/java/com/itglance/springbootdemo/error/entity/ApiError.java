package com.itglance.springbootdemo.error.entity;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiError {
	private HttpStatus status;
    private String message;
    private String developerMessage;
    private List<String> errors;
 
    public ApiError(HttpStatus status, String message, String developerMessage, List<String> errors) {
        super();
        this.setStatus(status);
        this.setMessage(message);
        this.setDeveloperMessage(developerMessage);
        this.setErrors(errors);
    }
 
    public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

	public ApiError(HttpStatus status, String message, String error) {
        super();
        this.setStatus(status);
        this.setMessage(message);
        setErrors(Arrays.asList(error));
    }

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
