package ondontologia.model;

import java.time.LocalDate;

public class Acudiente extends Persona{
	
	private int idPaciente;
	private String parentesco;
	public Acudiente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Acudiente(String identificacion, String nombre, String apellido, LocalDate fechaNacimiento, String direccion,
			String celular, String parentesco) {
		super(identificacion, nombre, apellido, fechaNacimiento, direccion, celular);
		// TODO Auto-generated constructor stub
		this.parentesco = parentesco;
	}
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getParentesco() {
		return parentesco;
	}
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	
	
	
	
	
	
}
