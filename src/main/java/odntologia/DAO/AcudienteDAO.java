package odntologia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import ondontologia.model.Acudiente;
import ondontologia.model.Conexion;
import ondontologia.model.Paciente;



public class AcudienteDAO {
	
public boolean registrarAcudiente(Acudiente acudiente) {
		
		String consultaInsert = "INSERT INTO acudientes(idPaciente, identificacion, nombre, apellido, fechaNacimiento, direccion, celular, parentesco) VALUES (?,?,?,?,?,?,?,?)";
	
	
		try (Connection conexion = Conexion.getConexion();
			 PreparedStatement prst = conexion.prepareStatement(consultaInsert)){
			
			prst.setInt(1, acudiente.getIdPaciente());
			prst.setString(2, acudiente.getIdentificacion());
			prst.setString(3, acudiente.getNombre());
			prst.setString(4, acudiente.getApellido());
			prst.setDate(5, java.sql.Date.valueOf(acudiente.getFechaNacimiento()));
			prst.setString(6, acudiente.getDireccion());
			prst.setString(7, acudiente.getCelular());
			prst.setString(8, acudiente.getParentesco());
			
			return prst.executeUpdate() > 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error al insertar el registro.");
			return false;
		}
	}


	public Acudiente buscarPorId(int idBuscar) {
	
	String consultaObtenerPacientes="SELECT * FROM ACUDIENTES WHERE idPaciente=" + idBuscar;
	
	try(Connection conexion = Conexion.getConexion();
		PreparedStatement prst = conexion.prepareStatement(consultaObtenerPacientes);
			ResultSet rs = prst.executeQuery();){
		
		Acudiente acudiente=null;
		
		while(rs.next()) {
			
			int idAcudiente = rs.getInt(1);
			int idPaciente = rs.getInt(2);
			String nombre = rs.getString(4);
			String apellido = rs.getString(5);
			String identificiacion = rs.getString(3);
			java.sql.Date fechaNacDB = rs.getDate(6);
			LocalDate fechaNacimiento = fechaNacDB.toLocalDate();
			String direccion = rs.getString(7);
			String celular = rs.getString(8);
			String parentesco = rs.getString(9);
			
			
			acudiente = new Acudiente(idPaciente, identificiacion, nombre, apellido, fechaNacimiento, direccion, celular, parentesco);
			
			acudiente.setIdAcudiente(idAcudiente);
			
		}
		return acudiente;
		
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	
	}
	
	public boolean editarAcudiente(Acudiente acudiente) {
		
		String consultaInsert = "UPDATE acudientes SET identificacion=?,nombre=?,apellido=?,fechaNacimiento=?,direccion=?,celular=?,parentesco=? WHERE idPaciente=" + acudiente.getIdPaciente();
		
		try (Connection conexion = Conexion.getConexion();
			 PreparedStatement prst = conexion.prepareStatement(consultaInsert)){
			
			prst.setString(1, acudiente.getIdentificacion());
			prst.setString(2, acudiente.getNombre());
			prst.setString(3, acudiente.getApellido());
			prst.setDate(4, java.sql.Date.valueOf(acudiente.getFechaNacimiento()));
			prst.setString(5, acudiente.getDireccion());
			prst.setString(6, acudiente.getCelular());
			prst.setString(7, acudiente.getParentesco());
			
			return prst.executeUpdate() > 0;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error al actualizar el registro.");
			return false;
		}
		
	}


}


