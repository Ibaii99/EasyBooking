package gateways.autentification;

import gateways.IGatewayAutorizacion;

public class GoogleGateway implements IGatewayAutorizacion{

	static String IP = "127.0.0.1";
	static String Puerto = "";
	static String Service = "";
	
	public GoogleGateway() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void registrar(String email, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean login(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
