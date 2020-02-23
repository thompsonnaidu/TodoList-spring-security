package com.miniproject.todo.model;

public class TokenData {
    private String username;
    private String empid;

    public TokenData() {
    }

    public TokenData(String username, String empid) {
        this.username = username;
        this.empid = empid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }
}
