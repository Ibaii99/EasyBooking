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
	private int id_pago;
	
	private String tipo; // PayPal || Tarjeta
	
	private double precio;
	
	private String tarjeta_numero;
	private String tarjeta_tipo;
	private String tarjeta_fecha_caducidad;
	
	private String paypal_email;
	
	@Join
	//@Persistent(mappedBy="pago", dependentElement="true")
	private Reserva reserva;
	
	
	//Constructor de pago universal
	public Pago() {
		this.tipo = "";
		this.precio = 0.0;
	}
	
//	//Constructor de pago con tarjeta
//	public Pago(String tarjeta_tipo, String tarjeta_numero,
//			String tarjeta_fecha_caducidad, double precio) {
//		this.tarjeta_tipo = tarjeta_tipo;
//		this.tarjeta_numero = new String(tarjeta_numero);
//		this.tarjeta_fecha_caducidad = tarjeta_fecha_caducidad;
//		this.precio = precio;
//	}

	public int getId_pago() {
		return id_pago;
	}

	public void setId_pago(int id_pago) {
		this.id_pago = id_pago;
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

	public String getTarjeta_numero() {
		return tarjeta_numero;
	}

	public void setTarjeta_numero(String tarjeta_numero) {
		this.tarjeta_numero = tarjeta_numero;
	}

	public String getTarjeta_tipo() {
		return tarjeta_tipo;
	}

	public void setTarjeta_tipo(String tarjeta_tipo) {
		this.tarjeta_tipo = tarjeta_tipo;
	}

	public String getTarjeta_fecha_caducidad() {
		return tarjeta_fecha_caducidad;
	}

	public void setTarjeta_fecha_caducidad(String tarjeta_fecha_caducidad) {
		this.tarjeta_fecha_caducidad = tarjeta_fecha_caducidad;
	}

	public String getPaypal_email() {
		return paypal_email;
	}

	public void setPaypal_email(String paypal_email) {
		this.paypal_email = paypal_email;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	
}
 