package service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import DTOs.HorarioConDoctor;
import odntologia.DAO.CitaDAO;
import odntologia.DAO.HorarioDAO;
import ondontologia.model.BloqueDisponible;
import ondontologia.model.Cita;
import ondontologia.model.Horario;

public class DisponibilidadService {

	//se crea un objeto DAO de horario y de cita
    private static HorarioDAO horarioDAO = new HorarioDAO();
    private static CitaDAO citaDAO = new CitaDAO();

    //obtener disponibilidad devuelve una lsita de bloques disponibles en la fecha que recibe por parametros, que en este caso sería hoy. tener en cuenta que
    // a cada vuelta del bucle while la fecha va pasar al dia siguiente, de esta forma se va a obtener la disponibilidad de cada día hasta llegar al día 15.
    public static List<BloqueDisponible> obtenerDisponibilidad(LocalDate fecha) {

    	//se crea una lista de los horarios asignados y estos horarios incluyen el nombre del doctor al que le pertenecen
        List<HorarioConDoctor> horarios = horarioDAO.obtenerHorarios();
        
        //se crea una lista de las citas de la fecha que se pasa por parametros que no han sido atendidas 
        List<Cita> citas = citaDAO.obtenerCitasPorFecha(fecha);

        //Se crea una lista de bloques disponibles para agregar ahí los bloques que están libres.
        List<BloqueDisponible> disponibles = new ArrayList<>();

        //vamos a iterar cada horario encontrado
        for (HorarioConDoctor h : horarios) {

        	//inicio va a ser igual a la hora de inicio del horario del odontologo
            LocalTime inicio = h.getInicio();
            
          //fin va a ser igual a la hora de fin del horario del odontologo
            LocalTime fin = h.getFin();

            //mientras que inicio + 45 minutos comparado con la hora de fin sea -1 o 0 quiere decir que inicio es antes que el fin
            //ejemplo el horario del odontologo empieza a las 8:00am y termina a las 12:00pm
            //8:00 + 45 = 8:45. es menor a 12:00 por lo que se cumple la condicion entonces se entra al while.
            while (inicio.plusMinutes(45).compareTo(fin) <= 0) {

            	//Se establece la hora final del bloque o de la cita, que tiene una duracion de 45 minutos.
                LocalTime bloqueFin = inicio.plusMinutes(45);

                boolean ocupado = false;

                //por cada cita encontrada en la lista de citas se va a hacer lo siguiente
                for (Cita c : citas) {
                	//si el id del ondontologo en la cita es igual al id del odontologo en el horario
                	// y la hora de inicio es antes de la hora final de la cita 
                	// y la hora final de la cita es despues de la hora de inicio de la cita
                	// entonces el bloque va a estar ocupado, sino se va a mantener desocupado
                    if (c.getIdOdontologo() == h.getIdOdontologo()
                        && inicio.isBefore(c.getHoraFin())
                        && bloqueFin.isAfter(c.getHoraInicio())) {
                        ocupado = true;
                        break;
                    }
                }

                //si ocupado es falso entonces a la lista de bloques disponibles se va a agregar un bloque disponible nuevo con el id del odontologo, el nombre la hora de inicio y la de fin
                if (!ocupado) {
                    disponibles.add(
                        new BloqueDisponible(
                            h.getIdOdontologo(),
                            h.getNombreDoctor(), // NUEVO
                            inicio,
                            bloqueFin
                        )
                    );
                }

                //ahora la hora de inicio es la hora anterior +45 minutos.
                inicio = bloqueFin;
            }
        }

        return disponibles;
    }
}
