package com.academy.controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class HTMLServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();

        URL res = getClass().getClassLoader().getResource("html" + requestURI);
        File file;

        try {
            file = Paths.get(res.toURI()).toFile();
            String absolutePath = file.getAbsolutePath();

            ServletOutputStream outStream = resp.getOutputStream();
            FileInputStream fin = new FileInputStream(absolutePath);

            BufferedInputStream bin = new BufferedInputStream(fin);
            BufferedOutputStream bout = new BufferedOutputStream(outStream);
            int i = 0;

            while ((i = bin.read()) != -1){
                bout.write(i);
            }

            bin.close();
            fin.close();
            bout.close();
            outStream.close();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
