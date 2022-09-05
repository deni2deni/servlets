package com.academy.controller.servlet;

import com.academy.model.entity.User;
import com.academy.controller.service.impl.GetHtmlFromResourcesService;
import com.academy.controller.service.impl.JSONMapperServiceImpl;
import com.academy.controller.service.impl.LogPassSplitterServiceImpl;
import com.academy.controller.service.impl.RegistrationServiceImpl;
import com.academy.controller.service.interfaces.GetHtmlService;
import com.academy.controller.service.interfaces.JSONMapperService;
import com.academy.controller.service.interfaces.LogPassSplitterService;
import com.academy.controller.service.interfaces.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

public class RegisterServlet extends HttpServlet {
    private final GetHtmlService getHtmlService;
    private final RegistrationService registrationService;
    private final JSONMapperService jsonMapperService;
    private final LogPassSplitterService logPassSplitterService;

    public RegisterServlet() {
        getHtmlService = new GetHtmlFromResourcesService();
        registrationService = new RegistrationServiceImpl();
        jsonMapperService = new JSONMapperServiceImpl();
        logPassSplitterService = new LogPassSplitterServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getHtmlService.getHtml(req, resp, "html/registration_page.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = logPassSplitterService.splitLogPass(req);

        Map<String, String> userData = jsonMapperService.getLoginPasswordMap();

        registrationService.register(resp, userData, user);

    }
}
