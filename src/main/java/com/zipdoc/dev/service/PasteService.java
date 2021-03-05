package com.zipdoc.dev.service;

import com.zipdoc.dev.mapper.PasteMapper;
import com.zipdoc.dev.model.PasteVo;
import com.zipdoc.dev.model.common.RequestVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PasteService {

	@Resource
	PasteMapper pasteMapper;

	public String insertPaste(RequestVo requestVo) throws Exception {

		String strUrl;
		//todo 만료일자 계산
		//todo URL 난수 생성
		strUrl = "12345";
		int result = pasteMapper.insertPaste(requestVo);
		if(result > 0){
			return strUrl;
		}else{
			return null;
		}
	}

	public PasteVo selectPaste(String pasteUrl) throws Exception {
		//todo 만료인지 체크
		//todo 조회수 업데이트 혹은 로그관리

		return pasteMapper.selectPaste(pasteUrl);
	}

	public int deletePaste(Long pasteSeqNo) throws Exception {
		return pasteMapper.deletePaste(pasteSeqNo);
	}

}
