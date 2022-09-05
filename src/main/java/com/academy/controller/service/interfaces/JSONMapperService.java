package com.academy.controller.service.interfaces;

import java.io.IOException;
import java.util.Map;

public interface JSONMapperService {
    Map<String, String> getLoginPasswordMap() throws IOException;
}
