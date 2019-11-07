package entidades.reserva;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable
public class Reserva {

	@PrimaryKey
	private int id_reserva;
	
	
	private String tipo_pago;
	private int numero_asientos;
	private String fecha; // Habria que mmirar la clase date de java
	private int id_usuario;
	private int id_vuelo;
	private int id_pago;
	
	
}
 