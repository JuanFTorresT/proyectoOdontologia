package ondontologia.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {
	private int idCita;
	private int idOdontologo;
	private int idpaciente;
	private LocalDate fecha;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private boolean atendida;
	public int getIdCita() {
		return idCita;
	}
	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}
	public int getIdOdontologo() {
		return idOdontologo;
	}
	public void setIdOdontologo(int idOdontologo) {
		this.idOdontologo = idOdontologo;
	}
	public int getIdpaciente() {
		return idpaciente;
	}
	public void setIdpaciente(int idpaciente) {
		this.idpaciente = idpaciente;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
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
	public boolean isAtendida() {
		return atendida;
	}
	public void setAtendida(boolean atendida) {
		this.atendida = atendida;
	}
	
	
	
	
}
