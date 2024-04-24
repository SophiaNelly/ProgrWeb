<%@page import="model.Contato"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- CONSTRUÇÃO A LISTA DE CONTATOS -->
	<%
	HttpSession sessao = request.getSession();
	if (sessao.getAttribute("lista") != null) {
		ArrayList<Contato> lista = (ArrayList<Contato>) sessao.getAttribute("lista");
		for (Contato c: lista) {
			%>
			<div class="contatos">
				<div class="nome"><%= c.getNome() %></div>
				<div class="tel"><%= c.getTel() %></div>
				<div class="email"><%= c.getEmail() %></div>
				<div class="btn edit" onclick="editContato('<%= c.getId() %>')">EDITAR</div>
				<div class="btn del" onclick="delContato('<%= c.getId() %>')">APAGAR</div>
			</div>
			<%
		}
	}
	%>
