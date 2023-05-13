package ar.unrn.domain.model;

import java.util.List;

public class MyResponse {
	private String status;
	private String message;
	private List<String> data;

	public MyResponse(String status, String message, List<String> data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public List<String> getData() {
		return data;
	}
}
