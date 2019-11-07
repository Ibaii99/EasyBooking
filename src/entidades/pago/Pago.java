package entidades.pago;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Pago {

	@PrimaryKey
	private int id_pago;
	
	private double precio;
	private int numero_tarjeta;
	private String email_paypal;
	
	
}
 