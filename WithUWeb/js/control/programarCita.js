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

  const storage=window.localStorage;
  const usuarioActual=storage.getItem("usuarioActual");
  console.log(usuarioActual);
  database = firebase.database();
  const contenedorBase =document.getElementById("contenedorBase");
  
 
  database.ref().child("Psicologos").on("child_added", function(snapshot){

    psicologo= snapshot.val();

    let lista= document.createElement("li");
    let imagen = document.createElement("img");
    let boton = document.createElement("button");
    let texto = document.createElement("p");
    let contenedor = document.createElement("div");
    
    
  

    lista.innerHTML = psicologo.nombre+ "   "+ psicologo.apellido;
    if(psicologo.nombre.includes("Antonio")){
      imagen.src = "src/antonio_ruiz.png"
    }
    if(psicologo.nombre.includes("Carla")){
      imagen.src = "src/carla_sandoval.png"
    }
    if(psicologo.nombre.includes("Jaime")){
      imagen.src = "src/jaime_ortiz.png"
    }
    if(psicologo.nombre.includes("Milena")){
      imagen.src = "src/milena_mesa.png"
    }

    boton.innerHTML = "ver más";
    boton.id = psicologo.nombre + " "+psicologo.apellido;
    boton.addEventListener("click", function(){

      storage.setItem("psico", boton.id);
      storage.setItem("usuarioActual", usuarioActual );

      console.log(boton.id);
      window.location.href="doctor.html";

    })
    texto.innerText= "Agenda cita ahora";

    lista.appendChild(texto);
    contenedor.appendChild(imagen);
    contenedor.appendChild(lista);
    contenedor.appendChild(boton);
    contenedorBase.appendChild(contenedor);
    console.log(psicologo);
});



