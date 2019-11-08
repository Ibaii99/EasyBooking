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
	private int id_reserva;
	
	
	private String tipo_pago;
	private int numero_asientos;
	private String fecha; // Habria que mmirar la clase date de java
	
	
	private Usuario usuario;
	
	private Vuelo vuelo;
	
	@Join
	@Persistent(mappedBy="reserva", dependentElement="true")
	private Pago pago;
	
	public Reserva(String tipo_pago, int numero_asientos, String fecha) {
		this.tipo_pago = tipo_pago;
		this.numero_asientos = numero_asientos;
		this.fecha = fecha;
	}

	public int getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}

	public String getTipo_pago() {
		return tipo_pago;
	}

	public void setTipo_pago(String tipo_pago) {
		this.tipo_pago = tipo_pago;
	}

	public int getNumero_asientos() {
		return numero_asientos;
	}

	public void setNumero_asientos(int numero_asientos) {
		this.numero_asientos = numero_asientos;
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
 