package com.zipdoc.dev.service;

import com.zipdoc.dev.controller.HomeController;
import com.zipdoc.dev.mapper.PasteMapper;
import com.zipdoc.dev.model.PasteLogVo;
import com.zipdoc.dev.model.PasteVo;
import com.zipdoc.dev.model.common.RequestVo;
import com.zipdoc.dev.util.IpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Service
public class PasteService {

	@Resource
	PasteMapper pasteMapper;

	private final Logger LOGGER = LoggerFactory.getLogger(PasteService.class);

	public String insertPaste(PasteVo requestVo) throws Exception {

		String pasteUrl;
		//pasteURL UUID 생성
		pasteUrl = UUID.randomUUID().toString();
		LOGGER.info("UUID Value : " + pasteUrl);

		requestVo.setPasteUrl(pasteUrl);

		int result = pasteMapper.insertPaste(requestVo);
		if(result > 0){
			return pasteUrl;
		}else{
			return null;
		}
	}

	@Cacheable(cacheNames = "selectPasteCache",key = "#pasteUrl")
	public PasteVo selectPaste(String pasteUrl) throws Exception {

		//만료여부 체크
		PasteVo result = pasteMapper.selectPaste(pasteUrl);
		if(result != null){
			return result;
		}else{
			return null;
		}
	}
	@Transactional
	public Integer updatePasteCount(Long pasteSeqNo, HttpServletRequest request) throws Exception {

		//조회수 업데이트
		pasteMapper.updatePasteViewCnt(pasteSeqNo);
		//paste 일자별 접속 로그 등록
		PasteLogVo param = new PasteLogVo();

		param.setPasteSeqNo(pasteSeqNo);
		param.setVisitIp(IpUtil.getClientIP(request));
		pasteMapper.insertPasteLog(param);
		//조회수 가져오기
		Integer result = pasteMapper.selectPasteCount(pasteSeqNo);

		return result;
	}

	public int deletePaste(Long pasteSeqNo) throws Exception {
		return pasteMapper.deletePaste(pasteSeqNo);
	}

}
