package gateways.aerolinea;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import Ryanair.VueloRyanair;
import data.Vuelo;
import data.dto.UsuarioDTO;
import data.dto.VueloDTO;
import gateways.IGatewayAerolinea;

public class IberiaAirlineGateway implements IGatewayAerolinea {

	@Override
	public ArrayList<VueloDTO> getAllVuelos() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VueloDTO buscarVuelo(String aeropuertoDestino, String aeropuertoOrigen, String fecha, int asientos)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VueloDTO> buscarVuelosDesdeOrigen(String aeropuertoOrigen, String fecha, int asientos)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean reservarVuelo(VueloDTO vuelo, String nombre, int plazas) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
	


}
