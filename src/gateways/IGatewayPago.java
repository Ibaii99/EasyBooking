package gateways;

import java.rmi.RemoteException;

import data.dto.UsuarioDTO;
import data.dto.VueloDTO;

public interface IGatewayPago {

	/**
	 * @param precio Precio a pagar
	 * @param email Usuairo que paga el vuelo
	 * @return True si se realiza el pago, False si no
	 */
	public boolean realizarPago(int precio, String email, String contrasenya) throws RemoteException; 
	
	/**
	 * @param precio Precio a pagar
	 * @param email Usuairo que se quiere comprobar que teine fondos
	 * @return True si tiene fondos
	 */
	public boolean tieneFondos(int precio, String email, String contrasenya) throws RemoteException; 

}
