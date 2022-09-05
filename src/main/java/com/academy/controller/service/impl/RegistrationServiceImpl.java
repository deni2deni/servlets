package com.academy.controller.service.impl;

import com.academy.model.entity.User;
import com.academy.controller.service.interfaces.RegistrationService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Map;

public class RegistrationServiceImpl implements RegistrationService {
    @Override
    public void register(HttpServletResponse resp, Map<String, String> userData, User user) throws IOException {
        URL res = getClass().getClassLoader().getResource("json/logPass.json");
        File file;
        String absolutePathOfTarget = "";
        String absolutePathOfResource = "";

        try {
            file = Paths.get(res.toURI()).toFile();
            absolutePathOfTarget = file.getAbsolutePath();
            absolutePathOfResource = new StringBuilder(absolutePathOfTarget).reverse()
                    .delete(0, "target\\classes\\json\\logPass.json".length())
                    .reverse()
                    .append("src\\main\\resources\\json\\logPass.json")
                    .toString();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        PrintWriter writer = resp.getWriter();
        if (!userData.containsKey(user.getLogin())) {
            userData.put(user.getLogin(), user.getPassword());
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(absolutePathOfTarget), userData);
            mapper.writeValue(new File(absolutePathOfResource), userData);
            writer.println("<html><body>User created!</body></html>");
        } else {
            writer.println("<html><body>This login is already taken</body></html>");
        }
    }
}
