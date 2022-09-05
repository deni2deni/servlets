package com.academy.controller.service.interfaces;

import java.io.IOException;

public interface ValidatorService {

    boolean validate(String login, String password) throws IOException;
}
