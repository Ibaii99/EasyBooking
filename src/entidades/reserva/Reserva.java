package entidades.reserva;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import entidades.pago.Pago;
import entidades.usuario.Usuario;
import entidades.vuelo.Vuelo;
@PersistenceCapable
public class Reserva {

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	private int idReserva;
	
	
	private String tipoPago;
	private int numeroAsientos;
	private String fecha; // Habria que mirar la clase Date de java
	
	
	private Usuario usuario;
	
	private Vuelo vuelo;
	
	@Join
	//@Persistent(mappedBy="reserva", dependentElement="true")
	private Pago pago;
	
//	public Reserva(String tipoPago, int numeroAsientos, String fecha) {
//		this.tipoPago = tipoPago;
//		this.numeroAsientos = numeroAsientos;
//		this.fecha = fecha;
//	}
	
	public Reserva() {
		
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
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
 