
//BOTONES VER/EDITAR ACUDIENTE
const btnActivarEdicionAcudiente = document.getElementById("activarEdicionAcudiente");
const btneditarAcudiente = document.getElementById("btnConfirmarEdicion");

//INPUTS ACUDIENTE
const inputNombreAcudiente = document.getElementById("verEditarNombreAcudiente");
const inputApellidoAcudiente = document.getElementById("verEditarApellidoAcudiente");
const inputIdentificacionAcudiente = document.getElementById("verEditarIdentificacionAcudiente");
const inputFechaNacimientoAcudiente = document.getElementById("verEditarFechaNacimientoAcudiente");
const inputDireccionAcudiente = document.getElementById("verEditarDireccionAcudiente");
const inputCelularAcudiente = document.getElementById("verEditarCelularAcudiente");
const inputParentescoAcudiente = document.getElementById("verEditarParentescoAcudiente");


btnActivarEdicionAcudiente.addEventListener('click', ()=>{
	
	console.log("evento activado");
	btneditarAcudiente.disabled=false;
	
	inputNombreAcudiente.disabled=false;
	inputApellidoAcudiente.disabled=false;
	inputIdentificacionAcudiente.disabled=false;
	inputFechaNacimientoAcudiente.disabled=false;
	inputDireccionAcudiente.disabled=false;
	inputCelularAcudiente.disabled=false;
	inputParentescoAcudiente.disabled=false;
})