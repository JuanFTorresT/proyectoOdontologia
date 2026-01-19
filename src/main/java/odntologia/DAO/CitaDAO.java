package odntologia.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ondontologia.model.Cita;
import ondontologia.model.Conexion;

public class CitaDAO {
	public List<Cita> obtenerCitasPorFecha(LocalDate fecha) {

        List<Cita> lista = new ArrayList<>();

        String sql = "SELECT * FROM cita WHERE fecha = ? AND atendida = false";

        try (Connection con = Conexion.getConexion();
             PreparedStatement prst = con.prepareStatement(sql)) {

            prst.setDate(1, Date.valueOf(fecha));
            ResultSet rs = prst.executeQuery();

            while (rs.next()) {
                Cita c = new Cita();
                c.setIdOdontologo(rs.getInt("id_odontologo"));
                c.setFecha(rs.getDate("fecha").toLocalDate());
                c.setHoraInicio(rs.getTime("hora_inicio").toLocalTime());
                c.setHoraFin(rs.getTime("hora_fin").toLocalTime());
                lista.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
