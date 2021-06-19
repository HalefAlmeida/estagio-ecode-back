package com.api.estagioecode.repository;

import com.api.estagioecode.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT user FROM User user WHERE user.email = :email")
    Optional<User> findByEmail(String email);

    @Query("SELECT user FROM User user WHERE user.email = :email")
    Optional<User> findByEmailUpdate(String email);
}
