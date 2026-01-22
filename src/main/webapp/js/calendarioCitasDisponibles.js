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
				//crea la fecha de hoy
			  const hoy = new Date();
			  //crea la fecha final que va a ser la fecha de hoy + 15 días, o sea dentro de 15
			  const fin = new Date();
			  fin.setDate(hoy.getDate() + 15);

			  // se formatea la fecha a YYYY-MM-DD
			  const start = hoy.toISOString().slice(0, 10);
			  const end = fin.toISOString().slice(0, 10);

			  //fetch hace una solicitud HTTP get al servelt y le pasa como parametros la fecha de inicio y la fecha de finalizacion y 
			  // se empieza a ejecutar el metodo get del servlet para devolver una respuesta "r"
			  fetch('DisponibilidadServlet?start=' + start + '&end=' + end)
				// r es la respuesta que le envía el servlet a fetch y luego la transforma el JSON en un objeto js
			    .then(r => r.json())
				// data es el resultado del r.json, ahora data ya es un objeto js y no solo texto
				// succes es una funcion callback del FullCaledar que recibe la data la procesa y la renderiza.
			    .then(data => success(data))
				/*
				* Captura cualquier error
				*	- fallo en la red
				*	- Error al convertir JSON
				*	- excpecion en uno de los .then 
				*
				*Notifica el error
				*/
			    .catch(err => failure(err));
			},



            eventClick: function(info) {
				
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