var tabla;

//Función que se ejecuta al inicio
function init() {
    mostrarformSuper(false);
    listar();
    mostrarformSub(false);
    fn_getModulosSuperCombo();
    fn_getListSubModulos();
}

//Función limpiar
function limpiar()
{
    $("input[type='text']").val("");
}

//Función Listar
function listar()
{
    $("#listadoModulosSuper").show();
    $("#listarSubModulos").show();
}

//Función mostrar formulario
function mostrarformSuper(flag)
{
    limpiar();
    if (flag)
    {
        $("#listadoModulosSuper").hide();
        $("#formInsertModulosSuper").show();
        $("#btnGuardar").prop("disabled", false);
        $("#formUpdateModulosSuper").hide();
    } else
    {
        $("#listadoModulosSuper").show();
        $("#formInsertModulosSuper").hide();
        $("#formUpdateModulosSuper").hide();
    }
}

//Función cancelarform
function cancelarformSuper()
{
    limpiar();
    mostrarformSuper(false);
    listar();
}

//Función mostrar formulario
function mostrarformSub(flag)
{
    if (flag)
    {
        $("#listarSubModulos").hide();
        $("#formInsertSubModulos").show();
        $("#btnGuardar").prop("disabled", false);
        $("#formUpdateSubModulos").hide();
    } else
    {
        $("#listarSubModulos").show();
        $("#formInsertSubModulos").hide();
        $("#btnGuardar").prop("disabled", false);
        $("#formUpdateSubModulos").hide();
    }
}

function cancelarformSub()
{
    limpiar();
    mostrarformSub(false);
    listar();
}

//FUNCION PARA INSERTAR REGISTRO DE MODULOS-SUPER
servlet = "Modulos";
action = "getListModulos";
function fn_registrarModulosSuper() {
    var descripcion = $("#descripcionInsert").val();
    var icono = $("#iconoInsert").val();
    var orden = $("#ordenInsert").val();
    $.ajax({
        type: "POST",
        url: "Modulos",
        data: {action: 'insertModSuper', descripcion: descripcion, icono: icono, orden: orden},
        success: function (data) {
            if (data === "EXITO") {
                swal("AVISO DEL SISTEMA!", "El registro se inserto exitosamente..!", "success");
                fn_CargarMenu(servlet, action);
            } else
            {
                swal("AVISO DEL SISTEMA!", data, "error");
            }
        }

    });

}


//FUNCIÓN EDITAR MÓDULO-SUPER
function fn_dataEditarModuloSuper(flag, codigo, descripcion, icono, orden)
{
    $("#codigoUpdate").val(codigo);
    $("#descripcionUpdate").val(descripcion);
    $("#iconoUpdate").val(icono);
    $("#ordenUpdate").val(orden);
    if (flag)
    {
        $("#listadoModulosSuper").hide();
        $("#formInsertModulosSuper").hide();
        $("#formUpdateModulosSuper").show();
        $("#btnGuardar").prop("disabled", false);
    } else
    {
        $("#listadoModulos").show();
        $("#formInsertModulosSuper").hide();
        $("#formUpdateModulosSuper").hide();
    }
}

//FUNCIÓN PARA ACTUALIZAR MODULOS-SUPER
function fn_updateModulosSuper() {
    var codigo = $("#codigoUpdate").val();
    var descripcion = $("#descripcionUpdate").val();
    var icono = $("#iconoUpdate").val();
    var orden = $("#ordenUpdate").val();
    $.ajax({
        type: "POST",
        url: "Modulos",
        data: {action: 'updateModSuper', codigo: codigo, descripcion: descripcion, icono: icono, orden: orden},
        success: function (data) {
            if (data === "EXITO") {
                swal("AVISO DEL SISTEMA!", "Los datos se actualizaron exitosamente..!", "success");
                fn_CargarMenu(servlet, action);
            } else
            {
                swal("AVISO DEL SISTEMA!", data, "error");
            }
        }
    });
}

function fn_deleteModulos(codModulo, modo) {
    var modo = modo;
    $.ajax({
        type: "POST",
        url: "Modulos",
        data: {action: 'delete', codModulo: codModulo},
        success: function (data) {
            if (data === 'EXITO' && modo === 'mS') {
                swal("AVISO DEL SISTEMA!", "Se elimino el registro correctamente...!", "success");
                fn_CargarMenu(servlet, action);
                
            }else if(data === 'EXITO' && modo === 'sM'){
                swal("AVISO DEL SISTEMA!", "Se elimino el registro correctamente...!", "success");
                fn_getListSubModulos();
                mostrarformSub(false);
                
            } else {
                swal("AVISO DEL SISTEMA!", "Error al eliminar el Modulo...!", "error");
            }

        }
    });
}

//FUNCION PARA INSERTAR REGISTRO DE SUB-MODULOS
function fn_getListSubModulos(){
    $("#tablegetListSubModulos").load("Modulos?action=getListSubModulos");
}

function fn_getModulosSuperCombo() {
    $("#comboModulosSuper").load("Modulos?action=comboModulos");
    $("#moduloSuperUpdate").load("Modulos?action=comboModulos");
}

function fn_insertSubModulos() {
    var descripcion = $("#descripcionSubInsert").val();
    var modSuper = $("#moduloSuperInsert").val();
    var servlet = $("#servletSubInsert").val();
    var link = $("#linkSubInsert").val();
    var icono = $("#iconoSubInsert").val();
    var nOrden = $("#nOrdenSubInsert").val();
    $.ajax({
        type: "POST",
        url: "Modulos",
        data: {action: 'insertSubMod', descripcion: descripcion, modSuper: modSuper, servlet: servlet, link: link, icono: icono, nOrden: nOrden},
        success: function (data) {
            if (data === "EXITO") {
                swal("AVISO DEL SISTEMA!", "Los datos se guardaron exitosamente..!", "success");
                fn_getListSubModulos();
                mostrarformSub(false);
            } else
            {
                swal("AVISO DEL SISTEMA!", data, "error");
            }
        }

    });

}
//FUNCIÓN EDITAR MÓDULO
function fn_dataEditarSubModulo(flag, codigo, desc, servlet, link, icon, orden, mSuper)
{
    $("#codigoSubUpdate").val(codigo);
    $("#descSubUpdate").val(desc);
    $("#servletSubUpdate").val(servlet);
    $("#linkSubUpdate").val(link);
    $("#iconoSubUpdate").val(icon);
    $("#nOrdenSubUpdate").val(orden);
    //$("#moduloSuperInsert").selectpicker('val', mSuper);
    $("#codModuloSuperUpdate").val(mSuper);
    if (flag)
    {
        $("#listarSubModulos").hide();
        $("#formInsertSubModulos").hide();
        $("#formUpdateSubModulos").show();
        $("#btnGuardar").prop("disabled", false);

    } else
    {
        $("#listarSubModulos").show();
        $("#formInsertSubModulos").hide();
        $("#formUpdateSubModulos").hide();
    }
}

function fn_actualizarSubModulo() {
    var codigo = $("#codigoSubUpdate").val();
    var descripcion = $("#descSubUpdate").val();
    var servlet = $("#servletSubUpdate").val();
    var link = $("#linkSubUpdate").val();
    var icono = $("#iconoSubUpdate").val();
    var nOrden = $("#nOrdenSubUpdate").val();
    var modSuper = $("#codModuloSuperUpdate").val();
    var modSuper2 = $("#moduloSuperUpdate").children("#moduloSuperInsert").val();
    $.ajax({
        type: "POST",
        url: "Modulos",
        data: {action: "updateSubMod", codigo: codigo, descripcion: descripcion, servlet: servlet, link: link, icono: icono, nOrden: nOrden, modSuper: modSuper, modSuper2: modSuper2},
        success: function (data) {
            if (data === "EXITO") {
                swal("AVISO DEL SISTEMA!", data, "success");
                fn_getListSubModulos();
                mostrarformSub(false);
            } else
            {
                swal("AVISO DEL SISTEMA!", data, "error");
            }
        }
    });
}

//***** ASIGNAR ROL A MODULO *******//

function buscarmodulo() {
    var busqueda = $("#busqueda").val();
    $.ajax({
        type: "GET",
        url: "RolModuloServlet",
        data: {accion: 'BuscarModulo', valor: busqueda},
        success: function (data) {
            $("#resulbuscar").load("RolModuloServlet?accion=BuscarModulo&valor=" + busqueda);
        }
    });
}

function mostrarbusqueda() {
    var elementos = document.getElementsByName("radio1");
    var cod = null;
    for (var i = 0; i < elementos.length; i++) {
        if (elementos[i].checked) {
            cod = elementos[i].value;
            break;
        }
    }

    if (cod !== null) {

        //alert(cod);
        $.ajax({
            type: "GET",
            url: "RolModuloServlet",
            data: {accion: 'mostrar', cod: cod},
            success: function (data) {
                var dato = data.split("+++");
                $("#codModuloAsig").val(dato[0]);
                $("#descripLargaAsig").val(dato[1]);
                $("#listamodrol").load("RolModuloServlet?accion=mostrarLista&cod=" + dato[0]);
            }
        });
    }
}

function Insertar() {
    var codModulo = $("#codModuloAsig").val();
    var tipoRol = $("#tipoRol").val();
    $.ajax({
        type: "POST",
        url: "RolModuloServlet",
        data: {accion: 'insertar', codModulo: codModulo, tipoRol: tipoRol},
        success: function (data) {
            //alert(data);
            if (data)
                swal("AVISO DEL SISTEMA!", "Se inserto el registro correctamente!", "success");
            $("#listamodrol").html(data);

        }
    });

}

function eliminarRolModulo(a, b) {
    $.ajax({
        type: "post",
        url: "RolModuloServlet",
        data: {accion: 'eliminaRolModulo', codModulo: a, codRol: b},
        success: function (data) {
            if (data)
                swal("AVISO DEL SISTEMA!", "Se elimino el registro correctamente!", "success");
            $("#listamodrol").load("RolModuloServlet?accion=mostrarLista&cod=" + a);
        }

    });
}



// **** END ASIGNAR ROLES A MODULOS ****//

function refrescar(servlet, action) {
    var servletParam = servlet;
    var actionParam = action;
    var $contenidoAjax = $('#contenido').html('<img src="images/loader.gif" style="positon:absolute; margin-top: 25%; margin-left: 50%;">');
    $.ajax({
        type: "Get",
        url: servletParam,
        data: {action: actionParam},
        success: function (data) {
            $contenidoAjax.html(data);
        }
    });
}

init();