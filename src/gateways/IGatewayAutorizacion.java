package gateways;

import data.dto.UsuarioDTO;

public interface IGatewayAutorizacion {


	/** Registra al usuario con email y password
	 * @param email
	 * @param password
	 */
	public void registrar(String email, String password);
	/**
	 * @param email Nombre que se comprueba si esta registrado
	 * @param password Contrasenya que se comprueba si esta registrado
	 * @return devuelve true si es un login correcto, false si no
	 */
	public boolean login(String email, String password); 
	
}
