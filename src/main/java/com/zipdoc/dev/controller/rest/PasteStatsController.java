package com.zipdoc.dev.controller.rest;

import com.zipdoc.dev.model.PasteStatsVo;
import com.zipdoc.dev.model.PasteVo;
import com.zipdoc.dev.model.common.ResponseVo;
import com.zipdoc.dev.model.common.RspCode;
import com.zipdoc.dev.service.PasteService;
import com.zipdoc.dev.service.PasteStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * paste별 통계  controller
 * @author 백찬주
 * @date 2021.03.06
 */
@RestController
@RequestMapping("/api/pasteStats")
public class PasteStatsController {

    @Autowired
    private PasteStatsService pasteStatsService;

    /**
     * paste별 월간 통계 목록
     * @return
     * @throws Exception
     */

    @GetMapping("/month")
    public ResponseEntity<ResponseVo<List<PasteStatsVo>>> retrieveMonthStatList()
            throws Exception {

        ResponseVo<List<PasteStatsVo>> resp = new ResponseVo<List<PasteStatsVo>>();

        List<PasteStatsVo> statsList = pasteStatsService.selectMonthPasteStatsList();

        if (statsList == null || statsList.isEmpty()) {
            return ResponseEntity.ok(new ResponseVo(RspCode.NOT_FOUND_INFO));
        }
        resp.setData(statsList);

        return ResponseEntity.ok(resp);
    }
}

