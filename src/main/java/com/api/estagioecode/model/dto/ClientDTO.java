package com.api.estagioecode.model.dto;

import com.api.estagioecode.model.City;
import com.api.estagioecode.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ClientDTO {
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private User user;

    @NotNull
    private String gender;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") //Transforma para o padrão brasileiro
    private LocalDate birthDate;

    @NotNull
    private Long cpf;

    private Long rg;

    @NotNull
    private Integer cep;

    @NotNull
    private String address;

    @NotNull
    private Integer number;

    @NotNull
    private String district;

    private String addressComplement;

    @NotNull
    private City city;

    private Long phone;

    @NotNull
    private Long celPhone;

    @NotNull
    private Integer status;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getRg() {
        return rg;
    }

    public void setRg(Long rg) {
        this.rg = rg;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddressComplement() {
        return addressComplement;
    }

    public void setAddressComplement(String addressComplement) {
        this.addressComplement = addressComplement;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Long getCelPhone() {
        return celPhone;
    }

    public void setCelPhone(Long celPhone) {
        this.celPhone = celPhone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
