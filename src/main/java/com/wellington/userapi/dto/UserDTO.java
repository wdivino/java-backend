package com.wellington.userapi.dto;

import com.wellington.userapi.entity.User;

import java.util.Date;

public class UserDTO {

    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private Date dataCadastro;

    public UserDTO(String nome, String cpf, String endereco, String email, String telefone, Date dataCadastro) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
    }

    public static UserDTO converter(User user) {
        return new UserDTO(user.getNome(), user.getCpf(), user.getEndereco(), user.getEmail(), user.getTelefone(), user.getDataCadastro());
    }

    public void criadoEm(Date data) {
        this.dataCadastro = data;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }
}
