package entidades.reserva;

import javax.jdo.annotations.IdGeneratorStrategy;
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
	
	private Pago pago;
	
	
}
 