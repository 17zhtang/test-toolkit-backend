package com.hltn.test.controller;

import com.hltn.test.dto.req.GetQRCodeReqDto;
import com.hltn.test.service.QRCodeService;
import com.hltn.test.utils.Result;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@Slf4j
@RestController
@RequestMapping("QRCode")
public class QRCodeController {

    @Autowired
    QRCodeService qrCodeService;
    @PostMapping ("getQRCode")
    public Result generateQRCode(@RequestBody GetQRCodeReqDto dto, HttpServletResponse servletResponse) throws IOException {
        log.info("generateQRCode,dto:{}",dto);
        qrCodeService.generateStream(dto.getContent(),servletResponse);
        return Result.ok(null);
    }

}
