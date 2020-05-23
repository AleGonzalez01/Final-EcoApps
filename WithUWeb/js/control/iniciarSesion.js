//Variables globales
const correoIS = document.getElementById("correoIS");
const contrasenaIS = document.getElementById("contrasenaIS");
const iniciarBtn = document.getElementById("iniciarBtn");

//Acción del boton de registrarse
iniciarBtn.addEventListener("click",irAPrincipal);

//Entrar a la aplicación
function irAPrincipal(){
    window.location.href="principal.html";
}