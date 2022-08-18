package com.okestro.aiops.common;

public class ResultVO {

	private Object data;
	private String message;

	public ResultVO() {
		// TODO Auto-generated constructor stub
	}
	
	public ResultVO(Object data, String message) {
		super();
		this.data = data;
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
