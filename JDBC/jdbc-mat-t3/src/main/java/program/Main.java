package program;

import java.util.ArrayList;

import dao.Dao;
import model.Registro;

public class Main {

	public static void main(String[] args) {
		
		Dao dao = Dao.getInstance();
		
		System.out.println("-> Procurando elemento de id = 2:");
		System.out.println("=> " + dao.findById(2).toString());
		
		System.out.println("-> Eliminando elemento de id = 3");
		dao.delete(3);
		
		System.out.println("-> Alterando o elemento de id = 2");
		Registro r = dao.findById(2);
		r.setNome("Atanagildo");
		dao.update(r);
		
		
		ArrayList<Registro> lista = dao.findAll();
		for (Registro reg: lista) {
			System.out.println(reg.toString());
		}

	}

}
