const ocultarEdit = () => {
	document.getElementById('edit-id').style.display = 'none';
}

const visualizarEdit = () => {
	document.getElementById('edit-id').style.display = 'block';
}

const visualizarNovo = () => {
	document.getElementById('novo-contato-id').style.display = 'block';
}

const ocultarNovo = () => {
	document.getElementById('novo-contato-id').style.display = 'none';
}

// RESET -> remove todos os dados e acrescenta os dados default do exercício
const reset = () => {
}

// LADO DO SERVIDOR: guarda na sessão atual -> necessário para exibicão inicial dos contatos
const atualizaSessao = () => {
}

// REMOVE CONTATO
const delContato = (id) => {
}

// MENU DE EDIÇÃO DE CONTATO: APENAS EXPÕE DADOS
// OBS: o botão OK autoriza envio
const editContato = function(id) {
	
}

const cancelarEdit = () => {
}

const cancelarNovo = () => {
}

// MENU EDIT -> envia o conteúdo editado: botão OK
const enviaEdit = function() {
}

// MENU DE CRIAÇÃO DE NOVO CONTATO
const novoContato = () => {
}

const enviaNovo = function() {
}


// RECONSTRUÇÃO DE PARTE DA TELA -> mostra a lista de contatos
const expoeListaContatos = () => {
}


// ===================================================================================
// 		INICIALIZA O PROCESSAMENTO
atualizaSessao();
expoeListaContatos();

let botoesBloqueados = false;

