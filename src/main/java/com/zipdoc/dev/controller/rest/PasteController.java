package com.zipdoc.dev.controller.rest;

import com.zipdoc.dev.model.PasteVo;
import com.zipdoc.dev.model.common.RequestVo;
import com.zipdoc.dev.model.common.ResponseVo;
import com.zipdoc.dev.model.common.RspCode;
import com.zipdoc.dev.service.PasteService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * paste 등록 및 조회, 삭제를 위한 controller
 * @author 백찬주
 * @date 2021.03.05
 */
@RestController
@RequestMapping("/api/paste")
public class PasteController {

    @Autowired
    private PasteService pasteService;

    /**
     * paste 등록
     *
     * @param requestVo
     * @return
     * @throws Exception
     */
    @PostMapping("/register")
    public ResponseEntity<ResponseVo<String>> registerPaste(@RequestBody PasteVo requestVo) throws Exception {
        ResponseVo<String> resp = new ResponseVo<String>();

        String pasteUrl = pasteService.insertPaste(requestVo);
        if (pasteUrl == null) {
            return ResponseEntity.ok(new ResponseVo(RspCode.INTERNAL_SERVER));
        }
        resp.setData(pasteUrl);

        return ResponseEntity.ok(resp);
    }

    /**
     * paste 조회
     *
     * @param pasteUrl
     * @return
     * @throws Exception
     */

    @GetMapping("/{pasteUrl}")
    public ResponseEntity<ResponseVo<PasteVo>> retrievePaste(HttpServletRequest request, @PathVariable("pasteUrl") String pasteUrl)
            throws Exception {

        ResponseVo<PasteVo> resp = new ResponseVo<PasteVo>();

        PasteVo result = pasteService.selectPaste(pasteUrl);

        if (result == null) {
            return ResponseEntity.ok(new ResponseVo(RspCode.NOT_FOUND_INFO));
        }
        resp.setData(result);

        return ResponseEntity.ok(resp);
    }

    /**
     * paste 뷰카운트 업데이트 및 뷰카운트 조회
     *
     * @param pasteSeqNo
     * @return
     * @throws Exception
     */
    @GetMapping("update/{pasteSeqNo}")
    public ResponseEntity<ResponseVo<Integer>> modifyPasteCount(HttpServletRequest request, @PathVariable("pasteSeqNo") Long pasteSeqNo)
            throws Exception {

        ResponseVo<Integer> resp = new ResponseVo<Integer>();

        Integer result = pasteService.updatePasteCount(pasteSeqNo, request);

        if (result == null) {
            return ResponseEntity.ok(new ResponseVo(RspCode.INTERNAL_SERVER));
        }
        resp.setData(result);

        return ResponseEntity.ok(resp);
    }

    /**
     * paste 삭제
     *
     * @param pasteSeqNo
     * @return
     * @throws Exception
     */

    @PutMapping("/delete/{pasteSeqNo}")
    public ResponseEntity<ResponseVo<Void>> deletePaste(HttpServletRequest request, @PathVariable("pasteSeqNo") Long pasteSeqNo)
            throws Exception {

        ResponseVo<Void> resp = new ResponseVo<Void>();

        int result = pasteService.deletePaste(pasteSeqNo);

        if (result != 1) {
            return ResponseEntity.ok(new ResponseVo(RspCode.NOT_FOUND));
        }
        return new ResponseEntity<ResponseVo<Void>>(resp, HttpStatus.OK);
    }
}

