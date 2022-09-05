package com.academy.controller.servlet;

import com.academy.controller.service.impl.GetHtmlFromResourcesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class ContactFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetHtmlFromResourcesService getHtmlFromResourcesService = new GetHtmlFromResourcesService();
        getHtmlFromResourcesService.getHtml(req, resp, "/html/contact_form.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();

        String[] credits = reader.readLine().split("&");
        String name = credits[0].substring(5);
        String phone = credits[1].substring(6);
        String email = credits[2].substring(6);

        PrintWriter writer = resp.getWriter();
        boolean flag = true;

        if (name.equals("")) {
            writer.println("Invalid name");
            flag = false;
        }

        if (phone.equals("") && email.equals("")){
            writer.println("Invalid phone & email");
            flag = false;
        }

        if (flag){
            writer.println("Hello " + name + " Phone is " + phone + " Email is " + email);
            writer.println("Hello user of " + req.getHeader("User-Agent"));
        }
    }
}
