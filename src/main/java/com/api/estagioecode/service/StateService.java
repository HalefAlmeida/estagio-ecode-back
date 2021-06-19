package com.api.estagioecode.service;

import com.api.estagioecode.exceptions.NotFoundException;
import com.api.estagioecode.mapper.StateMapper;
import com.api.estagioecode.model.State;
import com.api.estagioecode.model.dto.StateDTO;
import com.api.estagioecode.repository.StateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService implements ServiceInterface<State, StateDTO> {

    @Autowired
    private StateRepo repo;

    @Autowired
    private StateMapper mapper;

    @Override
    public StateDTO save(StateDTO stateDTO) {
        State state = mapper.toEntity(stateDTO);
        repo.save(state);
        stateDTO.setId(state.getId());
        return mapper.toDTO(state);
    }

    @Override
    public StateDTO update(StateDTO stateDTO) {
//        Optional<State> optionalState = repo.findByIdUpdate(stateDTO.getId());
//
//        if (optionalState.isPresent()){
//            throw new BusinessException(MessageUtils.REGISTER_ALREADY_EXISTS);
//        }

        State state = mapper.toEntity(stateDTO);
        repo.save(state);
        return mapper.toDTO(state);
    }

    @Override
    public List<StateDTO> findAll() {
        return mapper.toDTO(repo.findAll());
    }

    @Override
    public StateDTO findById(Long id) {
        return repo.findById(id).map(mapper::toDTO).orElseThrow(NotFoundException::new);
    }

    @Override
    public StateDTO delete(Long id) {
        StateDTO stateDTO = this.findById(id);
        repo.deleteById(stateDTO.getId());
        return stateDTO;
    }
}
