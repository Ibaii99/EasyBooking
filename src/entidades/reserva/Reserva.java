package entidades.reserva;

import javax.jdo.annotations.PersistenceCapable;

import entidades.pago.Pago;
import entidades.usuario.Usuario;
import entidades.vuelo.Vuelo;
@PersistenceCapable
public class Reserva {
	
	private String tipoPago;
	private int numeroAsientos;
	private String fecha; // Habria que mirar la clase Date de java
	
	private Usuario usuario;
	private Vuelo vuelo;
	private Pago pago;
	
	public Reserva() {	
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}
	
	
	
	
	
}
 