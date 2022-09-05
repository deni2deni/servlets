package com.academy.controller.service.impl;

import com.academy.controller.service.interfaces.JSONMapperService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class JSONMapperServiceImpl implements JSONMapperService {
    @Override
    public Map<String, String> getLoginPasswordMap() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("json/logPass.json");
        Map<String, String> userData = mapper.readValue(inputStream, new TypeReference<Map<String, String>>() {
        });
        inputStream.close();
        return userData;
    }
}
