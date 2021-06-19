package com.api.estagioecode.mapper;

import com.api.estagioecode.model.User;
import com.api.estagioecode.model.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper implements MapperInterface<User, UserDTO>{
    @Override
    public User toEntity(UserDTO userDTO) {
        User user = new User();

        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    @Override
    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }

    @Override
    public List<UserDTO> toDTO(List<User> list) {
        return list.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
