package com.api.estagioecode.mapper;

import com.api.estagioecode.model.City;
import com.api.estagioecode.model.Client;
import com.api.estagioecode.model.User;
import com.api.estagioecode.model.dto.CityDTO;
import com.api.estagioecode.model.dto.ClientDTO;
import com.api.estagioecode.model.dto.UserDTO;
import com.api.estagioecode.service.CityService;
import com.api.estagioecode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper implements MapperInterface<Client, ClientDTO>{

    @Autowired
    private CityService cityService;

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;


    @Override
    public Client toEntity(ClientDTO clientDTO) {

        CityDTO cityDTO = cityService.findById(clientDTO.getCity().getId());

        UserDTO userDTO =  userService.findById(clientDTO.getUser().getId());

        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setName(clientDTO.getName());
        client.setGender(clientDTO.getGender());
        client.setBirthDate(clientDTO.getBirthDate());
        client.setCpf(clientDTO.getCpf());
        client.setRg(clientDTO.getRg());
        client.setAddress(clientDTO.getAddress());
        client.setNumber(clientDTO.getNumber());
        client.setCep(clientDTO.getCep());
        client.setDistrict(clientDTO.getDistrict());
        client.setAddressComplement(clientDTO.getAddressComplement());
        client.setPhone(clientDTO.getPhone());
        client.setCelPhone(clientDTO.getCelPhone());
        client.setStatus(clientDTO.getStatus());
        client.setCity(cityMapper.toEntity(cityDTO));
        client.setUser(userMapper.toEntity(userDTO));

        return client;
    }

    @Override
    public ClientDTO toDTO(Client client) {
        CityDTO cityDTO = cityService.findById(client.getCity().getId());

        UserDTO userDTO =  userService.findById(client.getUser().getId());

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setGender(client.getGender());
        clientDTO.setBirthDate(client.getBirthDate());
        clientDTO.setCpf(client.getCpf());
        clientDTO.setRg(client.getRg());
        clientDTO.setAddress(client.getAddress());
        clientDTO.setNumber(client.getNumber());
        clientDTO.setCep(client.getCep());
        clientDTO.setDistrict(client.getDistrict());
        clientDTO.setAddressComplement(client.getAddressComplement());
        clientDTO.setPhone(client.getPhone());
        clientDTO.setCelPhone(client.getCelPhone());
        clientDTO.setStatus(client.getStatus());
        clientDTO.setCity(cityMapper.toEntity(cityDTO));
        clientDTO.setUser(userMapper.toEntity(userDTO));

        return clientDTO;
    }

    @Override
    public List<ClientDTO> toDTO(List<Client> list) {
        return list.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
