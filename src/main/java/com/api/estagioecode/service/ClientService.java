package com.api.estagioecode.service;

import com.api.estagioecode.exceptions.BusinessException;
import com.api.estagioecode.exceptions.NotFoundException;
import com.api.estagioecode.mapper.ClientMapper;
import com.api.estagioecode.model.Client;
import com.api.estagioecode.model.dto.ClientDTO;
import com.api.estagioecode.repository.CityRepo;
import com.api.estagioecode.repository.ClientRepo;
import com.api.estagioecode.repository.UserRepo;
import com.api.estagioecode.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements ServiceInterface<Client, ClientDTO> {

    @Autowired
    private ClientRepo repo;

    @Autowired
    private ClientMapper mapper;

    @Override
    public ClientDTO save(ClientDTO clientDTO) {
//        Optional<Client> optionalClient = repo.findByCPF(clientDTO.getCpf());
//
//        if (optionalClient.isPresent()){
//            throw new BusinessException(MessageUtils.CPF_ALREADY_EXISTS);
//        }

        Client client = mapper.toEntity(clientDTO);
        repo.save(client);
        clientDTO.setId(client.getId());
        return mapper.toDTO(client);
    }

    @Override
    public ClientDTO update(ClientDTO clientDTO) {

        Client client = mapper.toEntity(clientDTO);
        repo.save(client);
        return mapper.toDTO(client);
    }

    @Override
    public List<ClientDTO> findAll() {
        return mapper.toDTO(repo.findAll());
    }

    @Override
    public ClientDTO findById(Long id) {
        return repo.findById(id).map(mapper::toDTO).orElseThrow(NotFoundException::new);
    }

    @Override
    public ClientDTO delete(Long id) {
        ClientDTO clientDTO = this.findById(id);
        repo.deleteById(id);
        return clientDTO;
    }
}
