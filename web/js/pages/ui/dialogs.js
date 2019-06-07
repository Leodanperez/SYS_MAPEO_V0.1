$(function () {
    $('.js-sweetalert button').on('click', function () {
        var type = $(this).data('type');
        if (type === 'basic') {
            showBasicMessage();
        }
        else if (type === 'with-title') {
            showWithTitleMessage();
        }
        else if (type === 'success') {
            showSuccessMessage();
        }
        else if (type === 'confirm') {
            showConfirmMessage();
        }
        else if (type === 'exit') {
            showExitMessage();
        }
        else if (type === 'cancel') {
            showCancelMessage();
        }
        else if (type === 'with-custom-icon') {
            showWithCustomIconMessage();
        }
        else if (type === 'html-message') {
            showHtmlMessage();
        }
        else if (type === 'autoclose-timer') {
            showAutoCloseTimerMessage();
        }
        else if (type === 'prompt') {
            showPromptMessage();
        }
        else if (type === 'ajax-loader') {
            showAjaxLoaderMessage();
        }
    });
});

//These codes takes from http://t4t5.github.io/sweetalert/
function showBasicMessage() {
    swal("Este es un Mensaje!");
}

function showWithTitleMessage() {
    swal("¡Aquí hay un mensaje! "," Es bonito, ¿no?");
}

function showSuccessMessage() {
    swal("Buen Trabajo!", "Has clic en el boton!", "success");
}

function showConfirmMessage() {
    swal({
        title: "¿Estás seguro?",
        text: "¡No podrás recuperar este registro!",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "Sí, eliminarlo!",
        closeOnConfirm: false
    }, function () {
        swal("¡Eliminado!", "El registro ha sido eliminado.", "success");
    });
}

function showExitMessage() {
    swal({
        title: "¿Desea salir del Sistema?",
        text: "Se perderan procesos en ejecuciòn",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "Sí, Salir!",
        closeOnConfirm: false
    }, function () {
        swal("¡Hasta la pròxima!", "Se ha salido exitosamente", "success");
    });
}

function showCancelMessage() {
    swal({
        title: "¿Estás seguro?",
        text: "¡No podrás recuperar este archivo imaginario!",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "Sí, eliminarlo!",
        cancelButtonText: "No, cancela plx!",
        closeOnConfirm: false,
        closeOnCancel: false
    }, function (isConfirm) {
        if (isConfirm) {
            swal("¡Eliminado!", "Tu archivo imaginario ha sido eliminado.", "success");
        } else {
            swal("Cancelado", "Tu archivo imaginario es seguro :)", "error");
        }
    });
}

function showWithCustomIconMessage() {
    swal({
        title: "¡Dulce!",
        text: "Aquí hay una imagen personalizada.",
        imageUrl: "../../images/thumbs-up.png"
    });
}

function showHtmlMessage() {
    swal({
        title: "HTML <small>Title</small>!",
        text: "A custom <span style=\"color: #CC0000\">html<span> message.",
        html: true
    });
}

function showAutoCloseTimerMessage() {
    swal({
        title: "Alerta de cierre automático!",
        text: "Cerraré en 2 segundos.",
        timer: 2000,
        showConfirmButton: false
    });
}

function showPromptMessage() {
    swal({
        title: "Una entrada!",
        text: "Escribe algo interesante:",
        type: "input",
        showCancelButton: true,
        closeOnConfirm: false,
        animation: "slide-from-top",
        inputPlaceholder: "Escribe algo.."
    }, function (inputValue) {
        if (inputValue === false) return false;
        if (inputValue === "") {
            swal.showInputError("¡Tienes que escribir algo!"); return false
        }
        swal("¡Agradable!", "Usted escribió:" + inputValue, "success");
    });
}

function showAjaxLoaderMessage() {
    swal({
        title:"Ejemplo de solicitud de Ajax",
        text:"Enviar para ejecutar una solicitud ajax",
        type: "info",
        showCancelButton: true,
        closeOnConfirm: false,
        showLoaderOnConfirm: true,
    }, function () {
        setTimeout(function () {
            swal("¡La solicitud de Ajax terminó!");
        }, 2000);
    });
}