package com.minhhai.learn.entities;

import com.minhhai.learn.entities.common.AbstractEntity;
import com.minhhai.learn.enums.RoleEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RoleEntity extends AbstractEntity {
    private static final long serialVersionUID = 1079242486242521723L;

    private RoleEnum role;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}
