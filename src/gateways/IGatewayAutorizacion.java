package gateways;

import data.dto.UsuarioDTO;

public interface IGatewayAutorizacion {

	/** 
	 * @param usuario Registra al usuario
	 */
	public void registrar(UsuarioDTO usuario);
	/**
	 * @param usuario Usuario que se comprueba si esta registrado
	 * @return devuelve true si es un login correcto, false si no
	 */
	public boolean login(UsuarioDTO usuario); 
	
}
