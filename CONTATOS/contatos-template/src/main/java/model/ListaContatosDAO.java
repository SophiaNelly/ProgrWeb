package model;

import java.util.ArrayList;

public class ListaContatosDAO {
	
	private static ListaContatosDAO instance = null;
	private ArrayList<Contato> listaContatos;
	private int indiceId = 1;
	
	private ListaContatosDAO() {
		this.listaContatos = new ArrayList<Contato>();
		this.iniciaLista();
	}
	
	public static ListaContatosDAO getInstance() {
		if (instance == null) {
			instance = new ListaContatosDAO();
		}
		return instance;
	}
	
	// Reinicia tudo
	public void reset() {
		this.listaContatos.clear();
		this.iniciaLista();
	}
	
	// Retorna a lista de contatos
	public ArrayList<Contato> getLista() {
		return this.listaContatos;
	}
	
	// Retorna um contato pelo id
	public Contato getContato(int id) {
		for (Contato c : this.listaContatos) {
			if (id == c.getId()) {
				return c;
			}
		}
		return null;
	}
	
	// Adiciona um contato
	public void addContato(String nome, String tel, String email) {
		Contato contato = new Contato(nome, tel, email);
		contato.setId(indiceId);
		this.indiceId++;
		this.listaContatos.add(contato);
	}
	
	// Remove um contato
	public void delContato(int id) {
		for (Contato c : this.listaContatos) {
			if (id == c.getId()) {
				this.listaContatos.remove(c);
				return;
			}
		}
	}
	
	// Edita um contato
	public void editaContato(int id, String nome, String tel, String email) {
		for (Contato c : this.listaContatos) {
			if (id == c.getId()) {
				c.setNome(nome);
				c.setEmail(email);
				c.setTel(tel);
			}
		}
	}
	
	// Inicia a lista com alguns registros
	private void iniciaLista() {
		this.addContato("Albert Einstein", "(71) 6654-1234", "einstein@mail.com");
		this.addContato("Isaac Newton", "(71) 9999-1234", "newton@mail.com");
		this.addContato("Sigmund Freud", "(71) 0800-1234", "freud@mail.com");
	}

}
