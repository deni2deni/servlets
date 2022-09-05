package com.academy.controller.service.interfaces;

import com.academy.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface LogPassSplitterService {
    User splitLogPass(HttpServletRequest req) throws IOException;
}
