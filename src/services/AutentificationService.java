package services;

import java.util.ArrayList;
import java.util.List;

import gateways.IGatewayAutorizacion;
import gateways.autentification.GoogleGateway;

public class AutentificationService {

	private List<IGatewayAutorizacion> autorizadores;
	
	public AutentificationService() {
		autorizadores = new ArrayList<IGatewayAutorizacion>();
		GoogleGateway google = new GoogleGateway();
		autorizadores.add(google);
	}
	
	
	public void registrar(String email, String password) {
		autorizadores.get(0).registrar(email, password);
		
	}

	
	public boolean login(String email, String password) {
		return autorizadores.get(0).login(email, password);
	}
}
