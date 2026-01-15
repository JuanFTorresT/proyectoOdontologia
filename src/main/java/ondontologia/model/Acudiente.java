package ondontologia.model;

import java.time.LocalDate;

public class Acudiente extends Persona{
	
	private int idAcudiente;
	private int idPaciente;
	private String parentesco;
	public Acudiente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Acudiente(int idPaciente, String identificacion, String nombre, String apellido, LocalDate fechaNacimiento, String direccion,
			String celular, String parentesco) {
		super(identificacion, nombre, apellido, fechaNacimiento, direccion, celular);
		// TODO Auto-generated const;ructor stub
		this.idPaciente = idPaciente;
		this.parentesco = parentesco;
	}
	
	
	public int getIdAcudiente() {
		return idAcudiente;
	}
	public void setIdAcudiente(int idAcudiente) {
		this.idAcudiente = idAcudiente;
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
