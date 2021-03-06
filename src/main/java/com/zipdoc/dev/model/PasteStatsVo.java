package com.zipdoc.dev.model;

import lombok.Data;

import java.util.Date;

@Data
public class PasteStatsVo {
	private Long pasteStatsSeqNo;		//log 순번
	private Long pasteSeqNo; 			//paste순번
	private Date viewDt;				//날짜
	private Integer monthVl;			//월
	private Long viewDtCnt;				//조회수
}
