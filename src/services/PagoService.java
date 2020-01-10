package services;

import java.util.ArrayList;
import java.util.List;

import gateways.IGatewayPago;

public class PagoService {

	private List<IGatewayPago> pagos;
	
	public PagoService() {
		// TODO Auto-generated constructor stub
		pagos = new ArrayList<IGatewayPago>();
		
	}
}
