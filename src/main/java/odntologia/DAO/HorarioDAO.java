package odntologia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTOs.HorarioConDoctor;
import ondontologia.model.Conexion;

public class HorarioDAO {

    public List<HorarioConDoctor> obtenerHorarios() {

        List<HorarioConDoctor> listaHorarios = new ArrayList<>();

        String sql = "SELECT h.idHorario, h.idOdontologo, h.horaInicio, h.horaFin, " +
                     "o.nombre, o.apellido " +
                     "FROM horarios h " +
                     "JOIN odontologos o ON o.idOdontologo = h.idOdontologo";

        try (Connection conexion = Conexion.getConexion();
             PreparedStatement prst = conexion.prepareStatement(sql);
             ResultSet rs = prst.executeQuery()) {

            while (rs.next()) {
                HorarioConDoctor h = new HorarioConDoctor();

                h.setIdHorario(rs.getInt("idHorario"));
                h.setIdOdontologo(rs.getInt("idOdontologo"));

                // CORRECTO:
                h.setInicio(rs.getTime("horaInicio").toLocalTime());
                h.setFin(rs.getTime("horaFin").toLocalTime());

                // NOMBRE DEL DOCTOR (nombre + apellido)
                h.setNombreDoctor(rs.getString("nombre") + " " + rs.getString("apellido"));

                listaHorarios.add(h);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaHorarios;
    }
}
