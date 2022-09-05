package com.academy.controller.service.interfaces;

import com.academy.model.entity.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public interface RegistrationService {
    void register(HttpServletResponse resp, Map<String, String> userData, User user) throws IOException;
}
