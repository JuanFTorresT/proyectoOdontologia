package ondontologia.model;

import java.time.LocalDate;

public class Secretario extends Persona{
	
	private int id;
	private String sector;
	
	public Secretario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Secretario(String identificacion, String nombre, String apellido, LocalDate fechaNacimiento,
			String direccion, String celular, String sector) {
		super(identificacion, nombre, apellido, fechaNacimiento, direccion, celular);
		this.sector = sector;
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}
	
	
	
}
