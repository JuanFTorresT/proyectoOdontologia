package ondontologia.model;

import java.time.LocalTime;

public class Horario {
	private int idHorario;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	
	
	
	public Horario() {
	}



	public Horario(LocalTime horaInicio, LocalTime horaFin) {
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}



	public int getIdHorario() {
		return idHorario;
	}



	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}



	public LocalTime getHoraInicio() {
		return horaInicio;
	}



	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}



	public LocalTime getHoraFin() {
		return horaFin;
	}



	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}
	
	
	
	
}
