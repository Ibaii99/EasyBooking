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
	 
	public List<VueloDTO> buscarVueloIda(String aeropuertoDestino, String aeropuertoOrigen, String fecha, int asientos) throws RemoteException{
		List<VueloDTO> vuelo = new ArrayList<VueloDTO>();
		for(IGatewayAerolinea aerolinea : aerolineas) {
			VueloDTO v = aerolinea.buscarVuelo(aeropuertoDestino, aeropuertoOrigen, fecha, asientos);
			if(v != null) {
				vuelo.add(v);
			}
		}
		return vuelo;
	}
	 
	public List<VueloDTO> buscarVuelosDesdeOrigen(String aeropuertoOrigen, String fecha, int asientos) throws RemoteException{
		List<VueloDTO> vuelos = new ArrayList<VueloDTO>();
		for(IGatewayAerolinea aerolinea : aerolineas) {
			List<VueloDTO> vue = aerolinea.buscarVuelosDesdeOrigen(aeropuertoOrigen, fecha, asientos);
			for(VueloDTO v : vue) {
				vuelos.add(v);
			}
		}
		return vuelos;
	}
	
	public boolean reservarVuelo(String codigoVuelo, String nombre, int plazas) throws RemoteException{
		for(IGatewayAerolinea aerolinea : aerolineas) {
			if(aerolinea.reservarVuelo(codigoVuelo, nombre, plazas) == true) return true;
		}
		return false;
	}
	

	public VueloDTO getVuelo(String codVuelo) throws RemoteException{
		for(IGatewayAerolinea aerolinea : aerolineas) {
			if(aerolinea.getVuelo(codVuelo) != null) return aerolinea.getVuelo(codVuelo);
		}
		return null;
	}
	
	public List<VueloDTO> buscarVueloIdaYVuelta(String aeropuertoDestino, String aeropuertoOrigen, String fechaIda, String fechaVuelta, int asientos) throws RemoteException {
		List<VueloDTO> v = buscarVueloIda(aeropuertoDestino, aeropuertoOrigen, fechaIda, asientos);
		for(VueloDTO vue : buscarVueloIda(aeropuertoOrigen, aeropuertoDestino, fechaVuelta, asientos)) {
			v.add(vue);
		}
		return v;
	}
	
	
	

	
}
