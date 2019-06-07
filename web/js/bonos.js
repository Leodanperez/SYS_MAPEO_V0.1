//Mostrar imagen cargando

function cargarBonoMesServlet() {
    //Añadimos la imagen de carga en el contenedor
    var $contenidoAjax = $('#div_cargando').html('<div class="loading"><img src="../../images/loader.gif" alt="loading"/></div>');
    $.ajax({
        type: "POST",
        url: "../../SubirBonoMesServlet",
        data: {action: 'subirArchivo'},
        success: function (data) {
            //Cargamos finalmente el contenido deseado
           // $contenidoAjax.html(data);
           //alert(data);
           $contenidoAjax.html(data);
        }
    });
}


