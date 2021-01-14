package com.fiap.ApiBancoDeSangue.dto;

import com.fiap.ApiBancoDeSangue.entity.Doador;

public class DoadorDTO {

	private Long id;

	private String nome;

	private int idade;

	private String tiposanguineo;

	private String email;

	private String Rg;

	public DoadorDTO() {
	}

	public DoadorDTO(Doador doador) {
		this.id = doador.getId();
		this.nome = doador.getNome();
		this.idade = doador.getIdade();
		this.tiposanguineo = doador.getTiposanguineo();
		this.Rg = doador.getRg();
		this.email= doador.getEmail();
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

	public String getEmail() { return email; 	}

	public void setEmail(String email) {this.email = email;	}

}
