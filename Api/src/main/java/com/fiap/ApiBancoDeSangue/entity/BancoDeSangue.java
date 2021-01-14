package com.fiap.ApiBancoDeSangue.entity;


import com.fiap.ApiBancoDeSangue.dto.BancoDeSagueCreateUpdateDTO;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "TB_BANCO_SANGUE")
public class BancoDeSangue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String nome;

    @Column
    private String endereco;

    @Column
    private String telefone;

    @Column
    private String email;

    @ElementCollection
    private List<String> deficitSanguineo;

    @Column
    private Boolean ativo;

    public BancoDeSangue() {}

    public BancoDeSangue(BancoDeSagueCreateUpdateDTO bancoDeSagueCreateUpdateDTO) {
        this.id = 0L;
        this.nome = bancoDeSagueCreateUpdateDTO.getNome();
        this.endereco = bancoDeSagueCreateUpdateDTO.getEndereco();
        this.telefone = bancoDeSagueCreateUpdateDTO.getTelefone();
        this.deficitSanguineo = bancoDeSagueCreateUpdateDTO.getDeficitSanguineo();
        this.ativo = true;
        this.email= bancoDeSagueCreateUpdateDTO.getEmail();
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getEmail() {   return email;   }

    public void setEmail(String email) {  this.email = email;  }
}
