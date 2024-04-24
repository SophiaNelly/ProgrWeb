<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Meus Contatos</title>
<link rel="stylesheet" href="assets/style.css">
</head>

<body>
	<!-- HEADER -->
	<header class="container-cabecalho">
		<h3>Meus Contatos</h3>
	</header>

	<!-- NAV -->
	<nav class="container-nav">
		<div onclick="novoContato()" id="btn-novo" class="btn-top">NOVO</div>
		<div onclick="reset()" id="btn-reset" class="btn-top">RESET</div>
	</nav>

	<!-- ÁREA DE EDIÇÃO -->
	<div id="edit-id" hidden="true">
		<div class="container-edit">
			<div class="elemento-edit" hidden="true">Id</div>
			<div class="elemento-edit campo" hidden="true">
				<input type="text" class="inp" name="" id="input-id" disabled="true">
			</div>
			<div class="elemento-edit">Nome</div>
			<div class="elemento-edit campo">
				<input type="text" class="inp" name="" id="input-nome">
			</div>
			<div class="elemento-edit">Telefone</div>
			<div class="elemento-edit campo">
				<input type="tel" class="inp" name="" id="input-tel">
			</div>
			<div class="elemento-edit">E-mail</div>
			<div class="elemento-edit campo">
				<input type="email" class="inp" name="" id="input-email">
			</div>
		</div>
		<div class="container-edit btns">
			<div onclick="enviaEdit()" class="btn-ok">OK</div>
			<div onclick="cancelarEdit()" class="btn-cancel">CANCELAR</div>
		</div>
	</div>

	<!-- ÁREA DE NOVO CONTATO -->
	<div id="novo-contato-id" hidden="true">
		<div class="container-edit new">
			<div class="elemento-edit">Nome</div>
			<div class="elemento-edit campo">
				<input type="text" class="inp" name="" id="input-nome-new">
			</div>
			<div class="elemento-edit">Telefone</div>
			<div class="elemento-edit campo">
				<input type="tel" class="inp" name="" id="input-tel-new">
			</div>
			<div class="elemento-edit">E-mail</div>
			<div class="elemento-edit campo">
				<input type="email" class="inp" name="" id="input-email-new">
			</div>
		</div>
		<div class="container-edit btns">
			<div onclick="enviaNovo()" class="btn-ok">OK</div>
			<div onclick="cancelarNovo()" class="btn-cancel">CANCELAR</div>
		</div>
	</div>

	<!-- INCLUINDO LISTA DE CONTATOS -->
	<div class="container" id="lista-id">
		<jsp:include page="listaContatos.jsp"></jsp:include>
	</div>

	<script src="assets/script.js"></script>
</body>

</html>