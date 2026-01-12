const fechaNacimiento = document.getElementById("fechaNacimientoPaciente");
const formularioAcudiente = document.getElementById("datosAcudiente");

fechaNacimiento.addEventListener("change", function () {
	
  const fechaNac = new Date(this.value);
  
  const hoy = new Date();


  let edad = hoy.getFullYear() - fechaNac.getFullYear();
  const mes = hoy.getMonth() - fechaNac.getMonth();

  if (mes < 0 || (mes === 0 && hoy.getDate() < fechaNac.getDate())) {
	
    edad--;
	
  }

  if (edad < 18) {
	
    formularioAcudiente.style.display = "block";
	
  } else {
	
    formularioAcudiente.style.display = "none";
  }
  
});