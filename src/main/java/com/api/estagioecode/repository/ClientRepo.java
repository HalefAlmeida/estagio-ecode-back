package com.api.estagioecode.repository;

import com.api.estagioecode.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

    @Query("SELECT client FROM Client client WHERE client.cpf = :cpf")
    Optional<Client> findByCPF(Long cpf);
}
