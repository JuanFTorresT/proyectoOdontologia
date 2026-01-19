package ondontologia.model;

import java.time.LocalTime;

public class Horario {
	private int idHorario;
	private int idOdontologo;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	
	
	
	public Horario() {
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
