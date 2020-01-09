package gateways.aerolinea;

import java.util.ArrayList;
import java.util.Date;

import data.Vuelo;
import data.dto.UsuarioDTO;
import data.dto.VueloDTO;
import gateways.IGatewayAerolinea;

public class IberiaAirlineGateway implements IGatewayAerolinea {

	@Override
	public ArrayList<VueloDTO> getAllVuelos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VueloDTO buscarVuelo(String aeropuertoDestino, String aeropuertoOrigen, String fechaIda, String fechaVuelta,
			int asientos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VueloDTO> buscarVuelosDesdeOrigen(String aeropuertoOrigen, String fecha, int asientos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean reservarVuelo(VueloDTO vuelo, UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		return false;
	}
	//TODO this is an example Aerolinea gateway class
	
	


}
