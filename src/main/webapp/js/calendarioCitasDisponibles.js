document.addEventListener('DOMContentLoaded', function() {

    var calendar = new FullCalendar.Calendar(
        document.getElementById('calendar'),
        {
			allDaySlot: false,
			slotDuration: '00:45:00',
			height: 'auto',
			locale: 'es',
			
			buttonText: {
			  today: 'Hoy',
			  month: 'Mes',
			  week: 'Semana',
			  day: 'Día'
			},
			  
            customButtons: {
                myCustomButton: {
                    text: 'Asignar cita',
                    click: function() {
						window.location.href = 'citasDisponibles.jsp'
                    }
                }
            },
			
			headerToolbar: {
			    left: 'prev,next today myCustomButton',
			    center: 'title',
			    right: 'dayGridMonth,timeGridWeek,timeGridDay'
			},



			events: function(info, success, failure) {
			  const hoy = new Date();
			  const fin = new Date();
			  fin.setDate(hoy.getDate() + 15);

			  const start = hoy.toISOString().slice(0, 10);
			  const end = fin.toISOString().slice(0, 10);

			  fetch('disponibilidad?start=' + start + '&end=' + end)
			    .then(r => r.json())
			    .then(data => success(data))
			    .catch(err => failure(err));
			},



            eventClick: function(info) {
				// Esto aún no está conectado con los resultados.
                var e = info.event;

                document.getElementById('mPaciente').innerText =
                    e.extendedProps.paciente;

                document.getElementById('mTelefono').innerText =
                    e.extendedProps.telefono;

                document.getElementById('mDoctor').innerText =
                    e.extendedProps.doctor;
					
                document.getElementById('fechaCita').innerText =
                    e.start.toLocaleDateString('es-CO',{
						year: 'numeric',
						month: 'long',
						day: 'numeric'
					});
					
                document.getElementById('horaCita').innerText =
                    e.start.toLocaleTimeString('es-CO',{
						hour: '2-digit',
						minute: '2-digit'
					});
				

                $('#modalCita').modal('show');
                
            }
        }
    );

    calendar.render();
});