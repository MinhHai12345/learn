package com.minhhai.learn.converter.impl;

import com.minhhai.learn.converter.RoleConverter;
import com.minhhai.learn.entities.RoleEntity;
import com.minhhai.learn.model.dto.RoleDTO;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleConverterImpl implements RoleConverter {

    @Override
    public RoleDTO roleEntityToDTO(final RoleEntity entity) {
        RoleDTO dto = null;
        if (entity != null) {
            dto = new RoleDTO();
            dto.setId(entity.getId());
            dto.setRole(entity.getRole());
            dto.setCreatedAt(entity.getCreatedAt());
            dto.setUpdatedAt(entity.getUpdatedAt());
        }
        return dto;
    }

    @Override
    public List<RoleDTO> roleEntitiesToDTOs(final Collection<RoleEntity> entities) {
        return entities.stream().map(this::roleEntityToDTO).collect(Collectors.toList());
    }

    @Override
    public RoleEntity roleDTOToEntity(final RoleDTO dto) {
        RoleEntity entity = null;
        if (dto != null) {
            entity = new RoleEntity();
            entity.setId(dto.getId());
            entity.setRole(dto.getRole());
        }
        return entity;
    }

    @Override
    public List<RoleEntity> roleDTOsToEntities(final Collection<RoleDTO> dtos) {
        return dtos.stream().map(this::roleDTOToEntity).collect(Collectors.toList());
    }
}
