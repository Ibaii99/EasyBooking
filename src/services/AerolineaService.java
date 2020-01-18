package services;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.Aerolinea;
import data.dto.VueloDTO;
import gateways.IGatewayAerolinea;
import gateways.aerolinea.AerolineaFactory;

public class AerolineaService {
//TODO Implement Aerolinea object function
	
	private List<IGatewayAerolinea> aerolineas;

	
	public AerolineaService() {
		// TODO Auto-generated constructor stub
		AerolineaFactory factory = new AerolineaFactory();
		aerolineas = factory.getGatewaysAerolineas();	
	}
	
	public ArrayList<VueloDTO> getAllVuelos() throws RemoteException{
		ArrayList<VueloDTO> a = new ArrayList<VueloDTO>();
		for(IGatewayAerolinea i : aerolineas) {
			for(VueloDTO v : i.getAllVuelos()) {
				a.add(v);
			}
		}
		return a;
	}
	 
	public VueloDTO buscarVuelo(String aeropuertoDestino, String aeropuertoOrigen, String fecha, String fechaVuelta, int asientos) throws RemoteException{
		VueloDTO vuelo = null;
		for(IGatewayAerolinea aerolinea : aerolineas) {
			VueloDTO v = aerolinea.buscarVuelo(aeropuertoDestino, aeropuertoOrigen, fecha, asientos);
			if(v != null) {
				vuelo = v;
			}
		}
		return vuelo;
	}
	 
	public ArrayList<VueloDTO> buscarVuelosDesdeOrigen(String aeropuertoOrigen, String fecha, int asientos) throws RemoteException{
		ArrayList<VueloDTO> vuelos = new ArrayList<VueloDTO>();
		for(IGatewayAerolinea aerolinea : aerolineas) {
			ArrayList<VueloDTO> vue = aerolinea.buscarVuelosDesdeOrigen(aeropuertoOrigen, fecha, asientos);
			for(VueloDTO v : vue) {
				vuelos.add(v);
			}
		}
		return vuelos;
	}
	
	public boolean reservarVuelo(VueloDTO vuelo, String nombre, int plazas) throws RemoteException{
		for(IGatewayAerolinea aerolinea : aerolineas) {
			if(aerolinea.reservarVuelo(vuelo, nombre, plazas) == true) return true;
		}
		return false;
	}
	

	
}
