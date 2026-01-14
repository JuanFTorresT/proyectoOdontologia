$('#editarPacienteModal').on('show.bs.modal', function(event) {
    var button = $(event.relatedTarget);
    var idPaciente = button.data('id');

    console.log("Paciente ID:", idPaciente);

    $.ajax({
        url: 'EditarPacienteServlet',
        type: 'GET',
        data: {
            action: 'buscarPorId',
            id: idPaciente
        },
        dataType: 'json',
        success: function(paciente) {
            $('input[name="idEditarPaciente"]').val(paciente.id);
            $('input[name="editarNombrePaciente"]').val(paciente.nombre);
            $('input[name="editarApellidoPaciente"]').val(paciente.apellido);
            $('input[name="editarIdentificacionPaciente"]').val(paciente.identificacion);
            $('input[name="editarFechaNacimientoPaciente"]').val(paciente.fechaNacimiento); // yyyy-MM-dd
            $('input[name="editarDireccionPaciente"]').val(paciente.direccion);
            $('input[name="editarCelularPaciente"]').val(paciente.celular);
            $('input[name="editarSeguro"]').prop('checked', paciente.seguro);
            $('select[name="editarTipoSangre"]').val(paciente.tipoSangre);
        },
        error: function(xhr, status, error){
            console.error("Error al cargar paciente:", error);
            alert('Error al cargar paciente');
        }
    });
});
