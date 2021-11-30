package com.example.freshfind;

public class User
{
    private String id;
    private String email;
    private String password;
    private String passwordConfirm;
    private String user;

    public User(String id, String email, String password, String passwordConfirm, String user) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.user = user;
    }

    public User()
    {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
