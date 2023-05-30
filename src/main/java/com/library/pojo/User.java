package com.library.pojo;

public class User {
    private String username;
    private String password;
    private String sex;
    private String email;
    private String uno;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String sex, String email, String uno) {
        this.username = username;
        this.password = password;
        this.sex = "男";
        this.email = email;
        this.uno = "1";
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
