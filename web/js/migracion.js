function init() {
    mostrarform(false);
}

function mostrarform(flat, accion) {
    if (flat) {
        $("#tablamigracion").hide();
        $("#registrarmigracion").show();
        $("#accion").val(accion);
    } else {
        $("#tablamigracion").show();
        $("#registrarmigracion").hide();
    }
}

function cancelarForm() {
    mostrarform(false);
}

init();
