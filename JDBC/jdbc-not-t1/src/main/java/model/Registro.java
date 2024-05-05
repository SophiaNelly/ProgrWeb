package model;

import java.io.Serializable;

public class Registro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private String tel;
	
	public Registro() {};
	
	public Registro(String nome, String tel) {
		this.nome = nome;
		this.tel = tel;
	}
	
	public Registro(int id, String nome, String tel) {
		this(nome, tel);
		this.id = id;
	}

	// GETTERS & SETTERS
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

	@Override
	public String toString() {
		return "Registro [id=" + id + ", nome=" + nome + ", tel=" + tel + "]";
	}

}
