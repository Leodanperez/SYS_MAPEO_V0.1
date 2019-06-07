//Funcion que se ejecuta al inicio
function init() {
    mostrarform(false);
    listar();
}

//Funcion limpiar
function limpiar()
{
    $("input[type='text']").val("");
}

//Funcion mostrar formulario
function mostrarform(flag, modo) {
    if (flag)
    {
        $("#listadoUsuarios").hide();
        $("#formInsertUsuarios").show();
        $("#btnGuardar").prop("disabled", false);
        $("#btnagregar").hide();
        $("#formUpdateUsuarios").hide();
        $("#modo").val(modo);
    } else {
        $("#listadoUsuarios").show();
        $("#formInsertUsuarios").hide();
        $("#formUpdateUsuarios").hide();
        $("#btnagregar").show();
        $("#actualizarol").hide();
    }

}

//Función Listar
function listar()
{
    $("#listadoUsuarios").show();
}

//Función cancelarform
function cancelarform()
{
    limpiar();
    mostrarform(false);
}

var servlet = 'Usuarios';
var link = 'getListUsuarios';
//Funcion insertar usuario
function fn_registrarUsuario() {
    var cip = $("#nroCipInsert").val();
    var login = $("#nombUsuarioInsert").val();
    var pass = $("#passwordInsert").val();
    var correo = $('#emailInsert').val();
    var foto = $('#fotoInsert').val();
    $.ajax({
        type: "POST",
        url: "Usuarios",
        data: {action: 'insert', cip: cip, login: login, pass: pass, correo: correo, foto: foto},
        success: function (data) {
            if (data === "EXITO") {
                swal("AVISO DEL SISTEMA", "Datos Guardados con Exito..!", "success");
                fn_CargarMenu(servlet, link);
            } else {
                swal("AVISO DEL SISTEMA", data, "error");
            }
        }
    });

}

//Función mostrar formulario
function fn_datosUpdateUsuario(flag, codigo, apellNom, cip, login, email, foto)
{
    $("#codUsuariosUpdate").val(codigo);
    $("#ApellNomUpdate").val(apellNom);
    $("#CipUpdate").val(cip);
    $("#usuarioUpdate").val(login);
    $("#emailUpdate").val(email);
    $("#fotoUpdate").val(foto);
    if (flag)
    {
        $("#listadoUsuarios").hide();
        $("#formInsertUsuarios").hide();
        $("#formUpdateUsuarios").show();
        $("#btnGuardar").prop("disabled", false);
        $("#btnagregar").hide();
    } else
    {
        $("#listadoUsuarios").show();
        $("#formInsertUsuarios").hide();
        $("#formUpdateUsuarios").hide();
    }
}

function fn_updateUsuario() {
    var codigo = $("#codUsuariosUpdate").val();
    var login = $('#usuarioUpdate').val();
    var email = $('#emailUpdate').val();
    var foto = $('#fotoUpdate').val();
    var estado = $('#estadoUpdate').val();

    $.ajax({
        type: "POST",
        url: "Usuarios",
        data: {action: 'update', codigo: codigo, login: login, email: email, foto: foto, estado: estado},
        success: function (data) {
            if (data === "EXITO") {
                swal("AVISO DEL SISTEMA", "Datos actualizados exitosamente..!", "success");
                fn_CargarMenu(servlet, link);
            } else {
                swal("AVISO DEL SISTEMA", data, "error");
            }
        }
    });

}

//ELIMINAR USUARIOS
function fn_deleteUsuario(codUsuario) {
    $.ajax({
        type: "POST",
        url: "Usuarios",
        data: {action: 'delete', codigoU: codUsuario},
        success: function (data) {
            if (data === 'EXITO') {
                swal("AVISO DEL SISTEMA!", "Se elimino el registro correctamente...!", "success");
            } else {
                swal("AVISO DEL SISTEMA!", "Error al eliminar el Usuario...!", "error");
            }
            fn_CargarMenu(servlet, link);
        }
    });
}

function buscarpersonal() {
    var busqueda = $("#buscarPersonal").val();
    busqueda = busqueda.replace(" ", "/");
    $("#resultBuscarPersona").load("Usuarios?action=BuscarPersonal&valor=" + busqueda);
}


function mostrarbusquedaPersonal() {
    var elementos = document.getElementsByName("radioCip");
    var cip = null;
    for (var i = 0; i < elementos.length; i++) {
        if (elementos[i].checked) {
            cip = elementos[i].value;
            break;
        }
    }

    if (cip !== null) {
        $.ajax({
            type: "GET",
            url: "Usuarios",
            data: {action: 'mostrarPersona', cip: cip},
            success: function (data) {
                var dato = data.split("+++");
                $("#nroCipInsert").val(dato[0]);
                $("#nombre").val(dato[3]);
            }
        });
    }
}

/*START ASIGNACION DE USUARIOS A PERFILES*/

function BuscarUsuario() {
    var busqueda = $("#busquedaUser").val();
    busqueda = busqueda.replace(" ", "/");
    $("#resultBuscarUsuario").load("UsuariosPerfiles?action=buscarUsuario&valor=" + busqueda);
}


function mostrarBusquedaUsuario() {
    var elementos = document.getElementsByName("radioUsuario");
    var cip = null;
    for (var i = 0; i < elementos.length; i++) {
        if (elementos[i].checked) {
            cip = elementos[i].value;
            break;
        }
    }

    if (cip !== null) {
        $.ajax({
            type: "GET",
            url: "UsuariosPerfiles",
            data: {action: 'mostrarUsuario', cip: cip},
            success: function (data) {
                var dato = data.split("+++");
                if (dato.length === 6) {
                    $("#nroCip").val(dato[0]);
                    $("#login").val(dato[5]);
                    $("#nomApell").val(dato[3]);
                    $("#codigoU").val(dato[4]);
                    $("#PerfUsuario").load("UsuariosPerfiles?action=listUsuariosPerfiles&nroCip=" + dato[0]);
                    $("#comboPerfilesAsig").load("UsuariosPerfiles?action=getPerfilesSelect");
                }
            }
        });
    }
}

function insertUP() {
    var nroCip = $("#nroCip").val();
    var codUsuario = $("#codigoU").val();
    var codPerfil = $("#comboPerfiles").val();
    $.ajax({
        type: "POST",
        url: "UsuariosPerfiles",
        data: {action: 'insertUP', nroCip: nroCip, codUsuario: codUsuario, codPerfil: codPerfil},
        success: function (data) {
            if (data === "true") {
                swal("AVISO DEL SISTEMA!", "Se inserto el registro correctamente!", "success");
                $("#PerfUsuario").load("UsuariosPerfiles?action=listUsuariosPerfiles&nroCip=" + nroCip);
            }else{
                swal("AVISO DEL SISTEMA!", "Error al insertar registro!", "error");
            }
        }
    });

}


function deleteUP(a, b, c) {
    $.ajax({
        type: "POST",
        url: "UsuariosPerfiles",
        data: {action: 'deleteUP', codigoUsuario: a, codPerfil: b, nroCip: c},
        success: function (data) {
            if (data) {
                swal("AVISO DEL SISTEMA!", "Se elimino el registro correctamente!", "success");
                $("#PerfUsuario").load("UsuariosPerfiles?action=listUsuariosPerfiles&nroCip=" + c);
            }
        }
    });
}

/*END ASIGNACION DE USUARIOS A PERFILES*/

init();

