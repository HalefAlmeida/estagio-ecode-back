package com.api.estagioecode.repository;

import com.api.estagioecode.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepo extends JpaRepository<State, Long> {

    @Query("SELECT state FROM State state WHERE state.id = :id")
    Optional<State> findByIdUpdate(Long id);

}
