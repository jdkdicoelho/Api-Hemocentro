package com.fiap.ApiBancoDeSangue.dto;

public class DoadorCreateUpdateDTO {

    private String nome;

    private int idade;

    private String tiposanguineo;

    private String Rg;

	private String email;

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

	public String getEmail() {return email;	}

	public void setEmail(String email) {  this.email = email;	}
}
