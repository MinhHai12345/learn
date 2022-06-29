package com.minhhai.learn.converter.impl;

import com.minhhai.learn.converter.RoleConverter;
import com.minhhai.learn.converter.UserConverter;
import com.minhhai.learn.entities.UserEntity;
import com.minhhai.learn.model.dto.UserDTO;
import org.assertj.core.util.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverterImpl implements UserConverter {

    @Autowired
    private RoleConverter roleConverter;

    @Override
    public UserDTO userEntityToDTO(final UserEntity entity) {
        UserDTO dto = null;
        if (entity != null) {
            dto = new UserDTO();
            dto.setId(entity.getId());
            dto.setUsername(entity.getUsername());
            dto.setPassword(entity.getPassword());
            dto.setRoles(Sets.newHashSet(roleConverter.roleEntitiesToDTOs(entity.getRoles())));
            dto.setStatus(entity.isStatus());
            dto.setCreatedAt(entity.getCreatedAt());
            dto.setUpdatedAt(entity.getUpdatedAt());
        }
        return dto;
    }

    @Override
    public List<UserDTO> userEntitiesToDTOs(final Collection<UserEntity> entities) {
        return entities.stream().map(this::userEntityToDTO).collect(Collectors.toList());
    }

    @Override
    public UserEntity userDTOToEntity(final UserDTO dto) {
        UserEntity entity = null;
        if (dto != null) {
            entity = new UserEntity();
            entity.setId(dto.getId());
            entity.setUsername(dto.getUsername());
            entity.setPassword(dto.getPassword());
            entity.setRoles(Sets.newHashSet(roleConverter.roleDTOsToEntities(dto.getRoles())));
            entity.setStatus(dto.isStatus());
        }
        return entity;
    }

    @Override
    public List<UserEntity> userDTOsToEntities(final Collection<UserDTO> dtos) {
        return dtos.stream().map(this::userDTOToEntity).collect(Collectors.toList());
    }
}
