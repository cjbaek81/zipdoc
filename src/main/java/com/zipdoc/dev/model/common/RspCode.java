package com.zipdoc.dev.model.common;

public enum RspCode {
	// HTTP Status
	OK(200, "Success"), // 성공
	NOT_FOUND(300, "Requested data not found."), // 데이터 없음
	NOT_FOUND_INFO(404, "This page is no longer available. It has either expired, been removed by its creator, or removed by one of the Pastebin staff."), // 일치하는 정보가 없습니다
	BAD_REQUEST(400, "Invalid request parameters supplied."), // 잘못된 파라미터
	BAD_REQUEST_HEADER(400, "Invalid request headers supplied."), // 잘못된 해더
	UNAUTHORIZED(401, "Authentication is required and has failed."), // 인증 실패
	FORBIDDEN(403, "Not have the necessary permissions for a resource."), // 접근 권한 없음
	INTERNAL_SERVER(500, "Internal server error."); // 서버 내부 오류


	private int code;
	private String message;

	RspCode(int code, String message) {
		this.code = code;
		this.message = message;
	}


	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
