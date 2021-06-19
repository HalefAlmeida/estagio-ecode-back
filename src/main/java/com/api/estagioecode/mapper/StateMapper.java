package com.api.estagioecode.mapper;

import com.api.estagioecode.model.State;
import com.api.estagioecode.model.dto.StateDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StateMapper implements MapperInterface<State, StateDTO>{

    @Override
    public State toEntity(StateDTO stateDTO) {
        State state = new State();

        state.setId(stateDTO.getId());
        state.setName(stateDTO.getName());
        return state;
    }

    @Override
    public StateDTO toDTO(State state) {
        StateDTO stateDTO = new StateDTO();

        stateDTO.setId(state.getId());
        stateDTO.setName(state.getName());
        return stateDTO;
    }

    @Override
    public List<StateDTO> toDTO(List<State> list) {
        return list.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
