var tabla;

//Función que se ejecuta al inicio
function init() {
    mostrarformSuper(false);
    listar();
    mostrarformSub(false);
    fn_listarDonante();
    fn_comboDonantes();
    fn_comboTipoDoc();
    fn_updateDonante();
}

//Función limpiar
function limpiar()
{
    $("input[type='text']").val("");
}

//Función Listar
function listar()
{
    $("#listadoDonaciones").show();
    $("#listarDonantes").show();
}

//Función mostrar formulario
function mostrarformSuper(flag)
{
    limpiar();
    if (flag)
    {
        $("#listadoDonaciones").hide();
        $("#formInsertDonaciones").show();
        $("#btnGuardar").prop("disabled", false);
        $("#formUpdateDonaciones").hide();
    } else
    {
        $("#listadoDonaciones").show();
        $("#formInsertDonaciones").hide();
        $("#formUpdateDonaciones").hide();
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
        $("#listarDonantes").hide();
        $("#formInsertDonantes").show();
        $("#btnGuardar").prop("disabled", false);
        $("#formUpdateDonantes").hide();
    } else
    {
        $("#listarDonantes").show();
        $("#formInsertDonantes").hide();
        $("#btnGuardar").prop("disabled", false);
        $("#formUpdateDonantes").hide();
    }
}

function cancelarformSub()
{
    limpiar();
    mostrarformSub(false);
    listar();
}

//FUNCION PARA INSERTAR REGISTRO DE DONACIONES
var servlet = 'DonacionesServlet';
var link = 'listarDonacion';
function fn_registrarDonaciones() {
    var origen = $("#Inorigen").val();
    var fechadona = $("#Infecha").val();
    var coddonante = $("#IncodDona").val();
    var codunidad = $("#Inunidad").val();
    var pesototal = $("#Inpeso").val();
    var vtotal = $("#Involumen").val();
    var cip = $("#Incip").val();
    var recepcion = $("#Inrecep").val();
    var movimiento = $("#Inmov").val();
    var entrada = $("#Inentrada").val();
    $.ajax({
        type: "POST",
        url: "DonacionesServlet",
        data: {modo: 'insertar', origen: origen, fechadona: fechadona, coddonante: coddonante, codunidad: codunidad, pesototal: pesototal, vtotal: vtotal, cip: cip, recepcion: recepcion, movimiento: movimiento, entrada: entrada},
        success: function (data) {
            if (data === "EXITO") {
                swal("AVISO DEL SISTEMA", "Datos Guardados Correctamente!", "success");
                fn_CargarMenu(servlet, link);
            } else
            {
                swal("AVISO DEL SISTEMA", "OPPS! Error", "error");
            }
        }
    });
}

function fn_showDonaciones(flag, codigo, origen, fecha, donante, unidad, petotal, voltotal,cip,recepcion,movimiento,entrada){
    $("#codDonacion").val(codigo);
    $("#origenDonacion").val(origen);
    $("#fechaDonacion").val(fecha);
    $("#codDonaDonacion").val(donante);
    $("#unidadDonacion").val(unidad);
    $("#pesoDonacion").val(petotal);
    $("#volumenDonacion").val(voltotal);
    $("#cipDonacion").val(cip);
    $("#recepDonacion").val(recepcion);
    $("#movDonacion").val(movimiento);
    $("#entradaDonacion").val(entrada);
    if (flag){
        $("#listadoDonaciones").hide();
        $("#formInsertDonaciones").hide();
        $("#formUpdateDonaciones").show();
        $("#btnGuardar").prop("disabled", false);
        $("#btnagregar").hide();
    }else{
        $("#listadoDonaciones").show();
        $("#formInsertDonaciones").hide();
        $("#formUpdateDonaciones").hide();
    }
}

function fn_updateDonaciones(){
    var codigo = ("#codDonacion").val();
    var origen = ("#origenDonacion").val();
    var fecha = ("#fechaDonacion").val();
    var coddonante = ("#codDonaDonacion").val();
    var unidad = ("#unidadDonacion").val();
    var peso = ("#pesoDonacion").val();
    var volumen = ("#volumenDonacion").val();
    var cip = ("#cipDonacion").val();
    var recepcion = ("#recepDonacion").val();
    var movimiento = ("#movDonacion").val();
    var entrada = ("#entradaDonacion").val();
    
    $.ajax({
        type: 'POST',
        url: "DonacionesServlet",
        data: {action: 'update', codigo: codigo, origen: origen, fecha: fecha, coddonante: coddonante, unidad: unidad, peso: peso, volumen: volumen, cip: cip, recepcion: recepcion, movimiento: movimiento, entrada: entrada},
        success: function (data) {
            if (data === "EXITO") {
                swal("AVISO DEL SISTEMA", "Datos Guardados Correctamente!", "success");
                fn_CargarMenu(servlet, link);
            }else{
                swal("AVISO DEL SISTEMA", "OPPS! Error", "error");
            }
        }
    });
}

//FUNCION PARA ELIMINAR DONACIONES
function fn_deleteDonaciones(codDonaciones){
    $.ajax({
        type: 'POST',
        url: "DonacionesServlet",
        data: {action: 'delete', codigoU: codDonaciones},
        success: function (data) {
            if (data === "EXITO") {
                swal("AVISO DEL SISTEMA", "Datos Eliminados Correctamente", "success");
            }else{
                swal("AVISO DEL SISTEMA", "Error al eliminar", "error");
            }
            fn_CargarMenu(servlet, link);
        }
    });
}

//FUNCION PARA INSERTAR DONANTE
var servlet = 'DonacionesServlet';
var link = 'listDonate';
function fn_registrarDonante() {
    var name = $("#nameDonante").val();
    var telefono = $("#phoneDonante").val();
    var email = $("#emailDonante").val();
    var tipodoc = $("#comboTipoDocumento").val();
    var nrodoc = $("#nroDocDonante").val();
    $.ajax({
        type: 'POST',
        url: "DonacionesServlet",
        data: {action: 'insertDonante', name: name, telefono: telefono, email: email, tipodoc: tipodoc, nrodoc: nrodoc},
        success: function (data) {
            if (data === "EXITO") {
                swal("AVISO DEL SISTEMA", "Datos Guardados Correctamente!", "success");
                console.log(data);
                fn_CargarMenu(servlet, link);
            } else {
                swal("AVISO DEL SISTEMA", "OPPS! Error", "error");
                $("#nameDonante").val("");
                $("#phoneDonante").val("");
                $("#emailDonante").val("");
                $("#comboTipoDocumento").val("");
                $("#nroDocDonante").val("");
                $("#nameDonante").focus();
            }
        }
    });
}
function fn_datosUpdateDonante(flag, codigo, nombre, telefono, email, tipodoc, document){
    $("#UpcodigoDonante").val(codigo);
    $("#UpnameDonante").val(nombre);
    $("#UpphoneDonante").val(telefono);
    $("#UpemailDonante").val(email);
    $("#comboTipoDocumento").val(tipodoc);
    $("#UpdatenroDocDonante").val(document);
    if (flag) {
        $("#listarDonantes").hide();
        $("#formInsertDonantes").hide();
        $("#formUpdateDonantes").show();
        $("#btnGuardar").prop("disabled", false);
        $("#btnagregar").hide();
    }else{
        $("#listarDonantes").show();
        $("#formInsertDonantes").hide();
        $("#formUpdateDonantes").hide();
    }
}

function fn_updateDonante(){
    var codigo = ("#UpcodigoDonante").val();
    var nombre = ("#UpnameDonante").val();
    var telefono = ("#UpphoneDonante").val();
    var email = ("#UpemailDonante").val();
    var tipodoc = ("#UptipoDocDonante").val();
    var nrodoc = ("#UpnroDocDonante").val();
    
    $.ajax({
        type: 'POST',
        url: "DonacionesServlet",
        data: {action: 'updateDonante', codigo: codigo, nombre: nombre, telefono: telefono, email: email, tipodoc: tipodoc, nrodoc: nrodoc},
        success: function (data) {
            if (data === "EXITO") {
                swal("AVISO DEL SISTEMA", "Datos Guardados Correctamente!", "success");
                fn_CargarMenu(servlet, link);
            }else{
                swal("AVISO DEL SISTEMA", "OPPS! Error", "error");
            }
        }
    });
}

function  fn_deleteDonante(codDonante){
    $.ajax({
        type: 'POST',
        url: "DonacionesServlet",
        data: {action: 'deleteDonante', codigoU: codDonante},
        success: function (data) {
            if (data === "EXITO") {
                swal("AVISO DEL SISTEMA","Datos Eliminados Correctamente","success");
            }
            else{
                swal("AVISO DEL SISTEMA","Error al Eliminar","error");
            }
            fn_CargarMenu(servlet, link);
        }
    });
}

function fn_comboDonantes(){
    $("#comboDonante").load("DonacionesServlet?action=comboDonantes");
}

function fn_comboTipoDoc(){
    $("#comboTipoDocumento").load("DonacionesServlet?action=combotipoDoc");
    $("#comboTipoDocumentoUpdate").load("DonacionesServlet?action=combotipoDoc");
}

function fn_listarDonante() {
    
    $("#listDonante").load("DonacionesServlet?action=listDonate");
}
init();