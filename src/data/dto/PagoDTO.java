package data.dto;

import java.io.Serializable;

public class PagoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String tipo;
	private double precio;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
