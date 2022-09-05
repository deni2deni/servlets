package com.academy.controller.service.impl;

import com.academy.model.entity.User;
import com.academy.controller.service.interfaces.LogPassSplitterService;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

public class LogPassSplitterServiceImpl implements LogPassSplitterService {
    @Override
    public User splitLogPass(HttpServletRequest req) throws IOException {
        BufferedReader reader = req.getReader();
        String input = reader.readLine().substring("login=".length());
        String[] logPass = input.split("&password=");
        User user = new User(logPass[0], logPass[1]);
        return user;
    }
}
