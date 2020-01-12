package data;


import java.io.Serializable;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(detachable = "true")
public class Pago implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String tipo; // PayPal || Tarjeta
	private double precio;
	private String tarjetaNumero;
	private String tarjetaTipo;
	private String tarjetaFechaCaducidad;
	private String paypalEmail;
	
	@Persistent(defaultFetchGroup = "true")
	private Reserva reserva;
	
	
	//Constructor de pago por defecto
	public Pago() {
	}

	public void testToString() {
		System.out.println(tipo);
		System.out.println(precio);
		System.out.println(tarjetaNumero);
		System.out.println(tarjetaTipo);
		System.out.println(tarjetaFechaCaducidad);
		System.out.println(paypalEmail);
		
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

	public String getTarjetaNumero() {
		return tarjetaNumero;
	}

	public void setTarjetaNumero(String tarjetaNumero) {
		this.tarjetaNumero = tarjetaNumero;
	}

	public String getTarjetaTipo() {
		return tarjetaTipo;
	}

	public void setTarjetaTipo(String tarjetaTipo) {
		this.tarjetaTipo = tarjetaTipo;
	}

	public String getTarjetaFechaCaducidad() {
		return tarjetaFechaCaducidad;
	}

	public void setTarjetaFechaCaducidad(String tarjetaFechaCaducidad) {
		this.tarjetaFechaCaducidad = tarjetaFechaCaducidad;
	}

	public String getPaypalEmail() {
		return paypalEmail;
	}

	public void setPaypalEmail(String paypalEmail) {
		this.paypalEmail = paypalEmail;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	
}
 