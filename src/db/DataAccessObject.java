package db;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import java.util.ArrayList;
import java.util.List;

import data.Aerolinea;
import data.Pago;
import data.Reserva;
import data.Usuario;
import data.Vuelo;

public class DataAccessObject {
	private PersistenceManagerFactory pmf;
	private PersistenceManager pm;
	
	public DataAccessObject() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		pm = pmf.getPersistenceManager();
	}
	
	public void store(Object u) {
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("   * Storing an object: " + u);
			pm.makePersistent(u);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error storing an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		}
	}
	
	public void createSomeDatos() {
		Usuario u1 = new Usuario();
		u1.setNombre("ibai");u1.setEmail("ibai.guillen@opendeusto.es");
		u1.setEdad(20);u1.setAeropuerto_preferido("BIO");
		u1.setTipoLogin("Google");
		
		 
		Usuario u2 = new Usuario();
		u2.setNombre("Jon");u2.setEmail("jjj@jojo.com");
		u2.setEdad(19);u1.setAeropuerto_preferido("BIO");
		u2.setTipoLogin("Google");
		
		Usuario u3 = new Usuario();
		u3.setNombre("Gorka");u3.setEmail("gor@do.com");
		u3.setEdad(20);u3.setAeropuerto_preferido("MAD");
		
		Usuario u4 = new Usuario();
		u4.setNombre("Yeray");u4.setEmail("yeray@elcrack.com");
		u4.setEdad(20);u4.setAeropuerto_preferido("BCN");
	
		Reserva r1 = new Reserva();
		r1.setTipoPago("tarjeta");
		r1.setNumeroAsientos(2);
		r1.setFecha("8-11-2019");
		r1.setUsuario(u1);
		
		Reserva r2 = new Reserva();
		r2.setTipoPago("paypal");
		r2.setNumeroAsientos(3);
		r2.setFecha("7-11-2019");
		r2.setUsuario(u2);
		
		
		Pago p1 = new Pago();
		p1.setPaypalEmail("ibai.guillen@opendeusto.es");
		p1.setPrecio(149.98);

		p1.setTipo("Paypal");
		
		Pago p2 = new Pago();
		p2.setTarjetaNumero("VISA");
		p2.setTarjetaNumero("0000 1111 2222 3333");
		p2.setTarjetaFechaCaducidad("06/22");
		p2.setPrecio(231.97);
		p2.setTipo("Tarjeta");

		
		ArrayList<Reserva> vuelres = new ArrayList<Reserva>();
		vuelres.add(r1);
		vuelres.add(r2);
		
		Aerolinea a1 = new Aerolinea();
		a1.setCodAerolinea("IBE");
		a1.setNombre("Iberia");
		
		Vuelo v1 = new Vuelo();
		v1.setAeropuertoDestino("Madrid");
		v1.setAeropuertoOrigen("Loiu");
		v1.setFecha("15/1/2020");
		v1.setNumAsientos(500);
		v1.setReservas(vuelres);
		v1.setAerolinea(a1);
		
		r1.setVuelo(v1);
		r2.setVuelo(v1);
		r1.setPago(p1); 
		r2.setPago(p2); 
		u1.addReserva(r1);
		u2.addReserva(r2);
		p2.setReserva(r1);
		p1.setReserva(r2);

		
		store(u1);
		store(u2);
		store(u3);
		store(u4);
		
		store(r1);
		store(r2);
		
		store(p1);
		store(p2);
		
		store(a1);
		store(v1);
		
	}
	
	
	public List<Aerolinea> getAerolineas(){
		List <Aerolinea> aero = new ArrayList<Aerolinea>();
		
		Transaction tx = pm.currentTransaction();
		try {
			System.out.println("   * Retrieving an Extent for Airline.");
			tx.begin();
			Extent<Aerolinea> extent = pm.getExtent(Aerolinea.class, true);
			for (Aerolinea product : extent) {
				aero.add(product);
			}
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retrieving an airline: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
		}
		return aero;
	}

	
	
	public List<Usuario> getUsuarios(){
		List <Usuario> usr = new ArrayList<Usuario>();
		Transaction tx = pm.currentTransaction();
		try {
			System.out.println("   * Retrieving an Extent for Usuarios.");
			tx.begin();
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);
			for (Usuario product : extent) {
				usr.add(product);
			}
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retrieving an usuario: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		return usr;
	}
	
	public List<Pago> getPagos(){
		List <Pago> usr = new ArrayList<Pago>();
		Transaction tx = pm.currentTransaction();
		try {
			System.out.println("   * Retrieving an Extent for Usuarios.");
			tx.begin();
			Extent<Pago> extent = pm.getExtent(Pago.class, true);
			for (Pago product : extent) {
				usr.add(product);
			}
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retrieving an usuario: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
		}
		return usr;
	}
	
	public List<Vuelo> getVuelos(){
		List <Vuelo> usr = new ArrayList<Vuelo>();
		Transaction tx = pm.currentTransaction();
		try {
			System.out.println("   * Retrieving an Extent for Usuarios.");
			tx.begin();
			Extent<Vuelo> extent = pm.getExtent(Vuelo.class, true);
			for (Vuelo product : extent) {
				usr.add(product);
			}
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retrieving an usuario: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		return usr;
	}
	
	public List<Reserva> getReservas(){
		List <Reserva> res = new ArrayList<Reserva>();
		Transaction tx = pm.currentTransaction();
		try {
			System.out.println("   * Retrieving an Extent for Reservas.");
			tx.begin();
			Extent<Reserva> extent = pm.getExtent(Reserva.class, true);
				
			for (Reserva product : extent) {
				if(product != null) {
					Reserva reserva = product;
					Usuario u = product.getUsuario();
					Pago p = product.getPago();
					Vuelo v = product.getVuelo();
					
					reserva.setPago(p);
					reserva.setVuelo(v);
					reserva.setUsuario(u);
					//TODO
					
					res.add(reserva);
				}
			}
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retrieving an Reservas: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			
		}
		return res;
	}
	
	public Usuario getUserByEmail(String email) {
		List<Usuario> usr = getUsuarios();
		for(Usuario u: usr) {
			if(u.getEmail().equals(email)) {
				return u;
			}
		}
		return null;
		
	}
	public void closeConection() {
		pmf.close();
	}
}
