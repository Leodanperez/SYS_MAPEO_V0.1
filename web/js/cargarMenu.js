/*FUNCION QUE CARGA LOS MODULOS DE MANERA DINAMICA SIN REFRESCAR LA PAGINA*/

function fn_CargarMenu(servlet, action) {
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
