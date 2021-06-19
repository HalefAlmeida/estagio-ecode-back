package com.api.estagioecode.mapper;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Realiza a correta conversão entre objetos entidade e objetos DTO
 * @param <entity> Classe da entidade
 * @param <dto> Classe DTO
 */
public interface MapperInterface<entity,dto> {
    /**
     * Transforma um objeto DTO em um objeto entidade
     * @param dto DTO a ser transformado
     * @return Objeto entidade
     */
    public entity toEntity(dto dto);

    /**
     * Tranforma um objeto entidade em um objeto DTO
     * @param entity Entidade a ser transformada
     * @return Objeto DTO
     */
    public dto toDTO(entity entity);

    /**
     * Tranforma uma Lista de objetos entidade em uma lista de objetos DTO
     * @param list Lista de objetos entidades a ser transformada
     * @return Lista com objetos DTO
     */
    public List<dto> toDTO(List<entity> list);
}
