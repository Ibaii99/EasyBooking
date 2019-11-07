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
	
	private String aeropuerto_preferido;
	
	
	@Join
	@Persistent(mappedBy="usuario", dependentElement="true")
	private List<Reserva> reservas = new ArrayList<>();


	public int getId_usuario() {
		return id_usuario;
	}


	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getTipo_login() {
		return tipo_login;
	}


	public void setTipo_login(String tipo_login) {
		this.tipo_login = tipo_login;
	}


	public String getAeropuerto_preferido() {
		return aeropuerto_preferido;
	}


	public void setAeropuerto_preferido(String aeropuerto_preferido) {
		this.aeropuerto_preferido = aeropuerto_preferido;
	}


	public List<Reserva> getReservas() {
		return reservas;
	}


	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	
	
	
}
 