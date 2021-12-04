/**
 * Autor: J. Sebastián Beltrán S.
 * Creado: 23/11/2021
 */
 $(document).ready(function(){
     /**
      * Añadir focus en el campo nombre.
      */
     $("#nombre_usuario").focus();
    /**
     * Prevenir acción por defecto al presionar botón "Ingresar"
     */
    $("#form_registro").on('submit', function(event){
        event.preventDefault();
        if (validarCamposRegistro()){
            validarExistenciaUsuario();
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
 * Registar un nuevo usuario en la base de datos.
 */
function registrarUsuario(){
    /**
     * Recuperación datos ingresados
     */
    let datosUsuario = {
        name: $("#nombre_usuario").val(),
        email: $("#email_usuario").val(),
        password: $("#password_usuario").val()
    }
    /**
     * Conversión a formato JSON.
     */

    let datosEnvio = JSON.stringify(datosUsuario);
    /**
     * Registrar el usuario a través de una petición POST.
     */
    $.ajax({
        url:"http://140.238.179.6:8081/api/user/new",
        method:'POST',
        data: datosEnvio,
        dataType:'json',
        contentType: 'application/JSON',
        success:function(response){
            Swal.fire({
                icon: 'success',
                title: '¡Cuenta registrada!',
                text: 'Cuenta registrada con éxito. Bienvenido a bordo, ' + response.name,
                footer: '<a href="ingreso.html">Inicia sesión aquí</a>'
            });
            limpiarCamposRegistro();
        }
    });
}

/**
 * Valida si el email ingresado ya existe en la base de datos. Si no, ejecuta registrarUsuario().
 */
function validarExistenciaUsuario(){
    $.ajax({
        url:"http://140.238.179.6:8081/api/user/"+$("#email_usuario").val(),
        method:'GET',
        dataType:'json',
        contentType: 'application/JSON',
        success:function(response){
            // mostrar aviso de existencia de usuario
            if (response){
                Swal.fire({
                    icon: 'warning',
                    title: 'Cuenta existente',
                    text: 'Ya existe una cuenta con el email ingresado.',
                    footer: '<a href="ingreso.html">Inicia sesión aquí</a>'
                })
            } else {
                registrarUsuario();
            }
        }
    });
}

/**
 * Valida que las contraseñas ingresadas coincidan.
 * @returns true si las contraseñas coinciden; false si no coinciden.
 */
function validarContrasenas(){
    var statusCoincidencia = false;

    if ($("#password_usuario").val().trim() === $("#password_check").val().trim() &&
        $("#password_usuario").val().trim() != ""){
        $("#error_password_check").html("");
        $("#password_check").css("border", "2px solid green");

        //Mostrar ícono éxito
        $("#i_error_pswrd_check").css("opacity", "0");
        $("#i_exito_pswrd_check").css("opacity", "1");

        // Cambiar estado de validación
        statusCoincidencia = true;
    } else {
        $("#error_password_check").html("Las contraseñas no coinciden.");
        $("#password_check").css("border", "2px solid red");

        //Mostrar ícono fracaso
        $("#i_error_pswrd_check").css("opacity", "1");
        $("#i_exito_pswrd_check").css("opacity", "0");

        // Cambiar estado de validación
        statusCoincidencia = false;
    }

    return statusCoincidencia;
}

/**
 * Valida que todos los campos contengan información.
 * @returns true si todos los campos son válidos; false en cualquier otro escenario.
 */
function validarCamposRegistro(){
    /**
     * Variables para controlar la validación de los campos.
     */
    var statusEmail = false;
    var statusNombre = false;
    var statusPassword = false;
    var statusCheckPswrd = false;
    var statusCoincidenciaPswrd = false;

    /**
     * Validar campo nombre
     */
     if ($("#nombre_usuario").val().trim()==""){
        $("#error_nombre").html("El nombre no puede estar en blanco.");
        $("#nombre_usuario").css("border", "2px solid red");

        //Mostrar ícono error
        $("#i_error_nombre").css("opacity", "1");
        $("#i_exito_nombre").css("opacity", "0");

        // Cambiar estado de validación
        statusNombre = false;
    } else {
        $("#error_nombre").html("");
        $("#nombre_usuario").css("border", "2px solid green");

        //Mostrar ícono éxito
        $("#i_error_nombre").css("opacity", "0");
        $("#i_exito_nombre").css("opacity", "1");

        // Cambiar estado de validación
        statusNombre = true;
    }
    
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
        statusEmail = true;
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
        statusPassword = false;
    } else {
        $("#error_password").html("");
        $("#password_usuario").css("border", "2px solid green");

        //Mostrar ícono error
        $("#i_error_pswrd").css("opacity", "0");
        $("#i_exito_pswrd").css("opacity", "1");

        // Cambiar estado de validación
        statusPassword = true;
    }

    /**
     * Validar campo password check
     */
    if ($("#password_check").val().trim()==""){
        $("#error_password_check").html("La confirmación no puede estar en blanco.");
        $("#password_check").css("border", "2px solid red");

        //Mostrar ícono error
        $("#i_error_pswrd_check").css("opacity", "1");
        $("#i_exito_pswrd_check").css("opacity", "0");

        // Cambiar estado de validación
        statusCheckPswrd = false;
    } else {
        $("#error_password_check").html("");
        $("#password_check").css("border", "2px solid green");

        //Mostrar ícono error
        $("#i_error_pswrd_check").css("opacity", "0");
        $("#i_exito_pswrd_check").css("opacity", "1");

        // Cambiar estado de validación
        statusCheckPswrd = true;
    }

    /**
     * Validar que las contraseñas coincidan.
     */
    statusCoincidenciaPswrd = validarContrasenas()

    return (statusNombre && statusEmail && statusPassword && statusCheckPswrd && statusCoincidenciaPswrd);
}

/**
 * Limpia los campos del formulario.
 */
 function limpiarCamposRegistro(){
    $("#nombre_usuario").val("");
    $("#nombre_usuario").css("border", "2px solid #c4c4c4");
    // Ocultar íconos
    $("#i_error_nombre").css("opacity", "0");
    $("#i_exito_nombre").css("opacity", "0");

    $("#email_usuario").val("");
    $("#email_usuario").css("border", "2px solid #c4c4c4");
    // Ocultar íconos
    $("#i_error_email").css("opacity", "0");
    $("#i_exito_email").css("opacity", "0");

    $("#password_usuario").val("");
    $("#password_usuario").css("border", "2px solid #c4c4c4");
    // Ocultar íconos
    $("#i_error_pswrd").css("opacity", "0");
    $("#i_exito_pswrd").css("opacity", "0");

    $("#password_check").val("");
    $("#password_check").css("border", "2px solid #c4c4c4");
    // Ocultar íconos
    $("#i_error_pswrd_check").css("opacity", "0");
    $("#i_exito_pswrd_check").css("opacity", "0");

    $("#nombre_usuario").focus();
}