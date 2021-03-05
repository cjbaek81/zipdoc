package com.zipdoc.dev.service;

import com.zipdoc.dev.controller.HomeController;
import com.zipdoc.dev.mapper.PasteMapper;
import com.zipdoc.dev.model.PasteVo;
import com.zipdoc.dev.model.common.RequestVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class PasteService {

	@Resource
	PasteMapper pasteMapper;

	private final Logger LOGGER = LoggerFactory.getLogger(PasteService.class);

	public String insertPaste(RequestVo<PasteVo> requestVo) throws Exception {

		String pasteUrl;
		//pasteURL UUID 생성
		pasteUrl = UUID.randomUUID().toString();
		LOGGER.info("UUID Value : " + pasteUrl);

		requestVo.getData().setPasteUrl(pasteUrl);

		int result = pasteMapper.insertPaste(requestVo);
		if(result > 0){
			return pasteUrl;
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
