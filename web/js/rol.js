var tabla;

//Función que se ejecuta al inicio
function init() {
    mostrarform(false);
    listar();
    
       $("#formulario").on("submit", function (e)
    {
        guardaryeditar(e);
    });
    
}

function limpiar()
{
    $("input[type='text']").val("");  
}

//Función mostrar formulario
function mostrarform(flag, modo)
{
    if (flag)
    {
        $("#listaRoles").hide();
        $("#formInsertarRoles").show();
        $("#btnGuardar").prop("disabled", false);
        $("#btnagregar").hide();
        $("#formActualizaRoles").hide();
        $("#modo").val(modo);
    } else
    {
        $("#listaRoles").show();
        $("#formInsertarRoles").hide();
        $("#btnagregar").show();
        $("#formActualizaRoles").hide();
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
    $("#listaRoles").show();
}

//FUNCION PARA INSERTAR REGISTRO DE ROLES
function fn_registrarRoles() {
    var descripcionCorta = $("#descripcionCorta").val();
    var descripcionLarga = $("#descripcionLarga").val();
    $.ajax({
        type: "POST",
        url: "roles",
        data: {action: 'insertarRoles', descripcionCorta: descripcionCorta, descripcionLarga: descripcionLarga},
        success: function (data) {
            if (data === "DATOS CON EXITOS") {
                //Mostramos mensaje 
                swal("SIPLAE", data, "success");
                $("#listaRoles").show();
                $("#formInsertarRoles").hide();
                $("#formActualizaRoles").hide();
                $("#btnGuardar").prop("disabled", false);
                $("#btnagregar").hide();
               $("#listaRoles").load("roles?action=verRoles");
                //$("#listaRoles").load("roles?action=listaRoles");
            }
            else 
            {
                swal("SIPLAE", data, "error");
            }
        }

    });

}

//FUNCION PARA CARGAR VENTANA DE EDICION DE ROLES
function fn_EditarRegistro(codigo) {
    $.ajax({
        type: "GET",
        url: "roles",
        data: {action: 'indRoles', codigo: codigo},
        success: function (data) {
            var dato = data.split("+++");
            if (dato.length === 4) {
                $("#codRolAct").val(dato[0]);
                $("#descCortaAct").val(dato[1]);
                $("#descLargaAct").val(dato[2]);
                $("#formActualizaRoles").show();
                $("#listaRoles").hide();
            }
        }
    });

}

//FUNCIÓN PARA ACTUALIZAR ROLES
function fn_actualizarRoles(){
    var codRolAct = $("#codRolAct").val();
    var desCortaAct = $("#descCortaAct").val();
    var desLargaAct = $("#descLargaAct").val();
    $.ajax({
        type: "POST",
        url: "roles",
        data:{codigoRol:codRolAct, descripcionCorta:desCortaAct, descripcionLarga:desLargaAct},
        success: function(data){
            if(data === "SE ACTUALIZO CORRECTAMENTE"){
                swal("SIPLAE",data,"success");
                $("#listaRoles").show();
                $("#formInsertarRoles").hide();
                $("#formActualizaRoles").hide();
                $("#btnGuardar").prop("disabled", false);
                $("#btnagregar").hide();
            }
            else
            {
                swal("SIPLAE",data,"error");
            }
        }
    });
}


init();