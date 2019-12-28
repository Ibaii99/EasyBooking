package data;


import java.util.ArrayList;
import java.util.List;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class Usuario {
	
	private String nombre;	
	private String email;
	private int edad;
	private String tipoLogin;
	private String aeropuertoPreferido;
	
	@Persistent(mappedBy = "usuario")
	private List<Reserva> reservas = new ArrayList<>();
	
	public Usuario() {
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
 