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

  // variables del html y el local Storage
  const storage=window.localStorage;
  const usuarioActual=storage.getItem("usuarioActual");
  console.log(usuarioActual);
  database = firebase.database();
  const contenedorBase =document.getElementById("contenedorBase");
  
 
  //bajar las citas desde el Firebase
  database.ref().child("Usuarios").child(usuarioActual).child("Citas").on("child_added", function(snapshot){

    citas= snapshot.val();

    //crear los elementos del html

    let lista= document.createElement("li");
    let imagen = document.createElement("img");
    let texto = document.createElement("p");
    let contenedor = document.createElement("div");
    
    
  


    //colocar el nombre y la imagen de cada psicologo
    lista.innerHTML = citas.nombrePsico;
    if(citas.nombrePsico.includes("Antonio")){
      imagen.src = "src/antonio_ruiz.png"
    }
    if(citas.nombrePsico.includes("Carla")){
      imagen.src = "src/carla_sandoval.png"
    }
    if(citas.nombrePsico.includes("Jaime")){
      imagen.src = "src/jaime_ortiz.png"
    }
    if(citas.nombrePsico.includes("Milena")){
      imagen.src = "src/milena_mesa.png"
    }

   //añadir a los elementos del html
    texto.innerText= citas.fecha + " - " + citas.hora;

    lista.appendChild(texto);
    contenedor.appendChild(imagen);
    contenedor.appendChild(lista);
    contenedorBase.appendChild(contenedor);

});
