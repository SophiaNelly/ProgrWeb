package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListaContatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListaContatosServlet() {
        super();
    }

    // Retorna um HTML contendo todos os contatos memorizados
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
