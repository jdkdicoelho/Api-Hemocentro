package com.fiap.ApiBancoDeSangue.dto;

import javax.persistence.Column;
import java.util.List;

public class BancoDeSagueCreateUpdateDTO {

    private String nome;

    private String endereco;

    private String telefone;

    private String email;

   private List<String> deficitSanguineo;

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

    public String getEmail() {  return email;   }

    public void setEmail(String email) {   this.email = email;  }
}
