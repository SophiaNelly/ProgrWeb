package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Registro;

public class Dao {
	
	private static Dao instance = null;
	private Connection connection = null;
	
	private String driver = "org.h2.Driver";
	private String url = "jdbc:h2:mem:testdb";
	private String user = "sa";
	private String password = "";
	
	private Dao() {
		this.confDb();
		this.conectar();
		this.criarTabela();
		this.popularBanco();
	}
	
	public static Dao getInstance() {
		if (instance == null) {
			instance = new Dao();
		}
		return instance;
	}
	
	// CONFIGURAÇÃO DO BANCO DE DADOS
	private void confDb() {
		try {
			Class.forName(this.driver);
		} catch (ClassNotFoundException e) {
			// TODO: o que fazer se deu errado
			System.out.println("Problema ao carregar o driver");
		}
	}
	
	// ESTABELECENDO A CONEXÃO
	private void conectar() {
		try {
			this.connection = DriverManager.getConnection(this.url, this.user, this.password);
		} catch (Exception e) {
			// TODO: o que fazer se deu errado
			System.out.println("Houve erro ao tentar conexão");
		}
	}
	
	// CRIAÇÃO DA TABELA
	private void criarTabela() {
		String query = "CREATE TABLE TABELA ("
				+ "ID INT AUTO_INCREMENT PRIMARY KEY,"
				+ "NOME VARCHAR(100),"
				+ "TEL VARCHAR(15)"
				+ ")";
		try {
			Statement st = this.connection.createStatement();
			st.execute(query);
		} catch (Exception e) {
			// TODO: O que fazer se deu errado
			System.out.println("Erro ao criar tabela");
		}
	}
	
	// POPULA O BANCO
	private void popularBanco() {
		Registro reg1 = new Registro("Marcos Dessa", "0800");
		this.create(reg1);
		
		Registro reg2 = new Registro("Pablo Picasso", "0900");
		this.create(reg2);
		
		Registro reg3 = new Registro("Michelangelo", "0880");
		this.create(reg3);
	}
	
	/*	**********************************************************
	 * 		C R U D
	 * 	**********************************************************
	 */
	
	// CRUD READ
	public ArrayList<Registro> findAll() {
		ArrayList<Registro> lista = new ArrayList();
		String query = "SELECT ID, NOME, TEL FROM TABELA";
		try {
			Statement st = this.connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Registro reg = new Registro();
				reg.setId(rs.getInt("ID"));
				reg.setNome(rs.getString("NOME"));
				reg.setTel(rs.getString("TEL"));
				lista.add(reg);
			}
		} catch (Exception e) {
			// TODO: o que fazer se deu errado
			System.out.println("Erro ao tentar encontrar todos os registros");
		}
		return lista;
	}
	
	public Registro findById(int id) {
		String query = "SELECT NOME, TEL FROM TABELA WHERE ID = ?";
		Registro reg = new Registro();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				reg.setId(id);
				reg.setNome(rs.getString("NOME"));
				reg.setTel(rs.getString("TEL"));
			}
		} catch (Exception e) {
			// TODO: o que fazer se deu errado
			System.out.println("Erro ao procurar elemento com id informado");
		}
		return reg;
	}
	
	
	// CRUD CREATE
	public void create(Registro reg) {
		String query = "INSERT INTO TABELA (NOME, TEL) VALUES (?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, reg.getNome());
			ps.setString(2, reg.getTel());
			ps.execute();
		} catch (Exception e) {
			// TODO: o que fazer se deu errado
			System.out.println("Erro ao criar registro");
		}
	}
	
	// CRUD DELETE
	public void delete(int id) {
		String query = "DELETE FROM TABELA WHERE ID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.execute();
		} catch (Exception e) {
			// TODO: o que fazer se deu errado
			System.out.println("Erro ao remover elemento com id selecionado");
		}
	}
	
	// CRUD UPDATE
	public void update(Registro reg) {
		String query = "UPDATE TABELA SET NOME = ?, TEL = ? WHERE ID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, reg.getNome());
			ps.setString(2, reg.getTel());
			ps.setInt(3, reg.getId());
			ps.execute();
		} catch (Exception e) {
			// TODO: o que fazer se deu errado
			System.out.println("Erro ao atualizar o dado");
		}
	}

}
