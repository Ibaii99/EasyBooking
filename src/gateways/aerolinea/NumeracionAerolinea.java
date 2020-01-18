package gateways.aerolinea;

public class NumeracionAerolinea {
// TODO this class contains all Aerolinea classes code to pass them to the factory and later initialize them
	
	
	private String[] codAerolineas;
	public static int cantidadAerolineas = 0;
	
	public NumeracionAerolinea() {
		cantidadAerolineas += 1;
	}
	
	public String[] getCodAerolineas(){
		return this.codAerolineas;
	}
	
	public void setCodAerolineas(String[] codigos){
		this.codAerolineas = codigos;
	}
	
	public void addCodAerolinea(String codigo) {
		codAerolineas[cantidadAerolineas] = codigo;
		cantidadAerolineas += 1;
	}
	
	public void loadAerolineas() {
//		String[] aerolineas = {
//				"IBE",
//				"RYR"
//			};
//		
		String[] aerolineas = {
				"RYR"
			};
		cantidadAerolineas = 2;
		this.codAerolineas = aerolineas;
		
	}
}
