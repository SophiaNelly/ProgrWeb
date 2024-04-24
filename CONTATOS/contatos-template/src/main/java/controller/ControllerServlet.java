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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	// Reinicia a aplicação
		private void reset() {
		}

		// Põe na sessão a lista de contatos
		private void poeDadosNaSessao(HttpSession session) {
		}

		// Remove um contato da lista
		private void removeContato(String id) {
		}

		// Retorna (json) os dados do contato requerido
		private void getContato(HttpServletResponse response, String id) {
		}

		// Atualiza os dados do contato
		private void atualizaContato(String id, String nome, String tel, String email) {
		}

		// Cria um novo contato
		private void criaContato(String nome, String tel, String email) {
		}

}
