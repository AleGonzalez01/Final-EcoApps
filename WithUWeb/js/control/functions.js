const iniciarBtn = document.getElementById("iniciarBtn");
const registrarseBtn = document.getElementById("registrarseBtn");

//iniciación de varibles
iniciarBtn.addEventListener("click",iniciarSesion);
registrarseBtn.addEventListener("click",registrarse);
//interacción botón de iniciar Sesión
function iniciarSesion(){
    window.location.href="iniciarSesion.html";
}
//interacción botón de iniciar Sesión
function registrarse(){
    window.location.href="registro.html";
}