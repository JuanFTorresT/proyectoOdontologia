package ondontologia.model;

import java.time.LocalTime;

public class BloqueDisponible {
	private int idOdontologo;
	private String nombreOdontologo;
    private LocalTime inicio;
    private LocalTime fin;
	public BloqueDisponible(int idOdontologo, String nombreOdontologo, LocalTime inicio, LocalTime fin) {
		this.idOdontologo = idOdontologo;
		this.nombreOdontologo = nombreOdontologo;
		this.inicio = inicio;
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

    
}
