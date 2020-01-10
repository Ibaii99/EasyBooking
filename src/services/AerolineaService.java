package services;


import java.util.List;

import data.Aerolinea;
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
	
	
}
