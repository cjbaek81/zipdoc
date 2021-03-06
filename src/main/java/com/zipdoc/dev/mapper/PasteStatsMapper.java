package com.zipdoc.dev.mapper;

import com.zipdoc.dev.model.PasteStatsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PasteStatsMapper {

	int insertPasteStats() throws Exception;

	List<PasteStatsVo> selectMonthPasteStatsList() throws Exception;
}
