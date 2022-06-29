package com.minhhai.learn.model.dto;

import com.minhhai.learn.entities.RoleEntity;
import com.minhhai.learn.model.common.AbstractResponse;
import org.assertj.core.util.Sets;

import java.io.Serializable;
import java.util.Set;

public class UserDTO extends AbstractResponse {
    private static final long serialVersionUID = 5957275528043915859L;

    private String username;
    private String password;
    private boolean status;
    private Set<RoleDTO> roles = Sets.newHashSet();

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
    }
}
