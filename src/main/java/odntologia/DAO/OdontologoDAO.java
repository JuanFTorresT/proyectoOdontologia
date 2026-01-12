package odntologia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ondontologia.model.Conexion;
import ondontologia.model.Horario;
import ondontologia.model.Odontologo;
import ondontologia.model.Usuario;

public class OdontologoDAO {
	
	public boolean registrarOdontologo(Odontologo odontologo) {
			
		String consultaInsert = "INSERT INTO odontologos(identificacion, nombre, apellido, fechaNacimiento, direccion, celular, especialidad) VALUES (?,?,?,?,?,?,?)";
	
	
		try (Connection conexion = Conexion.getConexion();
			 PreparedStatement prst = conexion.prepareStatement(consultaInsert)){
			
			prst.setString(1, odontologo.getIdentificacion());
			prst.setString(2, odontologo.getNombre());
			prst.setString(3, odontologo.getApellido());
			prst.setDate(4, java.sql.Date.valueOf(odontologo.getFechaNacimiento()));
			prst.setString(5, odontologo.getDireccion());
			prst.setString(6, odontologo.getCelular());
			prst.setString(7, odontologo.getEspecialidad());
			
			return prst.executeUpdate() > 0;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error al insertar el registro.");
			return false;
		}
	}
	
	public boolean registrarUsuarioOdontologo(Usuario usuario) {
		
		String consultaInsert = "INSERT INTO usuarios(usuario, contrasena,rol) VALUES (?,?,?)";
	
	
		try (Connection conexion = Conexion.getConexion();
			 PreparedStatement prst = conexion.prepareStatement(consultaInsert)){
			
			prst.setString(1, usuario.getUsuario());
			prst.setString(2, usuario.getContrasena());
			prst.setString(3, usuario.getRol());
			
			return prst.executeUpdate() > 0;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error al insertar el registro.");
			return false;
		}
	}
	
	
	public List<Odontologo> obtenerListaOdontologos(){
		
		List<Odontologo> listaOdontologos = new ArrayList();
		
		String consultaObtenerOdontologos="SELECT * FROM ODONTOLOGOS";
		
		try(Connection conexion = Conexion.getConexion();
			PreparedStatement prst = conexion.prepareStatement(consultaObtenerOdontologos);
				ResultSet rs = prst.executeQuery();){
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(3);
				String apellido = rs.getString(4);
				String identificiacion = rs.getString(2);
				java.sql.Date fechaNacDB = rs.getDate(5);
				LocalDate fechaNacimiento = fechaNacDB.toLocalDate();
				String direccion = rs.getString(6);
				String celular = rs.getString(7);
				String especialidad = rs.getString(8);
				
				
				Odontologo odontologo = new Odontologo(identificiacion, nombre, apellido, fechaNacimiento, direccion, celular, especialidad);
				
				odontologo.setId(id);
				
				
				listaOdontologos.add(odontologo);
			}
			
			return listaOdontologos;
			
		}catch (SQLException e) {
			System.out.println("Error al ejecutar la consulta");
			e.printStackTrace();
			return null;
		}

	}
	
	public boolean asignarHorario(int idOdontologo, Horario horario) {
		String consultaInsert = "INSERT INTO horarios(idOdontologo,horaInicio, horaFin) VALUES (?,?,?)";
		
		
		try (Connection conexion = Conexion.getConexion();
			 PreparedStatement prst = conexion.prepareStatement(consultaInsert)){
			
			prst.setInt(1, idOdontologo);
			prst.setTime(2, java.sql.Time.valueOf(horario.getHoraInicio()));
			prst.setTime(3, java.sql.Time.valueOf(horario.getHoraFin()));
			
			return prst.executeUpdate() > 0;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error al insertar el registro.");
			return false;
		}
	}
	
	
}
