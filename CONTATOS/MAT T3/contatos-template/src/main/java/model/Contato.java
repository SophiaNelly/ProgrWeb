package model;

import java.io.Serializable;

public class Contato implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private String tel;
	private String email;
	
	public Contato() {}
	
	public Contato(String nome, String tel, String email) {
		this.nome = nome;
		this.tel = tel;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", tel=" + tel + ", email=" + email + "]";
	}
	
	

}
