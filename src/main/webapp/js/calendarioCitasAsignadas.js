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



            events: [
                {
                    title: 
						'Juan Felipe Torres Trujillo'+
					 	'\n' +
					  	'Dr. María Camila Jimenéz Ramírez',
                    start: '2026-01-17T09:00',
                    end: '2026-01-17T09:45',
                    color: '#3498db',
                    extendedProps: {
                        paciente: 'Juan Pérez',
                        telefono: '555-1234',
                        doctor: 'Dr. Gómez'
                    }
                },
                {
                    title: 'María López\nDr. Pérez',
                    start: '2026-01-17T09:00',
                    end: '2026-01-17T09:45',
                    color: '#9b59b6',
                    extendedProps: {
                        paciente: 'María López',
                        telefono: '555-9876',
                        doctor: 'Dr. Pérez'
                    }
                }
            ],

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