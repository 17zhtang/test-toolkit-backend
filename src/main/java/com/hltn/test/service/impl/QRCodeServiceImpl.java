package com.hltn.test.service.impl;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.hltn.test.service.QRCodeService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class QRCodeServiceImpl implements QRCodeService {
    @Resource
    QrConfig qrconig;
    //输出文件
    public void generateFile(String content, File file){

        QrCodeUtil.generate(content, qrconig, file);
    }
    //输出到流
    public void generateStream(String content, HttpServletResponse response) throws IOException {
        QrCodeUtil.generate(content,qrconig,"png",response.getOutputStream());
    }

}
