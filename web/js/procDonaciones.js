var tabla;

//Función que se ejecuta al inicio
function init() {
    mostrarformSuper(false);
    listar();
    mostrarformSub(false);
    fn_procDonaciones();
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

function fn_listarDonante() {
    
    $("#listDonante").load("DonacionesServlet?action=listDonate");
}


var servlet = 'procesoDonacionServlet';
var link = 'listProcDonaciones';
function fn_procDonaciones() {
    var codEmergencia = $("#CodigoEmergencia").val();
     $.ajax({
        type: 'POST',
        url: "procesoDonacionServlet",
        data: {action: 'insert', codEmergencia: codEmergencia},
        success: function (data) {
            console.log(data);
            if(data === "1"){
                swal("AVISO DEL SISTEMA", "Datos Guardados Correctamente!", "success");
                fn_CargarMenu(servlet, link);
            }else{
                swal("AVISO DEL SISTEMA", "OPPS! Error", "error");
            }
        }
     });
}

var servlet = 'procesoDonacionServlet';
var link = 'listProcDonaciones';
function fn_procVehiculos() {
    var codVehiculo = $("#Ivehiculo").val();
    var codEmergencia = $("#Iemergencia").val();
    var codUnidad = $("#Iunidad").val();
     $.ajax({
        type: 'POST',
        url: "procesoDonacionServlet",
        data: {action: 'procVehiculos', codVehiculo:codVehiculo,codEmergencia: codEmergencia,codUnidad:codUnidad},
        success: function (data) {
            console.log(data);
            if(data === "EXITO"){
                swal("AVISO DEL SISTEMA", "Datos Guardados Correctamente!", "success");
                fn_CargarMenu(servlet, link);
            }else{
                swal("AVISO DEL SISTEMA", "OPPS! Error", "error");
            }
        }
     });
}
init();


