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

  //Variables del localStorage - Recibiendolas
  const storage=window.localStorage;
  const usuarioActual=storage.getItem("usuarioActual");
  const psicologo = storage.getItem("psico");
  console.log(psicologo);
  console.log(usuarioActual);

  //database
  database = firebase.database();


  // variables del html
  const vaLaFoto= document.getElementById("vaLaFoto");
  const contenido = document.getElementById("contenido");
  const hora = document.getElementById("hora");
  const programarCitaBtn = document.getElementById("programarCitaBtn");
  


  //creamos una imagen para el html y la ponemos según el psicólogo
  let imagen = document.createElement("img");
  if(psicologo.includes("Antonio")){
    imagen.src = "src/Ellipse 34.png"
  }
  if(psicologo.includes("Carla")){
    imagen.src = "src/Ellipse 33.png"
  }
  if(psicologo.includes("Jaime")){
    imagen.src = "src/Ellipse 32.png"
  }
  if(psicologo.includes("Milena")){
    imagen.src = "src/Ellipse 31.png"
  }

  //agregar la imagen al html
  vaLaFoto.appendChild(imagen);

  //creamos el nombre del psicólogo para el html con nuestra variable del local Storage
  let nombre = document.createElement("h3");
  nombre.innerText = psicologo;



  //creamos y randomizamos la hora de inicio de cada cita
  let tiempoCita = document.createElement("p");

  //hora random
  minHora = Math.ceil(7);
  maxHora = Math.floor(18);
  let horare = Math.floor(Math.random() * (maxHora - minHora + 1)) + minHora;

  //minuto random
  minMinuto= Math.ceil(10);
  maxMinuto = Math.floor(59);
  let minu = Math.floor(Math.random() * (maxMinuto - minMinuto + 1)) + minMinuto;

  //condicionales para Pm, Am
  if(horare<=11){
    tiempoAsignado=horare+":"+minu+" A.M";
}else{
    tiempoAsignado=horare+":"+minu+" P.M";
}

//Variable con la hora y los minutos de la cita
tiempoCita.innerText= tiempoAsignado;

//creamos y randomizamos el día de inicio de cada cita
let diaCita = document.createElement("h6");

//numero de día ramdomizado
mindia = Math.ceil(1);
maxdia = Math.floor(30);
let diasre = Math.floor(Math.random() * (maxdia - mindia + 1)) + mindia;

//numero de mes ramdomizado
minmes = Math.ceil(6);
maxmes = Math.floor(9);
let meses = Math.floor(Math.random() * (maxmes - minmes + 1)) + minmes;


//fecha en Visual
const d = new Date('2020'+-meses+"-"+diasre);
const ye = new Intl.DateTimeFormat('en', { year: 'numeric' }).format(d)
const mo = new Intl.DateTimeFormat('en', { month: 'short' }).format(d)
const da = new Intl.DateTimeFormat('en', { day: '2-digit' }).format(d)

//variable de la fecha
fechaAsignada = `${da}/${mo}/${ye}`;

diaCita.innerText= fechaAsignada;

//agragar todo al html
contenido.appendChild(nombre);
hora.appendChild(tiempoCita);
hora.appendChild(diaCita);


//interacción del botón
programarCitaBtn.addEventListener("click", function(){
    storage.setItem("usuarioActual", usuarioActual );
    


    let id =database.ref().child("Usuarios").child("Citas").push().key;
    let citaNueva=new Cita(id,fechaAsignada,tiempoAsignado,psicologo);
    database.ref().child("Usuarios").child(usuarioActual).child("Citas").child(id).set(citaNueva);

    window.location.href="verCitas.html";

})


