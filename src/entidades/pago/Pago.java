package entidades.pago;



import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import entidades.reserva.Reserva;

@PersistenceCapable
public class Pago {

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	private int idPago;
	
	private String tipo; // PayPal || Tarjeta
	
	private double precio;
	
	private String tarjetaNumero;
	private String tarjetaTipo;
	private String tarjetaFechaCaducidad;
	
	private String paypalEmail;
	
	@Join
	//@Persistent(mappedBy="pago", dependentElement="true")
	private Reserva reserva;
	
	
	//Constructor de pago por defecto
	public Pago() {
		this.tipo = "";
		this.precio = 0.0;
	}
	
//	//Constructor de pago con tarjeta
//	public Pago(String tarjetaTipo, String tarjetaNumero,
//			String tarjetaFecha_caducidad, double precio) {
//		this.tarjetaTipo = tarjetaTipo;
//		this.tarjetaNumero = new String(tarjetaNumero);
//		this.tarjetaFechaCaducidad = tarjetaFechaCaducidad;
//		this.precio = precio;
//	}

	public int getIdPago() {
		return idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
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
 