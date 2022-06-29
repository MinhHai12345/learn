package com.minhhai.learn.model.dto;

import com.minhhai.learn.enums.RoleEnum;
import com.minhhai.learn.model.common.AbstractResponse;

public class RoleDTO extends AbstractResponse {
    private static final long serialVersionUID = 5618953209283792249L;

    private RoleEnum role;

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}
