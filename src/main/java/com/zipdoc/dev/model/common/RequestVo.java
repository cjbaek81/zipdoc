package com.zipdoc.dev.model.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RequestVo<T> implements Serializable {
	private static final long serialVersionUID = 6668599048573824197L;
	private T data; // 데이터
}
