package gateways.aerolinea;

import java.rmi.RemoteException;
import java.util.List;

import data.dto.VueloDTO;
import gateways.IGatewayAerolinea;

public class IberiaAirlineGateway implements IGatewayAerolinea {

	@Override
	public boolean reservarVuelo(String codVuelo, String nombre, int plazas) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<VueloDTO> getAllVuelos() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VueloDTO getVuelo(String codVuelo) throws RemoteException {
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
	public List<VueloDTO> buscarVuelosDesdeOrigen(String aeropuertoOrigen, String fecha, int asientos)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}



}
