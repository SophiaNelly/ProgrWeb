package program;

import java.util.ArrayList;

import model.Contato;
import model.ListaContatosDAO;

public class Main {

	public static void main(String[] args) {
		ListaContatosDAO listaInstance = ListaContatosDAO.getInstance();
		ArrayList<Contato> lista = listaInstance.getLista();
		
		listaInstance.delContato(2);
		listaInstance.addContato("Marcos", "(71) 9800-1234", "marcos@email.com");
		listaInstance.editaContato(1, "Tiririca", "(71) 91829182", "email");
		
		for (Contato c : lista) {
			System.out.println(c.toString());
		}
		
	}

}
