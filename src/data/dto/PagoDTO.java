package data.dto;

import java.io.Serializable;

public class PagoDTO implements Serializable{

	private static final long serialVersionUID = 8829744013340172113L;
	
	//Atributos del pago
	private String tipo;
	private double precio;
	private String tarjetaNumero;
	private String tarjetaTipo;
	private String tarjetaFechaCaducidad;
	private String paypalEmail;
	
	
	// Atributos de la reserva	
	private String tipoPago;
	private String fecha;
	private String email;
	private int numeroAsientos;
	
	
	
	public PagoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public void testToString() {
		System.out.println(tipo);
		System.out.println(precio);
		System.out.println(tarjetaNumero);
		System.out.println(tarjetaTipo);
		System.out.println(tarjetaFechaCaducidad);
		System.out.println(paypalEmail);
		System.out.println(tipoPago);
		System.out.println(fecha);
		
	}
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTarjetaFechaCaducidad() {
		return tarjetaFechaCaducidad;
	}
	public void setTarjetaFechaCaducidad(String tarjetaFechaCaducidad) {
		this.tarjetaFechaCaducidad = tarjetaFechaCaducidad;
	}
	
	public String getTipoPago() {
		return tipoPago;
	}


	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}


	public int getNumeroAsientos() {
		return numeroAsientos;
	}


	public void setNumeroAsientos(int numeroAsientos) {
		this.numeroAsientos = numeroAsientos;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
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
