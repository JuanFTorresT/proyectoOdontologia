package ondontologia.model;

import java.time.LocalDate;

public class Odontologo extends Persona{
	
	private int id;
	private String especialidad;
	
	public Odontologo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Odontologo(String identificacion, String nombre, String apellido, LocalDate fechaNacimiento,
			String direccion, String celular, String especialidad) {
		super(identificacion, nombre, apellido, fechaNacimiento, direccion, celular);
		this.especialidad = especialidad;
		// TODO Auto-generated constructor stub
	}
	
	public void setId(int id) {
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	
	
}
