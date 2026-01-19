package DTOs;

import java.time.LocalTime;

public class HorarioConDoctor {
	int idHorario;
    int idOdontologo;
    String nombreDoctor;
    LocalTime inicio;
    LocalTime fin;
    
    
    
	public HorarioConDoctor() {
	}
	public HorarioConDoctor(int idHorario, int idOdontologo, String nombreDoctor, LocalTime inicio, LocalTime fin) {
		this.idHorario = idHorario;
		this.idOdontologo = idOdontologo;
		this.nombreDoctor = nombreDoctor;
		this.inicio = inicio;
		this.fin = fin;
	}
	public int getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}
	public int getIdOdontologo() {
		return idOdontologo;
	}
	public void setIdOdontologo(int idOdontologo) {
		this.idOdontologo = idOdontologo;
	}
	public String getNombreDoctor() {
		return nombreDoctor;
	}
	public void setNombreDoctor(String nombreDoctor) {
		this.nombreDoctor = nombreDoctor;
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
