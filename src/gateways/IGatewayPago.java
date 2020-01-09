package gateways;

import data.dto.UsuarioDTO;
import data.dto.VueloDTO;

public interface IGatewayPago {

	/**
	 * @param vuelo Vuelo a pagar
	 * @param usuario Usuairo que paga el vuelo
	 * @return True si se realiza el pago, False si no
	 */
	public boolean realizarPago(VueloDTO vuelo, UsuarioDTO usuario);
	
}
