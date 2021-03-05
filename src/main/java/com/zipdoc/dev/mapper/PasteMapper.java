package com.zipdoc.dev.mapper;


import com.zipdoc.dev.model.PasteVo;
import com.zipdoc.dev.model.common.RequestVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PasteMapper {

	int insertPaste(RequestVo requestVo) throws Exception;

	PasteVo selectPaste(String pasteUrl) throws Exception;

	int deletePaste(Long pasteSeqNo) throws Exception;

}
