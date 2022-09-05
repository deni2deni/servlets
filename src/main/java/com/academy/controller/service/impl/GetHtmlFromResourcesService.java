package com.academy.controller.service.impl;

import com.academy.controller.service.interfaces.GetHtmlService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class GetHtmlFromResourcesService implements GetHtmlService {
    @Override
    public void getHtml(HttpServletRequest req, HttpServletResponse resp, String path) throws IOException {
        PrintWriter writer;

            writer = resp.getWriter();
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(path);
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            for (int length; (length = inputStream.read(buffer)) != -1; ) {
                result.write(buffer, 0, length);
            }
            String html = result.toString("UTF-8");

            writer.println(html);
    }
}
