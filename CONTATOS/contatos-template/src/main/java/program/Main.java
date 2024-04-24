package program;

import java.util.ArrayList;

import model.Contato;
import model.ListaContatosDAO;

public class Main {

	public static void main(String[] args) {
		ListaContatosDAO dao = ListaContatosDAO.getInstance();
		ArrayList<Contato> lista = dao.getLista();
		
		dao.addContato("Marcos", "(71) 0800", "email@email.com");
		dao.delContato(2);
		dao.editaContato(4, "Tiririca", "(71) 9800", "tiririca@email");
		
		System.out.println("Contato número 1:");
		System.out.println(dao.getContato(1).toString());
		
		for (Contato c : lista) {
			System.out.println(c.toString());
		}
		
		
	}

}
