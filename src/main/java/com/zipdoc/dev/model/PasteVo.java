package com.zipdoc.dev.model;

import lombok.Data;

import java.util.Date;

@Data
public class PasteVo {

	private Long pasteSeqNo; 			//순번
	private String pasteText;			//글내용
	private String  pasteExpiration;	//만료코드
	private Date expireDt;				//만료일시
	private String pasteNameTitle;		//이름 및 제목
	private String pasteUrl;			//url
	private String delYn;				//삭제 여부
	private Long viewCnt;				//조회수
	private Date regDt; 				// 등록일시
	private Date edtDt; 				// 수정일시
}
