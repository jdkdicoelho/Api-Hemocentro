package com.fiap.ApiBancoDeSangue.dto;

import com.fiap.ApiBancoDeSangue.entity.BancoDeSangue;

import javax.persistence.Column;
import java.util.List;

public class BancoDeSangueDTO {

    private Long id;

    private String nome;

    private String endereco;

    private String telefone;

    private List<String> deficitSanguineo;

    private String email;

    public BancoDeSangueDTO() {}

    public BancoDeSangueDTO(BancoDeSangue bancoDeSangue) {
        this.id =bancoDeSangue.getId();
        this.nome = bancoDeSangue.getNome();
        this.endereco = bancoDeSangue.getEndereco();
        this.telefone = bancoDeSangue.getTelefone();
        this.deficitSanguineo = bancoDeSangue.getDeficitSanguineo();
        this.email = bancoDeSangue.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<String> getDeficitSanguineo() {
        return deficitSanguineo;
    }

    public void setDeficitSanguineo(List<String> deficitSanguineo) {
        this.deficitSanguineo = deficitSanguineo;
    }

    public String getEmail() {   return email;    }

    public void setEmail(String email) {   this.email = email;   }
}
