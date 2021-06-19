package com.api.estagioecode.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Tratamento das regras de negócio para a entidade informada
 * @param <entity> Classe entidade
 * @param <dto> Classe DTO
 */
@Service
public interface ServiceInterface<entity,dto> {

    /**
     * Persiste um objeto DTO na base de dados
     * @param dto DTO  a ser persistido na base de dados
     * @return DTO persistido
     */
    @Transactional
    public dto save(dto dto);

    /**
     * Atualiza um registro já persistido na base de dados
     * @param dto DTO contendo o objeto com as alterações a serem realizadas no registro existente na base de dados
     * @return Objeto DTO atualizado
     */
    public dto update(dto dto);

    /**
     * Retorna todos os registros persistidos na base de dados
     * @return Lista com registros existentes na base de dados
     */
    @Transactional(readOnly = true)
    public List<dto> findAll();

    /**
     * Busca um registro persistido na base de dados pelo seu ID
     * @param id ID a ser buscado na base de dados
     * @return Objeto com o ID informado
     */
    @Transactional(readOnly = true)
    public dto findById(Long id);

    /**
     * Exclui um registro existente na base de dados
     * @param id ID a ser excluído da base de dados
     * @return Objeto excluído da base de dados
     */
    @Transactional()
    public dto delete(Long id);

}
