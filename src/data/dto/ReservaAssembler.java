package data.dto;

import java.util.ArrayList;
import java.util.List;

import data.Reserva;

public class ReservaAssembler {
	
	private static ReservaAssembler instance;
	
	private ReservaAssembler() { }
	
	public static ReservaAssembler getInstance() {
		if (instance == null) {
			instance = new ReservaAssembler();
		}
		return instance;
	}
	
	public ReservaDTO entityToDTO(Reserva reserva) {
		ReservaDTO dto = new ReservaDTO();
		
		dto.setTipoPago(reserva.getTipoPago());
		dto.setFecha(reserva.getFecha());
		dto.setNumeroAsientos(reserva.getNumeroAsientos());
		
		return dto;
	}
	
	public List<ReservaDTO> entityToDTO(List<Reserva> reservas) {
		List<ReservaDTO> dtos = new ArrayList<>();
		
		for (Reserva reserva : reservas) {
			dtos.add(this.entityToDTO(reserva));
		}
		
		System.out.println("* Assembling bookings ...");
		
		return dtos;
	}

}
