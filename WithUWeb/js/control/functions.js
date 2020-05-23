const iniciarBtn = document.getElementById("iniciarBtn");
const registrarseBtn = document.getElementById("registrarseBtn");

iniciarBtn.addEventListener("click",iniciarSesion);
registrarseBtn.addEventListener("click",registrarse);

function iniciarSesion(){
    window.location.href="iniciarSesion.html";
}

function registrarse(){
    window.location.href="registro.html";
}