package com.zipdoc.dev.model;

import lombok.Data;

import java.util.Date;

@Data
public class PasteLogVo {
	private Long pasteLogSeqNo;			//log 순번
	private Long pasteSeqNo; 			//paste순번
	private String visitIp;			//접속자 Ip
	private Date visitTime;			//접속 일시
}
