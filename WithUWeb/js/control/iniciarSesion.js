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
const correoIS = document.getElementById("correoIS");
const contrasenaIS = document.getElementById("contrasenaIS");
const iniciarBtn = document.getElementById("iniciarBtn");

const database=firebase.database();
const storage=window.localStorage;

//Acción del boton de registrarse
iniciarBtn.addEventListener("click",irAPrincipal);

//Iniciar sesión
function irAPrincipal(){
    let correo=correoIS.value;
    let clave=contrasenaIS.value;

    busqueda=database.ref().child("Usuarios").orderByChild("correo").equalTo(correo);

    //Verificar si el usuario se encuentra registrado
    busqueda.once("value",function(snapshot){
        let usuarioEncontrado=null;
        snapshot.forEach(coincidencia => {
            usuarioEncontrado = coincidencia.val();
          });

          //Mostrar alerta si el usuario no está registrado
          if(usuarioEncontrado==null){
              alert("Correo no registrado");
          }
          //verificar si la contraseña es correcta
          if(usuarioEncontrado.contrasena==clave){
            storage.setItem("usuarioActual",usuarioEncontrado);
            window.location.href="principal.html";
          }else{
              alert("La contraseña está equivocada");
          }
    })
    
}