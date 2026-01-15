package odntologia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ondontologia.model.Acudiente;
import ondontologia.model.Conexion;


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
}
