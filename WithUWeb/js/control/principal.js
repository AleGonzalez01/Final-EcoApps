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

  //variables del html
const programarBtn = document.getElementById("programarBtn");
const citasBtn = document.getElementById("citasBtn");
//databse y localStorage
const database=firebase.database();
const storage=window.localStorage;
const usuarioActual=storage.getItem("usuarioActual");

//interacción de cada uno de los botones

programarBtn.addEventListener("click",programar);
citasBtn.addEventListener("click",citas);

function programar(){

    //pasar el local Storage
    storage.setItem("usuarioActual",usuarioActual);
    console.log(usuarioActual);
    window.location.href="programarCita.html";
}

function citas(){

    window.location.href="verCitas.html";
}