package com.blog.myresponse;

public class MyResponse {
	public static String SUCCESS = "success";
	public static String ERROR = "error";
	private String status;

	private String errortype;
	private String msg;
	private Object data;
	
	public MyResponse() {
		super();
		if(data == null)
			data = "";
		this.status = SUCCESS;
		this.msg="";
		this.errortype = "";
	}
	public MyResponse(Object data) {
		this();
		this.data = data;
		
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getErrortype() {
		return errortype;
	}
	public void setErrortype(String errortype) {
		this.errortype = errortype;
	}
	

	
}
