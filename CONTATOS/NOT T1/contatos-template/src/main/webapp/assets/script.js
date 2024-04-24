const ocultarEdit = function() {
	document.getElementById('edit-id').style.display = 'none';
}

const visualizarEdit = function() {
	document.getElementById('edit-id').style.display = 'block';
}

const visualizarNovo = function() {
	document.getElementById('novo-contato-id').style.display = 'block';
}

const ocultarNovo = function() {
	document.getElementById('novo-contato-id').style.display = 'none';
}

// RESET -> remove todos os dados e acrescenta os dados default do exercício
const reset = function() {
	if (botoesBloqueados) return;
	let req = new XMLHttpRequest();
	req.open("POST", "ControllerServlet", true);
	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	req.onreadystatechange = () => {
		if (req.readyState == 4 && req.status == 200) {
			atualizaSessao();
			expoeListaContatos();
		} else {
			// O QUE FAZER SE DEU ERRADO
		}
	}
	req.send("op=RESET");
}

// LADO DO SERVIDOR: guarda na sessão atual -> necessário para exibicão inicial dos contatos
const atualizaSessao = function() {
	let req = new XMLHttpRequest();
	req.open("POST", "ControllerServlet", true);
	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	req.onreadystatechange = () => {
		if (req.readyState == 4 && req.status == 200) {
			expoeListaContatos();
			// O QUE FAZER SE DEU CERTO
		} else {
			// O QUE FAZER SE DEU ERRADO
		}
	}
	req.send("op=START_SESSION");
}

// REMOVE CONTATO
const delContato = function(id) {
	if (botoesBloqueados) return;
	let req = new XMLHttpRequest();
	req.open("POST", "ControllerServlet", true);
	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	req.onreadystatechange = () => {
		if (req.readyState == 4 && req.status == 200) {
			// O QUE FAZER SE DEU CERTO
			expoeListaContatos();
		} else {
			// O QUE FAZER SE DEU ERRADO
		}
	}
	req.send("op=DELETE&id=" + id);
}

// MENU DE EDIÇÃO DE CONTATO: APENAS EXPÕE DADOS
// OBS: o botão OK autoriza envio
const editContato = function(id) {
	if (botoesBloqueados) return;
	botoesBloqueados = true;
	visualizarEdit();
	let req = new XMLHttpRequest();
	req.open("POST", "ControllerServlet", true);
	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	req.onreadystatechange = () => {
		if (req.readyState == 4 && req.status == 200) {
			let jsonResponse = JSON.parse(req.responseText);
			document.getElementById('input-id').value = jsonResponse.id;
			document.getElementById('input-nome').value = jsonResponse.nome;
			document.getElementById('input-tel').value = jsonResponse.tel;
			document.getElementById('input-email').value = jsonResponse.email;
		} else {
			// O QUE FAZER SE DEU ERRADO
		}
	}
	req.send("op=READ&id=" + id);
	
}

const cancelarEdit = function() {
	document.getElementById('input-nome').value = '';
	document.getElementById('input-tel').value = '';
	document.getElementById('input-email').value = '';
	ocultarEdit();
	botoesBloqueados = false;
}

const cancelarNovo = function() {
	document.getElementById('input-nome-new').value = '';
	document.getElementById('input-tel-new').value = '';
	document.getElementById('input-email-new').value = '';
	ocultarNovo();
	botoesBloqueados = false;
}

// MENU EDIT -> envia o conteúdo editado: botão OK
const enviaEdit = function() {
	let id = document.getElementById('input-id').value;
	let nome = document.getElementById('input-nome').value;
	let tel = document.getElementById('input-tel').value;
	let email = document.getElementById('input-email').value;
	let req = new XMLHttpRequest();
	req.open("POST", "ControllerServlet", true);
	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	req.onreadystatechange = () => {
		if (req.readyState == 4 && req.status == 200) {
			cancelarEdit();
			expoeListaContatos();
		} else {
			// O QUE FAZER SE DEU ERRADO
		}
	}
	req.send("op=UPDATE&id=" + id + "&nome=" + nome + "&tel=" + tel + "&email=" + email);
}

// MENU DE CRIAÇÃO DE NOVO CONTATO
const novoContato = function() {
	if (botoesBloqueados) return;
	botoesBloqueados = true;
	visualizarNovo();
}

const enviaNovo = function() {
	let nome = document.getElementById('input-nome-new').value;
	let tel = document.getElementById('input-tel-new').value;
	let email = document.getElementById('input-email-new').value;
	let req = new XMLHttpRequest();
	req.open("POST", "ControllerServlet", true);
	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	req.onreadystatechange = () => {
		if (req.readyState == 4 && req.status == 200) {
			cancelarNovo();
			expoeListaContatos();
		} else {
			// O QUE FAZER SE DEU ERRADO
		}
	}
	req.send("op=CREATE&nome=" + nome + "&tel=" + tel + "&email=" + email);
}


// RECONSTRUÇÃO DE PARTE DA TELA -> mostra a lista de contatos
const expoeListaContatos = function() {
	let elemento = document.getElementById('lista-id');
	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			elemento.innerHTML = this.responseText;
		} else if (this.readyState == 4 && this.status != 200) {
			// O QUE FAZER SE ALGO DEU ERRADO
		}
	};
	req.open("GET", "ListaContatosServlet", true);
	req.send();
}


// ===================================================================================
// 		INICIALIZA O PROCESSAMENTO
atualizaSessao();

let botoesBloqueados = false;

