package bin;


import java.util.List;

import data.Reserva;
import data.Usuario;
import data.dto.DTOAssembler;
import data.dto.UsuarioDTO;
import db.DataAccessObject;


public class EasyBookingServer {

	public static void main(String[] args) {
		System.out.println("inicio");
		DataAccessObject db = new DataAccessObject();
		db.createSomeDatos();
		List<Usuario> usr = db.getUsuarios();
		List<Reserva> res = db.getReservas();
		for(Reserva reserva: res) {
			//TODO
			reserva.testToString();
			reserva.getUsuario().testToString();
			reserva.getPago().testToString();
			reserva.getVuelo().testToString();
			System.out.println("------------------");
			
		}
		DTOAssembler dto = new DTOAssembler();
		for(Usuario e: usr) {
			e.reservasToString();
			System.out.println("Printing usuario normal");
			e.testToString();
			UsuarioDTO usrdto = dto.assemble(e);
			System.out.println("Printing usuario DTO");
			usrdto.testToString();
			System.out.println("Printing usuario disassembled");
			Usuario usrdisassem = dto.disassemble(usrdto);
			usrdisassem.testToString();
			System.out.println("----------------------");
			System.out.println("Reservas before");
			e.reservasToString();
			System.out.println("Reservas after");
			try {
			usrdisassem.reservasToString();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			System.out.println("------------------------------\n");
			
		}
		
		
	}
}
