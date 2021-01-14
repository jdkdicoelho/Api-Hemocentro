package com.fiap.ApiBancoDeSangue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fiap.ApiBancoDeSangue.dto.DoadorCreateUpdateDTO;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "TB_DOADOR")
public class Doador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String nome;

    @Column
    private int idade;

    @Column
    private String tiposanguineo;

    @Column
    private String Rg;

    @Column
    private String email;

    @Column
    private Boolean ativo;

    public Doador() {
    }

    public Doador(DoadorCreateUpdateDTO doadorCreateUpdateDTO) {
        this.id = 0L;
        this.nome = doadorCreateUpdateDTO.getNome();
        this.idade = doadorCreateUpdateDTO.getIdade();
        this.tiposanguineo = doadorCreateUpdateDTO.getTiposanguineo();
        this.Rg = doadorCreateUpdateDTO.getRg();
        this.ativo = true;
        this.email= doadorCreateUpdateDTO.getEmail();
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTiposanguineo() {
        return tiposanguineo;
    }

    public void setTiposanguineo(String tiposanguineo) {
        this.tiposanguineo = tiposanguineo;
    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String rg) {
        Rg = rg;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getEmail() {   return email;   }

    public void setEmail(String email) {  this.email = email;   }
}

