package com.academy.model.entity;

public class User {
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(User.class)) {
            User user = (User) obj;
            return this.login.equals(user.login) && this.password.equals(user.password);
        }
        return false;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
