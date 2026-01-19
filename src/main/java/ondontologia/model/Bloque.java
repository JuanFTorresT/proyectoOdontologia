package ondontologia.model;

import java.time.LocalTime;

public class Bloque {

	private LocalTime inicio;
	private LocalTime fin;
	private int idOdontologo;
	private String nombreOdontologo;
	
	public Bloque(LocalTime inicio, LocalTime fin, int idOdontologo, String nombreOdontologo) {
		this.inicio = inicio;
		this.fin = fin;
		this.idOdontologo = idOdontologo;
		this.nombreOdontologo = nombreOdontologo;
	}

	public LocalTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalTime inicio) {
		this.inicio = inicio;
	}

	public LocalTime getFin() {
		return fin;
	}

	public void setFin(LocalTime fin) {
		this.fin = fin;
	}

	public int getIdOdontologo() {
		return idOdontologo;
	}

	public void setIdOdontologo(int idOdontologo) {
		this.idOdontologo = idOdontologo;
	}

	public String getNombreOdontologo() {
		return nombreOdontologo;
	}

	public void setNombreOdontologo(String nombreOdontologo) {
		this.nombreOdontologo = nombreOdontologo;
	}
	
	
	
}
