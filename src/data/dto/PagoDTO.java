package data.dto;

import java.io.Serializable;

public class PagoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String tipo;
	private double precio;
	private String paypalEmail;
	private String tarjetaNumero;
	private String tarjetaTipo;
	private String tarjetaFechaCaducidad;
	private ReservaDTO reserva;
	
	public PagoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getTarjetaFechaCaducidad() {
		return tarjetaFechaCaducidad;
	}
	public void setTarjetaFechaCaducidad(String tarjetaFechaCaducidad) {
		this.tarjetaFechaCaducidad = tarjetaFechaCaducidad;
	}
	public ReservaDTO getReserva() {
		return reserva;
	}
	public void setReserva(ReservaDTO reserva) {
		this.reserva = reserva;
	}
	public String getTarjetaTipo() {
		return tarjetaTipo;
	}
	public void setTarjetaTipo(String tarjetaTipo) {
		this.tarjetaTipo = tarjetaTipo;
	}
	public String getPaypalEmail() {
		return paypalEmail;
	}
	public void setPaypalEmail(String paypalEmail) {
		this.paypalEmail = paypalEmail;
	}
	public String getTarjetaNumero() {
		return tarjetaNumero;
	}
	public void setTarjetaNumero(String tarjetaNumero) {
		this.tarjetaNumero = tarjetaNumero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
