/**
 * Presentación de información de usuario.
 */
$(document).ready(function(){
    let usuarioJSON = sessionStorage.getItem("usuario");
    let infoUsuario = JSON.parse(usuarioJSON);
    mostrarDatosUsuario(infoUsuario);
    cargarDatosActualizar(infoUsuario);
})

/**
 * Muestra los datos del usuario en el espacio "Tus datos"
 * @param {Object} infoUsuario la información del usuario.
 */
function mostrarDatosUsuario(infoUsuario){
    $("#nombre-usuario").html(infoUsuario.nombre);
    $("#email-usuario").html(infoUsuario.email);
}

function cargarDatosActualizar(infoUsuario){
    $("#nombre_usuario").val(infoUsuario.nombre);
    $("#email_usuario").val(infoUsuario.email);
    $("#user_usuario").val(infoUsuario.usuario);
    $("#password_usuario").val(infoUsuario.contrasena);
    $("#password_check").val(infoUsuario.contrasena);
}

/**
 * Habilitar el modal nuevo registro.
 */
$("#nuevoReporteUser").click(function(){
    $("#nuevoReporteModal").show();
})

/**
 * Habilitar el modal actualizar.
 */
 $("#btn-actualizar").click(function(){
    $("#actualizarModal").show();
})

/**
 * Habilitar el modal eliminar.
 */
$("#btn-eliminar").click(function(){
    $("#eliminarModal").show();
})

/**
 * Deshabilitar el modal nuevo registro y actualizar al dar click en la X.
 */
$(".close-modal").click(function(){
    $("#nuevoReporteModal").hide();
    $("#actualizarModal").hide();
    $("#eliminarModal").hide()
})

/**
 * Deshabilitar el modal nuevo registro al dar click en botón Cancelar.
 */
$("#btn-cancelar").click(function(){
    $("#nuevoReporteModal").hide();
})

/**
 * Deshabilitar el modal actualizar al dar click en botón Cancelar.
 */
 $("#btn-cancelar-actu").click(function(){
    $("#actualizarModal").hide();
})

/**
 * Deshabilitar el modal eliminar al dar click en botón Cancelar.
 */
 $("#btn-cancelar-eliminar").click(function(){
    $("#eliminarModal").hide();
})

/**
 * Cerrar sesión.
 */
$("#cerrarSesionUser").click(function(){
    sessionStorage.removeItem("usuario");
    window.location.href = "index.html";
})


