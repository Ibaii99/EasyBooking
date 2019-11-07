package entidades.usuario;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable
public class Usuario {

	
	@PrimaryKey
	private int id_usuario;
	
	
	private String nombre;
	private String email;
	private int edad;
	private String tipo_login;
	private String cod_aeropuerto;
	
	
	
}
 