package gateways.aerolinea;

import java.util.ArrayList;

public class NumeracionAerolinea {
// TODO this class contains all Aerolinea classes code to pass them to the factory and later initialize them
	
	
	private ArrayList<String> codAerolineas = new ArrayList<String>();
	public static int cantidadAerolineas = 0;
	
	public NumeracionAerolinea() {
		cantidadAerolineas += 1;
	}
	
	public ArrayList<String> getCodAerolineas(){
		return this.codAerolineas;
	}
	
	public void setCodAerolineas(ArrayList<String> codigos){
		this.codAerolineas = codigos;
	}
	
	public void addCodAerolinea(String codigo) {
		codAerolineas.add(codigo);
		cantidadAerolineas += 1;
	}
	
	public void loadAerolineas() {
		codAerolineas.add("RYR");
		codAerolineas.add("IBE");
		System.out.println();
		cantidadAerolineas = 2;
		
	}
}
