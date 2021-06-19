package com.api.estagioecode.service;

import com.api.estagioecode.exceptions.BusinessException;
import com.api.estagioecode.exceptions.NotFoundException;
import com.api.estagioecode.mapper.UserMapper;
import com.api.estagioecode.model.User;
import com.api.estagioecode.model.dto.UserDTO;
import com.api.estagioecode.repository.UserRepo;
import com.api.estagioecode.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements ServiceInterface<User, UserDTO> {

    @Autowired
    private UserRepo repo;

    @Autowired
    private UserMapper mapper;

    @Override
    public UserDTO save(UserDTO userDTO) {
        Optional<User> optionalUser = repo.findByEmail(userDTO.getEmail());

        if (optionalUser.isPresent()){
            throw new BusinessException(MessageUtils.REGISTER_ALREADY_EXISTS);
        }

        User user = mapper.toEntity(userDTO);
        repo.save(user);
        userDTO.setId(user.getId());
        return mapper.toDTO(user);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {

//        Optional<User> optionalUser = repo.findByEmailUpdate(userDTO.getEmail());
//
//        if (optionalUser.isPresent()){
//            throw new BusinessException(MessageUtils.REGISTER_ALREADY_EXISTS);
//        }

        User user = mapper.toEntity(userDTO);
        repo.save(user);
        return mapper.toDTO(user);
    }

    @Override
    public List<UserDTO> findAll() {
        return mapper.toDTO(repo.findAll());
    }

    @Override
    public UserDTO findById(Long id) {
        return repo.findById(id).map(mapper::toDTO).orElseThrow(NotFoundException::new);
    }

    @Override
    public UserDTO delete(Long id) {
        UserDTO userDTO = this.findById(id);
        repo.deleteById(id);
        return userDTO;
    }

    @Transactional(readOnly = true)
    public UserDTO findByEmail(String email) {
        return repo.findByEmail(email).map(mapper::toDTO).orElseThrow(NotFoundException::new);
    }
}
