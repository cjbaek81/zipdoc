package com.zipdoc.dev.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseVo<T> implements Serializable {

	private static final long serialVersionUID = -1173017317596728145L;

	private int code; // 코드
	private String message; // 메세지
	private T data; // 데이터

	public ResponseVo(T data) {
		this.data = data;
		this.code = RspCode.OK.getCode();
		this.message = RspCode.OK.getMessage();
	}

	public ResponseVo(RspCode respCode) {
		this.code = respCode.getCode();
		this.message = respCode.getMessage();
	}

	public ResponseVo() {
		this.code = RspCode.OK.getCode();
		this.message = RspCode.OK.getMessage();
	}
}
