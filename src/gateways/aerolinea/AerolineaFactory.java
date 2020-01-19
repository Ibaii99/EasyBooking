package gateways.aerolinea;

import java.util.ArrayList;

import gateways.IGatewayAerolinea;

public class AerolineaFactory {
//TODO initialize all Aerolinea Gateways
	
	/** Este metodo es el encantado de inicializar y crear todos los gateways de
	 *  Aerolineas.
	 */
	private ArrayList<IGatewayAerolinea> gatewaysAerolineas;
	private NumeracionAerolinea allAerolineas;
	
	public ArrayList<IGatewayAerolinea> getGatewaysAerolineas() {
		return gatewaysAerolineas;
	}

	public AerolineaFactory() {
		allAerolineas = new NumeracionAerolinea();
		allAerolineas.loadAerolineas();
		gatewaysAerolineas = new ArrayList<IGatewayAerolinea>();
		initializeGateways();
	}
	
	public void initializeGateways() {
		
		
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
		//IberiaAirlineGateway iberia = new IberiaAirlineGateway();
		//gatewaysAerolineas.add(iberia);
	}
	
	private void initializeRyanAir() {
		RyanAirGateway ryanair = new RyanAirGateway();
		gatewaysAerolineas.add(ryanair);
	}
}

