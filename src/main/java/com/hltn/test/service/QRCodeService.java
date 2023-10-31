package com.hltn.test.service;

import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;

public interface QRCodeService {
    public void generateFile(String content, File file);
    public void generateStream(String content, HttpServletResponse response) throws IOException;
}
