package data.dto;

import java.io.Serializable;

import data.Reserva;

public class UsuarioDTO implements Serializable{

	private static final long serialVersionUID = 8829744013340172113L;
	
	private String nombre;	
	private String email;
	
	public UsuarioDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public void testToString() {
		System.out.println(nombre);
		System.out.println(email);
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
	
	

}
