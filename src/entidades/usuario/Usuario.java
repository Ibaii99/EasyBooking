package entidades.usuario;


import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import entidades.reserva.Reserva;

@PersistenceCapable
public class Usuario {

	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	private int id_usuario;
	
	
	private String nombre;
	private String email;
	private int edad;
	private String tipo_login;
	private String cod_aeropuerto;
	
	
	@Join
	@Persistent(mappedBy="usuario", dependentElement="true")
	private List<Reserva> reservas = new ArrayList<>();
	
	
}
 