package com.api.estagioecode.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controla as requisições realizadas para o endpoint especificado
 * @param <dto> DTO da entidade a ser utilizada para as requisições realizadas à API
 */
@CrossOrigin //Evita problemas com chamadas aos endpoints se chamados externos. Permite acessar de origens distintas
public interface ControllerInterface<dto> {

    /**
     * Salva um objeto na base de dados
     * @param dto Objeto a ser persistido
     * @return Objeto persistido
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<dto> save(@Valid @RequestBody dto dto);

    /**
     * Atualiza um registro existente na base de dados
     * @param dto Objeto existente a ser alterado
     * @return Objeto alterado
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<dto> update(@Valid @RequestBody dto dto);

    /**
     * Retorna todos os registros persistidos da base da dados
     * @return Lista com objetos da entidade
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<dto>> findAll();

    /**
     * Retorna um registro com o ID especificado existente na base de dados
     * @param id ID a ser buscado
     * @return Objeto com o ID informado
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<dto> findById(@PathVariable Long id);

    /**
     * Exclui um objeto existente da base de dados
     * @param id ID a ser excluído
     * @return Objeto excluído
     */
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<dto> delete(@PathVariable Long id);


}
