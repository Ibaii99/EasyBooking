package data.dto;

import java.io.Serializable;

public class AerolineaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String codAerolinea;
	private String nombre;
	
	public String getCodAerolinea() {
		return codAerolinea;
	}
	
	public void setCodAerolinea(String codAerolinea) {
		this.codAerolinea = codAerolinea;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

}
