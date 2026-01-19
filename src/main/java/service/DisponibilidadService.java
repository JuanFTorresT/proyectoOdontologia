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

    private static HorarioDAO horarioDAO = new HorarioDAO();
    private static CitaDAO citaDAO = new CitaDAO();

    public static List<BloqueDisponible> obtenerDisponibilidad(LocalDate fecha) {

        List<HorarioConDoctor> horarios = horarioDAO.obtenerHorarios();
        List<Cita> citas = citaDAO.obtenerCitasPorFecha(fecha);

        List<BloqueDisponible> disponibles = new ArrayList<>();

        for (HorarioConDoctor h : horarios) {

            LocalTime inicio = h.getInicio();
            LocalTime fin = h.getFin();

            while (inicio.plusMinutes(45).compareTo(fin) <= 0) {

                LocalTime bloqueFin = inicio.plusMinutes(45);

                boolean ocupado = false;

                for (Cita c : citas) {
                    if (c.getIdOdontologo() == h.getIdOdontologo()
                        && inicio.isBefore(c.getHoraFin())
                        && bloqueFin.isAfter(c.getHoraInicio())) {
                        ocupado = true;
                        break;
                    }
                }

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

                inicio = bloqueFin;
            }
        }

        return disponibles;
    }
}
