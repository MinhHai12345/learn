package com.minhhai.learn.converter;

import com.minhhai.learn.entities.RoleEntity;
import com.minhhai.learn.model.dto.RoleDTO;

import java.util.Collection;
import java.util.List;

public interface RoleConverter {

    RoleDTO roleEntityToDTO(RoleEntity entity);

    List<RoleDTO> roleEntitiesToDTOs(Collection<RoleEntity> entities);

    RoleEntity roleDTOToEntity(RoleDTO dto);

    List<RoleEntity> roleDTOsToEntities(Collection<RoleDTO> dtos);
}
