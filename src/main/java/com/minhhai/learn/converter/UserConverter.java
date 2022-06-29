package com.minhhai.learn.converter;

import com.minhhai.learn.entities.UserEntity;
import com.minhhai.learn.model.dto.UserDTO;

import java.util.Collection;
import java.util.List;

public interface UserConverter {

    UserDTO userEntityToDTO(UserEntity entity);

    List<UserDTO> userEntitiesToDTOs(Collection<UserEntity> entities);

    UserEntity userDTOToEntity(UserDTO dto);

    List<UserEntity> userDTOsToEntities(Collection<UserDTO> dtos);

}
