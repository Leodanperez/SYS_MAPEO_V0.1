var tabla;

//Función que se ejecuta al inicio
function init() {
    mostrarformSuper(false);
    listar();
    mostrarformSub(false);
    fn_ListtVehiculos();
}

//Función limpiar
function limpiar()
{
    $("input[type='text']").val("");
}

//Función Listar
function listar()
{
    $("#listadoVehiculos").show();
    $("#listarTipoVehiculo").show();
}

//Función mostrar formulario
function mostrarformSuper(flag)
{
    limpiar();
    if (flag)
    {
        $("#listadoVehiculos").hide();
        $("#formInsertVehiculos").show();
        $("#btnGuardar").prop("disabled", false);
        $("#formUpdateVehiculos").hide();
    } else
    {
        $("#listadoVehiculos").show();
        $("#formInsertVehiculos").hide();
        $("#formUpdateVehiculos").hide();
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
        $("#listarTipoVehiculo").hide();
        $("#formInsertSubModulos").show();
        $("#btnGuardar").prop("disabled", false);
        $("#formUpdateSubModulos").hide();
    } else
    {
        $("#listarTipoVehiculo").show();
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

//FUNCION PARA INSERTAR REGISTRO DE TIPO VEHICULOS
var servlet = 'VehiculosServlet';
var link = 'listtVehiculos';
function fn_registrartVehiculos() {
    var description = $("#idescripcion").val();
    var cantidad = $("#icantidad").val();
    
    $.ajax({
        type: 'POST',
        url: "VehiculosServlet",
        data: {action: 'insertar', description: description, cantidad: cantidad},
        success: function (data) {
            //alert(data);
            if(data === "EXITO"){
                swal("AVISO DEL SISTEMA", "Datos Guardados Correctamente!", "success");
                fn_CargarMenu(servlet, link);
            }else{
                swal("AVISO DEL SISTEMA", "OPPS! Error", "error");
            }
        }
    });
}

function fn_ListtVehiculos()
{
    $("#listTipoVehiculo").load("VehiculosServlet?action=listTipovehiculo");
}

//FUNCION UPDATE TIPO VEHICULO
function fn_datosUpdatetVehiculo(flag, codigo, descripcion, cantidad) {
    $("#codtVehiculoUp").val(codigo);
    $("#descripcionUp").val(descripcion);
    $("#cantidadUp").val(cantidad);
    if(flag){
        $("#listarTipoVehiculo").hide();
        $("#formInsertSubModulos").hide();
        $("#formUpdateSubModulos").show();
        $("#btnGuardar").prop("disabled", false);
        $("#btnagregar").hide();
    }else{
        $("#listarTipoVehiculo").show();
        $("#formInsertSubModulos").hide();
        $("#formUpdateSubModulos").hide();
    }
}
function fn_updatetVehiculo() {
    var codigo = $("#codtVehiculoUp").val();
    var descripcion = $("#descripcionUp").val();
    var cantidad = $("#cantidadUp").val();
    var estado = $("#estadoUp").val();
    
    $.ajax({
        type: 'POST',
        url: "VehiculosServlet",
        data: {action: 'update', codigo: codigo, deripcscion: descripcion, cantidad: cantidad, estado:estado},
        success: function (data) {
            if(data === "EXITO"){
                swal("AVISO DEL SISTEMA", "Datos actualizados correctamente", "success");
                fn_CargarMenu(servlet, link);
            }else{
                swal("AVISO DEL SISTEMA", data, "OPPSS Error!", "error");
            }
        }
    });
}

//FUNCTION ELIMINAR TVEHICULO
function fn_eliminartVehiculo(codtVehiculo) {
    $.ajax({
        type: 'POST',
        url: "VehiculosServlet",
        data: {action: 'delete', codigoU: codtVehiculo},
        success: function (data) {
            if(data === "EXITO"){
                swal("AVISO DEL SISTEMA", "Datos Eliminados Correctamente", "success");
            }else{
                swal("AVISO DEL SISTEMA", "Error al Eliminar", "error");
            }
            fn_CargarMenu(servlet, link);
        }
    });
}

//FUNCION PARA INSERTAR REGISTRO DE VEHICULOS
var servlet = 'VehiculosServlet';
var link = 'listtVehiculos';
function fn_insertVehiculos() {
    var InpesoNeto = $("#InpesoNeto").val();
    var Involumen = $("#Involumen").val();
    var Intvehiculo = $("#Intvehiculo").val();
    var Inplaca = $("#Inplaca").val();
    var InpesBruto = $("#InpesBruto").val();
    var InCarga = $("#InCarga").val();
    
    $.ajax({
        type: 'POST',
        url: "VehiculosServlet",
        data: {action: 'inservehiculo', InpesoNeto: InpesoNeto, Involumen: Involumen, Intvehiculo: Intvehiculo, Inplaca: Inplaca, InpesBruto: InpesBruto, InCarga: InCarga},
        success: function (data) {
            //alert(data);
            if(data === "EXITO"){
                swal("AVISO DEL SISTEMA", "Datos Guardados Correctamente!", "success");
                fn_CargarMenu(servlet, link);
            }else{
                swal("AVISO DEL SISTEMA", "OPPS! Error", "error");
            }
        }
    });
}

//FUNCION UPDATE VEHICULO
function fn_datosUpdateVehiculos(flag, codigo, pesoneto, volumen, codtvehiculo, placa, pesobrut, cpcarga) {
    $("#uCodvehiculo").val(codigo);
    $("#uPesoneto").val(pesoneto);
    $("#uVolumen").val(volumen);
    $("#uTipvehiculo").val(codtvehiculo);
    $("#uPlaca").val(placa);
    $("#uPesobruto").val(pesobrut);
    $("#uCapcarga").val(cpcarga);
    if(flag){
        $("#listadoVehiculos").hide();
        $("#formInsertVehiculos").hide();
        $("#formUpdateVehiculos").show();
        $("#btnGuardar").prop("disabled", false);
        $("#btnagregar").hide();
    }else{
        $("#listadoVehiculos").show();
        $("#formInsertVehiculos").hide();
        $("#formUpdateVehiculos").hide();
    }
}

function fn_updateVehiculos() {
    var Ucodigo = $("#uCodvehiculo").val();
    var Upesoneto = $("#uPesoneto").val();
    var Uvolumen = $("#uVolumen").val();
    var Utipovehiculo = $("#uTipvehiculo").val();
    var Uplaca = $("#uPlaca").val();
    var Uestado = $("#upEstado").val();
    var Upesobruto = $("#uPesobruto").val();
    var Ucarga = $("#uCapcarga").val();
    
    $.ajax({
        type: 'POST',
        url: "VehiculosServlet",
        data: {action: 'updatevehiculo', Ucodigo: Ucodigo, Upesoneto: Upesoneto, Uvolumen: Uvolumen, Utipovehiculo: Utipovehiculo, Uplaca: Uplaca, Uestado: Uestado, Upesobruto: Upesobruto, Ucarga: Ucarga },
        success: function (data) {
            if(data === "EXITO"){
                swal("AVISO DEL SISTEMA", "Datos actualizados correctamente", "success");
                fn_CargarMenu(servlet, link);
            }else{
                swal("AVISO DEL SISTEMA", data, "OPPSS Error!", "error");
            }
        }
    });
}

//FUNCTION ELIMINAR TVEHICULO
function fn_deleteVehiculo(codVehiculo) {
    $.ajax({
        type: 'POST',
        url: "VehiculosServlet",
        data: {action: 'deletevehiculo', codigoU: codVehiculo},
        success: function (data) {
            if(data === "EXITO"){
                swal("AVISO DEL SISTEMA", "Datos Eliminados Correctamente", "success");
            }else{
                swal("AVISO DEL SISTEMA", "Error al Eliminar", "error");
            }
            fn_CargarMenu(servlet, link);
        }
    });
}
init();