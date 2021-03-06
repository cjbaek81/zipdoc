package com.zipdoc.dev.service;

import com.zipdoc.dev.mapper.PasteStatsMapper;
import com.zipdoc.dev.model.PasteStatsVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PasteStatsService {

	@Resource
	PasteStatsMapper pasteStatsMapper;

	private final Logger LOGGER = LoggerFactory.getLogger(PasteStatsService.class);

	public int insertPasteStats() throws Exception {
		return pasteStatsMapper.insertPasteStats();
	}

	public List<PasteStatsVo> selectMonthPasteStatsList() throws Exception {
		return pasteStatsMapper.selectMonthPasteStatsList();
	}

}
