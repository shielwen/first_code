package com.example.shieldwen.firs_code.demo5_sqlite.model;

public class Myuser {
    private int id;//用户信息实体类
  private String username;
  private String password;

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
