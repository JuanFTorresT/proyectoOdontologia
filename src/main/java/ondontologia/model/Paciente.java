package ondontologia.model;

import java.time.LocalDate;

public class Paciente extends Persona{

	private int id;
	private boolean tieneSeguro;
	private String tipoSangre;
	
	public Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Paciente(String identificacion, String nombre, String apellido, LocalDate fechaNacimiento, String direccion,
			String celular, boolean tieneSeguro, String tipoSangre) {
		super(identificacion, nombre, apellido, fechaNacimiento, direccion, celular);
		this.tieneSeguro = tieneSeguro;
		this.tipoSangre = tipoSangre;
	}
	
	public void setId(int id) {
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public boolean isTieneSeguro() {
		return tieneSeguro;
	}

	public void setTieneSeguro(boolean tieneSeguro) {
		this.tieneSeguro = tieneSeguro;
	}

	public String getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}
	
	
	
	
	
	
	
	
	
	
	
}
