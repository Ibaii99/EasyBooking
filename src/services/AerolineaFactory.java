package services;

import java.util.ArrayList;

import gateways.IGatewayAerolinea;
import gateways.aerolinea.IberiaAirlineGateway;
import gateways.aerolinea.NumeracionAerolinea;

public class AerolineaFactory {
//TODO initialize all Aerolinea Gateways
	
	/** Este metodo es el encantado de inicializar y crear todos los gateways de
	 *  Aerolineas.
	 */
	private ArrayList<IGatewayAerolinea> gatewaysAerolineas;
	
	
	public ArrayList<IGatewayAerolinea> getGatewaysAerolineas() {
		return gatewaysAerolineas;
	}

	public AerolineaFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public void initializeGateways() {
		NumeracionAerolinea allAerolineas = new NumeracionAerolinea();
		allAerolineas.loadAerolineas();	
		gatewaysAerolineas = new ArrayList<IGatewayAerolinea>();
		
		for (String e : allAerolineas.getCodAerolineas()) {
			switch (e) {
			case "IBE":
				initializeIberia();
				break;
				
			case "RYR":
				initializeRyanAir();
				break;
	
			default:
				throw new IllegalArgumentException("Unexpected value: " + e);
			}
		}
		
	}
	
	private void initializeIberia() {
		IberiaAirlineGateway iberia = new IberiaAirlineGateway();
		iberia.connect();
		gatewaysAerolineas.add(iberia);
		
	}
	
	private void initializeRyanAir() {
		
	}
}

