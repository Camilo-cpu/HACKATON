/**
 * Autenticación y presentación de menú para usuarios e invitados.
 */
$(document).ready(function(){
    let usuarioJSON = sessionStorage.getItem("usuario");
    if (usuarioJSON == null){
        estadoInicialInvitado();
    } else {
        let infoUsuario = JSON.parse(usuarioJSON);
        estadoInicialUsuario();
    }
})

let mountains_behind = document.getElementById("mountains_behind");
let text = document.getElementById("text");
let btn = document.getElementById("btn");
let mountains_front = document.getElementById("mountains_front");
let header = document.querySelector("header");

window.addEventListener("scroll", function () {
    let value = window.scrollY;
    text.style.marginRight = value * 4 + "px";
    text.style.marginTop = value * 1.5 + "px";
    btn.style.marginTop = value * 1.5 + "px";
    header.style.top = value * 0.5 + "px";
});

/**
 * Habilitar el modal nuevo registro.
 */
$("#nuevoReporte").click(function(){
    $("#nuevoReporteModal").show();
})

/**
 * Deshabilitar el modal nuevo registro al dar click en la X.
 */
$(".close-modal").click(function(){
    $("#nuevoReporteModal").hide();
})

/**
 * Deshabilitar el modal nuevo registro al dar click en botón Cancelar.
 */
$("#btn-cancelar").click(function(){
    $("#nuevoReporteModal").hide();
})

/**
 * Cerrar sesión.
 */
$("#cerrarSesion").click(function(){
    sessionStorage.removeItem("usuario");
    window.location.href = "ingreso.html";
})

/**
 * Habilita las opciones de "mi cuenta" y "cerrar sesión" en el header. 
 */
function estadoInicialUsuario(){
    $("#indexUsuario").show();
    $("#indexInvitado").hide();
}

/**
 * Habilita las opciones de "iniciar sesión" y "registrarse en el menú"
 */
function estadoInicialInvitado(){
    $("#indexUsuario").hide();
    $("#indexInvitado").show();
}