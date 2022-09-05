package com.academy.controller.service.interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface GetHtmlService {
    void getHtml(HttpServletRequest req, HttpServletResponse resp, String path) throws IOException;
}
