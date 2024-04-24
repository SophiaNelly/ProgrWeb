package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Contato;
import model.ListaContatosDAO;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControllerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String op = request.getParameter("op");
		String id;
		String nome;
		String tel;
		String email;
		switch (op) {
			case "RESET":
				this.reset();
				break;
			case "CREATE":
				nome = request.getParameter("nome");
				tel = request.getParameter("tel");
				email = request.getParameter("email");
				this.criaContato(nome, tel, email);
				break;
			case "READ":
				id = request.getParameter("id");
				this.getContato(response, id);
				break;
			case "UPDATE":
				id = request.getParameter("id");
				nome = request.getParameter("nome");
				tel = request.getParameter("tel");
				email = request.getParameter("email");
				this.atualizaContato(id, nome, tel, email);
				break;
			case "DELETE":
				id = request.getParameter("id");
				this.removeContato(id);
				break;
			case "START_SESSION":
				this.poeDadosNaSessao(session);
				break;

		}
	}

	// Reinicia a aplicação
	private void reset() {
		ListaContatosDAO instance = ListaContatosDAO.getInstance();
		instance.reset();
	}

	// Põe na sessão a lista de contatos
	private void poeDadosNaSessao(HttpSession session) {
		ListaContatosDAO instance = ListaContatosDAO.getInstance();
		ArrayList<Contato> lista = instance.getLista();
		session.setAttribute("lista", lista);
	}

	// Remove um contato da lista
	private void removeContato(String id) {
		ListaContatosDAO instance = ListaContatosDAO.getInstance();
		instance.delContato(Integer.parseInt(id));
	}

	// Retorna (json) os dados do contato requerido
	private void getContato(HttpServletResponse response, String id) {
		ListaContatosDAO instance = ListaContatosDAO.getInstance();
		Contato contato = instance.getContato(Integer.parseInt(id));
		response.setContentType("application/json");
		StringBuilder stb = new StringBuilder();
		stb.append("{\"id\": \"").append(contato.getId()).append("\",")
				.append("\"nome\": \"").append(contato.getNome())
				.append("\",").append("\"tel\": \"").append(contato.getTel())
				.append("\",").append("\"email\": \"")
				.append(contato.getEmail()).append("\"").append("}");
		String json = stb.toString();
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO: fazer alguma coisa
		}
	}

	// Atualiza os dados do contato
	private void atualizaContato(String id, String nome, String tel, String email) {
		ListaContatosDAO instance = ListaContatosDAO.getInstance();
//		Contato contato = instance.getContato(Integer.parseInt(id)); // TODO: REMOVER
		instance.editaContato(Integer.parseInt(id), nome, tel, email);
	}

	// Cria um novo contato
	private void criaContato(String nome, String tel, String email) {
		ListaContatosDAO instance = ListaContatosDAO.getInstance();
		instance.addContato(nome, tel, email);
	}

}
