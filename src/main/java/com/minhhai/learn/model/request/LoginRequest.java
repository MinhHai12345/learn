package com.minhhai.learn.model.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class LoginRequest implements Serializable {
    private static final long serialVersionUID = 6548015539033901358L;

    @NotNull
    private String username;

    @NotNull
    @Min(5)
    private String password;

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
