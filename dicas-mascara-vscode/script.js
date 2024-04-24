document.getElementById('input-tel').addEventListener('input',
    (event) => {
        const input = event.target;
        let valor = input.value.replace(/\D/g, '').substring(0, 11);

        if (valor.length > 2) {
            valor = `(${valor.substring(0, 2)}) ${valor.substring(2)}`;
        }
        if (valor.length > 7) {
            valor = `${valor.substring(0, 9)}-${valor.substring(9, 13)}`;
        }

        input.value = valor;
    }
);

