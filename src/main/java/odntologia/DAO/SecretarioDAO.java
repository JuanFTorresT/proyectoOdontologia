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
import ondontologia.model.Odontologo;
import ondontologia.model.Secretario;
import ondontologia.model.Usuario;

public class SecretarioDAO {
	
	public boolean registrarSecretario(Secretario secretario) {
			
			String consultaInsert = "INSERT INTO secretarios(identificacion, nombre, apellido, fechaNacimiento, direccion, celular, sector) VALUES (?,?,?,?,?,?,?)";
		
		
			try (Connection conexion = Conexion.getConexion();
				 PreparedStatement prst = conexion.prepareStatement(consultaInsert)){
				
				prst.setString(1, secretario.getIdentificacion());
				prst.setString(2, secretario.getNombre());
				prst.setString(3, secretario.getApellido());
				prst.setDate(4, java.sql.Date.valueOf(secretario.getFechaNacimiento()));
				prst.setString(5, secretario.getDireccion());
				prst.setString(6, secretario.getCelular());
				prst.setString(7, secretario.getSector());
				
				return prst.executeUpdate() > 0;
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error al insertar el registro.");
				return false;
			}
	}
	
	public boolean registrarUsuarioSecretario(Usuario usuario) {
		
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
	
	public List<Secretario> obtenerListaSecretarios(){
		
		List<Secretario> listaSecretarios = new ArrayList();
		
		String consultaObtenerSecretarios="SELECT * FROM SECRETARIOS";
		
		try(Connection conexion = Conexion.getConexion();
			PreparedStatement prst = conexion.prepareStatement(consultaObtenerSecretarios);
				ResultSet rs = prst.executeQuery();){
			
			while(rs.next()) {
				String nombre = rs.getString(3);
				String apellido = rs.getString(4);
				String identificiacion = rs.getString(2);
				java.sql.Date fechaNacDB = rs.getDate(5);
				LocalDate fechaNacimiento = fechaNacDB.toLocalDate();
				String direccion = rs.getString(6);
				String celular = rs.getString(7);
				String sector = rs.getString(8);
				
				
				Secretario secretario = new Secretario(identificiacion, nombre, apellido, fechaNacimiento, direccion, celular, sector);
				listaSecretarios.add(secretario);
			}
			
			return listaSecretarios;
			
		}catch (SQLException e) {
			System.out.println("Error al ejecutar la consulta");
			e.printStackTrace();
			return null;
		}
		
	}
	
	

}
