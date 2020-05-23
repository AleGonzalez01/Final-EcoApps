//Variables globales
const nombreR = document.getElementById("nombreR");
const correoR = document.getElementById("correoR");
const contrasenaR = document.getElementById("contrasenaR");
const confirmarR = document.getElementById("confirmarR");
const registrarBtn = document.getElementById("registrarBtn");

//Acción del boton de registrarse
registrarBtn.addEventListener("click",irAPrincipal);

//Entrar a la aplicación
function irAPrincipal(){

    //let nombre = nombreIT.value;
    //let correo = estudioIT.value;
    //let contrasena = anioIT.value;
    //let id =database.ref().child("juegos").push().key;
    //let nuevoUsuario = new Juego(id, nombre, correo, contrasena); 
    //console.log(nuevoUsuario);
    //REGISTRAR JUEGOS EN UNA RAMA 
    //database.ref().child("juegos").child(id).set(videojuego);

    window.location.href="iniciarSesion.html";

}