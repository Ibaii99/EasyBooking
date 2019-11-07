package entidades.pago;

import javax.jdo.annotations.IdGeneratorStrategy;
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
	
	private long tarjeta_numero;
	private String tarjeta_tipo;
	private String tarjeta_fecha_caducidad;
	
	private String paypal_email;
	
	@Persistent(mappedBy="pago", dependentElement="true")
	private Reserva reserva;
}
 