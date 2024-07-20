package com.bookapp.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatusCode;

public class ApiErrors {

	LocalDateTime timestamp;
	String error;
	int status;
	List<String> messages;
	HttpStatusCode code;
	
	public ApiErrors(LocalDateTime timestamp, String error, int status, List<String> messages, HttpStatusCode code) {
		super();
		this.timestamp = timestamp;
		this.error = error;
		this.status = status;
		this.messages = messages;
		this.code = code;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public HttpStatusCode getCode() {
		return code;
	}

	public void setCode(HttpStatusCode code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "ApiErrors [timestamp=" + timestamp + ", error=" + error + ", status=" + status + ", messages="
				+ messages + ", code=" + code + "]";
	}
	
	
}
