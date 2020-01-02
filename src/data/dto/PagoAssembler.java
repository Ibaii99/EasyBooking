package data.dto;

import java.util.ArrayList;
import java.util.List;

import data.Pago;

public class PagoAssembler {
	
	private static PagoAssembler instance;
	
	private PagoAssembler() { }

	public static PagoAssembler getInstance() {
		if (instance == null) {
			instance = new PagoAssembler();
		}
		return instance;
	}
	
	public PagoDTO entityToDTO(Pago pago) {
		PagoDTO dto = new PagoDTO();
		
		dto.setTipo(pago.getTipo());
		dto.setPrecio(pago.getPrecio());
		
		return dto;
	}
	
	public List<PagoDTO> entityToDTO(List<Pago> pagos) {
		List<PagoDTO> dtos = new ArrayList<>();
		
		for (Pago pago : pagos) {
			dtos.add(this.entityToDTO(pago));
		}
		
		System.out.println("* Assembling payments ...");
		
		return dtos;
	}
}
