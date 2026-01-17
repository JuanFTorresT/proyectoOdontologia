$('#verEditarAcudienteModal').on('show.bs.modal', function(event) {
    var button = $(event.relatedTarget);
    var idPacienteReferencia = button.data('id');

    $('#idPaciente').val(idPacienteReferencia);

    $.ajax({
        url: 'VerEditarAcudienteServlet',
        type: 'GET',
        data: {
            action: 'buscarPorId',
            id: idPacienteReferencia
        },
        dataType: 'json',
        success: function(acudiente) {
            $('input[name="verEditarIdAcudiente"]').val(acudiente.id);
            $('input[name="verEditarNombreAcudiente"]').val(acudiente.nombre);
            $('input[name="verEditarApellidoAcudiente"]').val(acudiente.apellido);
            $('input[name="verEditarIdentificacionAcudiente"]').val(acudiente.identificacion);
            $('input[name="verEditarFechaNacimientoAcudiente"]').val(acudiente.fechaNacimiento); // yyyy-MM-dd
            $('input[name="verEditarDireccionAcudiente"]').val(acudiente.direccion);
            $('input[name="verEditarCelularAcudiente"]').val(acudiente.celular);
            $('input[name="verEditarParentescoAcudiente"]').val(acudiente.parentesco);

        },
        error: function(xhr, status, error){
            console.error("Error al cargar acudiente:", error);
            alert('Error al cargar acudiente');
        }
    });
	
});
