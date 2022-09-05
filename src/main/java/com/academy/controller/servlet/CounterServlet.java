package com.academy.controller.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class CounterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Reader reader = new FileReader("C:\\Users\\nembi\\IdeaProjects\\Servlets\\src\\main\\resources\\json\\counter.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        int a = Integer.parseInt(bufferedReader.readLine()) + 1;

        BufferedImage image = new BufferedImage(500, 200, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();
        graphics2D.setFont(new Font("Serif", Font.ITALIC, 48));
        graphics2D.setColor(Color.green);
        graphics2D.drawString(String.valueOf(a),100,100);

        ServletOutputStream out = resp.getOutputStream();
        ImageIO.write(image,"jpeg",out);

        PrintWriter writer1 = new PrintWriter("C:\\Users\\nembi\\IdeaProjects\\Servlets\\src\\main\\resources\\json\\counter.txt");
        writer1.println(a);
        reader.close();
        writer1.close();
    }
}
