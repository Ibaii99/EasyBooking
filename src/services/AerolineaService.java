package services;

import data.Aerolinea;

public class AerolineaService {
//TODO Implement Aerolinea object function
	
	private Aerolinea aerolinea;
	
	private void reservarVuelo() {
		
	}
 
	public AerolineaService() {
		// TODO Auto-generated constructor stub
		AerolineaFactory factory = new AerolineaFactory();
		factory.getGatewaysAerolineas();
		
	}
	
	
}
