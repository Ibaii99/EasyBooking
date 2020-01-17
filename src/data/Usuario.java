package data;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	@PrimaryKey
	private String email;
	private int edad;
	private String tipoLogin;
	private String aeropuertoPreferido;
	private String password;
	
	@Persistent(mappedBy = "usuario")
	@Join
	private List<Reserva> reservas;
	
	public boolean isUser(String mail, String password) {
		if(this.email == nombre && this.password == password) return true;
		return false;
	}
	
	public void reservasToString() {
		if(reservas.size()!=0) {
			System.out.println("Reservas totales del usuario:" + reservas.size());
			for(Reserva r : reservas) {
				r.testToString();
			}
		}
	}
	public void testToString() {
		System.out.println(nombre);
		System.out.println(email);
		System.out.println(edad);
		System.out.println(tipoLogin);
		System.out.println(aeropuertoPreferido);
		System.out.println(password);

	}
	public void setAeropuertoPreferido(String aeropuertoPreferido) {
		this.aeropuertoPreferido = aeropuertoPreferido;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Usuario() {
		reservas = new ArrayList<>();
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
 