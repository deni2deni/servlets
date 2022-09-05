package com.academy.controller.service.impl;

import com.academy.controller.service.interfaces.ValidatorService;

import java.io.IOException;
import java.util.Map;

public class LoginValidatorService implements ValidatorService {

    private final JSONMapperServiceImpl jsonMapperService;

    public LoginValidatorService() {
       jsonMapperService = new JSONMapperServiceImpl();
    }

    public boolean validate(String login, String password) throws IOException {

        Map<String, String> userData = jsonMapperService.getLoginPasswordMap();

        return password.equals(userData.get(login));
    }
}
