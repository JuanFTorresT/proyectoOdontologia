package odntologia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ondontologia.model.Conexion;
import ondontologia.model.Odontologo;
import ondontologia.model.Paciente;

public class PacienteDAO {

	public boolean registrarPaciente(Paciente paciente) {
		
		String consultaInsert = "INSERT INTO pacientes(identificacion, nombre, apellido, fechaNacimiento, direccion, celular, seguro, tipoSangre) VALUES (?,?,?,?,?,?,?,?)";
	
	
		try (Connection conexion = Conexion.getConexion();
			 PreparedStatement prst = conexion.prepareStatement(consultaInsert)){
			
			prst.setString(1, paciente.getIdentificacion());
			prst.setString(2, paciente.getNombre());
			prst.setString(3, paciente.getApellido());
			prst.setDate(4, java.sql.Date.valueOf(paciente.getFechaNacimiento()));
			prst.setString(5, paciente.getDireccion());
			prst.setString(6, paciente.getCelular());
			prst.setBoolean(7, paciente.isTieneSeguro());
			prst.setString(8, paciente.getTipoSangre());
			
			return prst.executeUpdate() > 0;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error al insertar el registro.");
			return false;
		}
	}
	
	public List<Paciente> obtenerListaPacientes(){
		
		List<Paciente> listaPacientes = new ArrayList();
		
		String consultaObtenerPacientes="SELECT * FROM PACIENTES";
		
		try(Connection conexion = Conexion.getConexion();
			PreparedStatement prst = conexion.prepareStatement(consultaObtenerPacientes);
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
				boolean seguro = rs.getBoolean(8);
				String tipoSangre = rs.getString(9);
				
				
				Paciente paciente = new Paciente(identificiacion, nombre, apellido, fechaNacimiento, direccion, celular, seguro, tipoSangre);
				
				paciente.setId(id);
				
				listaPacientes.add(paciente);
			}
			
			return listaPacientes;
			
		}catch (SQLException e) {
			System.out.println("Error al ejecutar la consulta");
			e.printStackTrace();
			return null;
		}
		
		
		
		
	}
	
	public boolean EliminarPaciente(int id){
		
		String consultaObtenerPacientes="DELETE FROM PACIENTES WHERE ID=" + id;
		
		try(Connection conexion = Conexion.getConexion();
			PreparedStatement prst = conexion.prepareStatement(consultaObtenerPacientes);
				){
			prst.executeUpdate();
			
			return true;
			
		}catch (SQLException e) {
			System.out.println("Error al ejecutar la consulta");
			e.printStackTrace();
			return false;
		}	
	}
	
	
}
