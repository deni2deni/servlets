package com.academy.controller.servlet;

import com.academy.model.entity.User;
import com.academy.controller.service.impl.GetHtmlFromResourcesService;
import com.academy.controller.service.impl.LogPassSplitterServiceImpl;
import com.academy.controller.service.impl.LoginValidatorService;
import com.academy.controller.service.interfaces.GetHtmlService;
import com.academy.controller.service.interfaces.LogPassSplitterService;
import com.academy.controller.service.interfaces.ValidatorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

public class LoginServlet extends HttpServlet {

    private final ValidatorService validatorService;
    private final GetHtmlService getHtmlService;
    private final LogPassSplitterService logPassSplitterService;

    public LoginServlet() {
        validatorService = new LoginValidatorService();
        getHtmlService = new GetHtmlFromResourcesService();
        logPassSplitterService = new LogPassSplitterServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getHtmlService.getHtml(req, resp, "html/login_page.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = logPassSplitterService.splitLogPass(req);

        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<body>");

        if (validatorService.validate(user.getLogin(), user.getPassword())) {
            HttpSession session = req.getSession();
            session.setAttribute("login", user.getLogin());
            writer.println("Access granted");
        } else {
            writer.println("Access denied");
        }

        writer.println("</body>");
        writer.println("</html>");


    }
}
