package com.miniproject.todo.model;

public class AuthenticationResponse {
    private boolean success;
    private String errormsg;
    private String authToken;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(boolean success, String errormsg, String authToken) {
        this.success = success;
        this.errormsg = errormsg;
        this.authToken = authToken;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
