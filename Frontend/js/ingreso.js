/**
 * Autor: J. Sebastián Beltrán S.
 * Creado: 23/11/2021
 */
$(document).ready(function(){
    /**
     * Añadir focus a campo email.
     */
    $("#email_usuario").focus();
    /**
     * Prevenir acción por defecto al presionar botón "Ingresar"
     */
    $("#form_ingreso").on('submit', function(event){
        event.preventDefault();
        if (validarCamposIngreso()){
            iniciarSesion();
        } else {
            Swal.fire({
                icon: 'warning',
                title: '¡Ups!',
                text: 'Llena todos los campos antes de continuar.'
            })
        }
})

})

/**
 * Autenticación del usuario a través de petición GET.
 */
function iniciarSesion(){
    // Validar que los campos tengan contenido antes de iniciar sesión.
    if (validarCamposIngreso()){
        // Recuperar valores formulario
        let emailUsuario = $("#email_usuario").val();
        let pswrdUsuario = $("#password_usuario").val();

        // Autenticar usuario
        $.ajax({
            url: "http://140.238.179.6:8081/api/user/"+emailUsuario+"/"+pswrdUsuario,
            method:'GET',
            dataType:'json',
            contentType: 'application/JSON',
            success:function(response){
                mostrarAlerta(response);
                limpiarCamposIngreso();
            }
        });
    }
}

/**
 * Muestra en pantalla un mensaje de éxito o de error en la autenticación del usuario.
 * @param {User} data el resultado de la petición GET para autenticar (Objeto User)
 */
function mostrarAlerta(data){
    // Fracaso al autenticar
    if (data.id == null){
        Swal.fire({
            icon: 'warning',
            title: '¡Ups!',
            text: 'No existe usuario registrado con esas credenciales. Inténtalo de nuevo.',
            footer: '<a href="registro.html">¿No tienes una cuenta? Crea una aquí</a>'
        })
    } 
    // Éxito al autenticar
    else {
        Swal.fire({
            icon: 'success',
            title: 'Ingreso exitoso',
            text: '¡Bienvenido, '+data.name+'!'
        })
    }
}

/**
 * Valida que todos los campos contengan información.
 * @returns true si todos los campos son válidos; false en cualquier otro escenario.
 */
function validarCamposIngreso(){
    /**
     * Variables para controlar la validación de los campos.
     */
    var statusEmail = false;
    var statusPassword = false;

    /**
     * Validar campo email
     */
    if ($("#email_usuario").val().trim()==""){
        $("#error_email").html("El correo electrónico no puede estar en blanco.");
        $("#email_usuario").css("border", "2px solid red");

        //Mostrar ícono error
        $("#i_error_email").css("opacity", "1");
        $("#i_exito_email").css("opacity", "0");
        
        // Cambiar estado de validación
        statusEmail = false;
    } else {
        $("#error_email").html("");
        $("#email_usuario").css("border", "2px solid green");

        //Mostrar ícono éxito
        $("#i_error_email").css("opacity", "0");
        $("#i_exito_email").css("opacity", "1");

        // Cambiar estado de validación
        statusEmail=true;
    }

    /**
     * Validar campo password
     */
    if ($("#password_usuario").val().trim()==""){
        $("#error_password").html("La contraseña no puede estar en blanco.");
        $("#password_usuario").css("border", "2px solid red");

        //Mostrar ícono error
        $("#i_error_pswrd").css("opacity", "1");
        $("#i_exito_pswrd").css("opacity", "0");
        
        // Cambiar estado de validación
        statusPassword=false;
    } else {
        $("#error_password").html("");
        $("#password_usuario").css("border", "2px solid green");

        //Mostrar ícono error
        $("#i_error_pswrd").css("opacity", "0");
        $("#i_exito_pswrd").css("opacity", "1");

        // Cambiar estado de validación
        statusPassword=true;
    }

    /**
     * Retorna true si todos los campos son válidos; false si alguno no es válido.
     */
    return (statusEmail&&statusPassword);
}

/**
 * Limpia los campos del formulario.
 */
function limpiarCamposIngreso(){
    $("#email_usuario").val("");
    $("#email_usuario").css("border", "2px solid #c4c4c4");
    //Ocultar íconos
    $("#i_error_email").css("opacity", "0");
    $("#i_exito_email").css("opacity", "0");
    
    $("#password_usuario").val("");
    $("#password_usuario").css("border", "2px solid #c4c4c4");
    //Ocultar íconos
    $("#i_error_pswrd").css("opacity", "0");
    $("#i_exito_pswrd").css("opacity", "0");

    $("#email_usuario").focus();
}