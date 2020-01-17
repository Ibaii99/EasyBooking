package gateways.aerolinea;

import java.util.ArrayList;

import data.dto.VueloDTO;
import gateways.IGatewayAerolinea;

public class RyanAirGateway implements IGatewayAerolinea{
	static String IP = "127.0.0.1";
	static String Puerto = "";
	static String Service = "";
	
	@Override
	public ArrayList<VueloDTO> getAllVuelos() {
		// TODO Auto-generated method stub
		return null;
	}

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
	public boolean reservarVuelo(VueloDTO vuelo, String nombre, int plazas) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VueloDTO buscarVuelo(String aeropuertoDestino, String aeropuertoOrigen, String fecha, int asientos) {
		// TODO Auto-generated method stub
		return null;
	}

}
