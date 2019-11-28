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
	private int idUsuario;
	
	
	private String nombre;
	
	private String email;
	
	private int edad;
	
	private String tipoLogin;
	
	private String aeropuertoPreferido;
	
	
	@Join
	@Persistent(mappedBy="usuario", dependentElement="true")
	private List<Reserva> reservas = new ArrayList<>();
	
	public Usuario() {
		this.nombre = "";
		this.email = "";
		this.edad = 0;
	}
	
//	public Usuario(String nombre, String email, int edad, String aeropuerto_preferido) {
//		this.nombre = nombre;
//		this.email = email;
//		this.edad = edad;
//		this.aeropuerto_preferido = aeropuerto_preferido;
//	}


	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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


	public String getTipoLogin() {
		return tipoLogin;
	}


	public void setTipoLogin(String tipoLogin) {
		this.tipoLogin = tipoLogin;
	}


	public String getAeropuertoPreferido() {
		return aeropuertoPreferido;
	}


	public void setAeropuerto_preferido(String aeropuertoPreferido) {
		this.aeropuertoPreferido = aeropuertoPreferido;
	}


	public List<Reserva> getReservas() {
		return reservas;
	}

	//Obtener numero de reservas
	public int getNumeroReservas() {
		return reservas.size();
	}
	
	//añadir reservas en la lista
	public void addReserva(Reserva reserva) {
		reservas.add(reserva);
	}

	//eliminar reserva de la lista
	public void removeReserva(Reserva reserva) {
		reservas.remove(reserva);
	}

	
	
	
	
	
	
	
	
}
 