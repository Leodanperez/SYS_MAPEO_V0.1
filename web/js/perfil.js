//Función que se ejecuta al inicio
function init() {
    mostrarform(false);
    listar();

}

//Función limpiar
function limpiar()
{
    $("input[type='text']").val("");
}


//Función mostrar formulario
function mostrarform(flag, modo)
{
    if (flag)
    {
        $("#listadoPerfiles").hide();
        $("#formInsertPerfiles").show();
        $("#btnGuardar").prop("disabled", false);
        $("#btnagregar").hide();
        $("#formUpdatePerfiles").hide();
        $("#modo").val(modo);
    } else
    {
        $("#listadoPerfiles").show();
        $("#formInsertPerfiles").hide();
        $("#btnagregar").show();
        $("#formUpdatePerfiles").hide();
    }
}

//Función cancelarform
function cancelarform()
{
    limpiar();
    mostrarform(false);

}

//Función Listar
function listar()
{
    $("#listadoPerfiles").show();
}

var servlet = 'Perfiles';
var link = 'getListPerfiles';
//FUNCION PARA INSERTAR REGISTRO DE PERFILES
function fn_insertPerfiles() {
    var descripcion = $("#descripcionInsert").val();
    $.ajax({
        type: "POST",
        url: "Perfiles",
        data: {action: 'insert', descripcion: descripcion},
        success: function (data) {
            if (data === "EXITO") {
                swal("AVISO DEL SISTEMA", "Datos Guardados con Exito..!", "success");
                fn_CargarMenu(servlet, link);
            } else
            {
                swal("AVISO DEL SISTEMA", data, "error");
            }
        }

    });

}

//FUNCIÓN EDITAR PERFILES
function fn_dataUpdatePerfiles(flag, codigo, descripcion, estado)
{
    $("#codigoUpdate").val(codigo);
    $("#descripcionUpdate").val(descripcion);
    $("#estadoUpdate").val(estado);
    if (flag)
    {
        $("#listadoPerfiles").hide();
        $("#formInsertPerfiles").hide();
        $("#formUpdatePerfiles").show();
        $("#btnGuardar").prop("disable", false);
        $("btnagregar").hide();
    } else
    {
        $("#listadoPerfiles").show();
        $("#formInsertPerfiles").hide();
        $("#formUpdatePerfiles").hide();
        $("btnagregar").show();
    }
}


//FUNCION PARA ACTUALIZAR REGISTRO DE PERFILES
function fn_updatePerfiles() {
    var codPerfil = $("#codigoUpdate").val();
    var descripcion = $("#descripcionUpdate").val();
    $.ajax({
        type: "POST",
        url: "Perfiles",
        data: {action: "update", codigo: codPerfil, descripcion: descripcion},
        success: function (data) {
            if (data === "EXITO") {
                swal("AVISO DEL SISTEMA", "Datos Actualizados con Exito..!", "success");
                fn_CargarMenu(servlet, link);
            } else
            {
                swal("AVISO DEL SISTEMA", data, "error");
            }
        }

    });

}

function deletePerfiles(codigo){
    var codigo = codigo;
    $.ajax({
        type: "POST",
        url: "Perfiles",
        data: {action:"delete", codigo:codigo},
        success: function(data){
            if(data === "EXITO"){
                swal("AVISO DEL SISTEMA", "El registro ha sido eliminado.!", "success");
                fn_CargarMenu(servlet, link);
            }else{
                swal("AVISO DEL SISTEMA", data, "error");
            }
        }
    });
}

/*START ASIGNACION MODULOS A PERFILES*/

function fn_buscarPerfiles() {
    var busqueda = $("#valorBusquedaPerfil").val();
    $("#resulbuscarPerfil").load("PerfilesModulos?action=buscarPerfil&valor=" + busqueda);
}


function mostrarbusqueda() {
    var elementos = document.getElementsByName("codPerfil");
    var cod = null;
    for (var i = 0; i < elementos.length; i++) {
        if (elementos[i].checked) {
            cod = elementos[i].value;
            break;
        }
    }
    
   if (cod !== null) {
        $.ajax({
            type: "GET",
            url: "PerfilesModulos",
            data: {action: 'mostrarPerfiles', codigo: cod},
            success: function (data) {
                var dato = data.split("+++");
                $("#codigoPerfil").val(dato[0]);
                $('#descripcionPerfil').val(dato[1]);
                $('#moduloPerfil').load("PerfilesModulos?action=listPerfilesModulos&codPerfil=" + dato[0]);
                $("#selectModulos").load("PerfilesModulos?action=getModulosSelect");
            }
        });
    }
}


function insertPM() {
    var codPerfil = $("#codigoPerfil").val();
    var codigoModulo = $("#comboModulos").val();
    $.ajax({
        type: "POST",
        url: "PerfilesModulos",
        data: {action: 'insertPM', codigoPerfil: codPerfil, codigoModulo: codigoModulo},
        success: function (data) {
            if(data === "true"){
                swal("AVISO DEL SISTEMA!", "Se inserto el registro Correctamente!", "success");
                $("#moduloPerfil").load("PerfilesModulos?action=listPerfilesModulos&codPerfil=" + codPerfil);
            }else{
                swal("AVISO DEL SISTEMA!", "Error al insertar registro..!", "error");
            }
        }
    });
}


function deletePM(a, b) {
    alert(a , b);
    $.ajax({
        type: "POST",
        url: "PerfilesModulos",
        data: {action: 'deletePM', codPerf: a, codMod: b},
        success: function (data) {
            if (data) {
                swal("AVISO DEL SISTEMA!", "Se Elimino El registro Correctamente!", "success");
                $("#moduloPerfil").load("PerfilesModulos?action=listPerfilesModulos&codPerfil=" + a);
            }
        }
    });
}

/*END ASIGNACION MODULOS A PERFILES*/

init();