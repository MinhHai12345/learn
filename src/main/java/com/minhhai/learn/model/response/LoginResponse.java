package com.minhhai.learn.model.response;

import com.minhhai.learn.model.dto.UserDTO;

import java.io.Serializable;

public class LoginResponse implements Serializable {
    private static final long serialVersionUID = 635647914258532855L;

    private String accessToken;
    private UserDTO user;

    public LoginResponse() {

    }

    public LoginResponse(String accessToken, UserDTO user) {
        this.accessToken = accessToken;
        this.user = user;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
