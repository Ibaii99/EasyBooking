package data.dto;

import java.io.Serializable;

import data.Pago;
import data.Usuario;
import data.Vuelo;

public class ReservaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String tipoPago;
	private int numeroAsientos;
	private String fecha; 
	private String email;
	private double precio;
	//Pago
	private String paypalEmail;
	private String tarjetaNumero;
	
	public ReservaDTO() {
		// TODO Auto-generated constructor stub
	}
	public void testToString() {
		System.out.println(tipoPago);
		System.out.println(numeroAsientos);
		System.out.println(fecha);
		System.out.println(email);
		System.out.println(precio);
		System.out.println(paypalEmail);
		System.out.println(tarjetaNumero);
	}

	
	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
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





	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
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
	
	
	
}
