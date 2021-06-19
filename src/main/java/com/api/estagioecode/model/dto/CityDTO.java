package com.api.estagioecode.model.dto;

import com.api.estagioecode.model.State;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class CityDTO {

    private Long id;

    @NotNull
    private String name;

    @ManyToOne(targetEntity = State.class)
    private State state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
