var firebaseConfig = {
    apiKey: "AIzaSyDoWoF_nRnxCiU4KfSeCznu94FkWn4qdBM",
    authDomain: "with-u-3aee5.firebaseapp.com",
    databaseURL: "https://with-u-3aee5.firebaseio.com",
    projectId: "with-u-3aee5",
    storageBucket: "with-u-3aee5.appspot.com",
    messagingSenderId: "1037609055537",
    appId: "1:1037609055537:web:0529a71f80202600106c10",
    measurementId: "G-NBH21G5WY0"
  };
  // Initialize Firebase
  firebase.initializeApp(firebaseConfig);

//Variables globales
const nombreR = document.getElementById("nombreR");
const correoR = document.getElementById("correoR");
const contrasenaR = document.getElementById("contrasenaR");
const confirmarR = document.getElementById("confirmarR");
const registrarBtn = document.getElementById("registrarBtn");

const database=firebase.database();

//Acción del boton de registrarse
registrarBtn.addEventListener("click",irAPrincipal);

//Entrar a la aplicación
function irAPrincipal(){
    let nombre = nombreR.value;
    let correo = correoR.value;
    let contra = contrasenaR.value;
    let confirmar = confirmarR.value;

    let id =database.ref().child("Usuarios").push().key;
    let usuario=new Usuario(id,nombre,correo,contra);
     

    if(Object.is(contra,confirmar)){
        //Registrar nuevo usuario en la base de datos 
            database.ref().child("Usuarios").child(id).set(usuario);
            window.location.href="iniciarSesion.html";
    }else{
        alert("Las contraseñas no coinciden");
    }


}