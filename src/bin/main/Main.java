package bin.main;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import data.Pago;
import data.Reserva;
import data.Usuario;


public class Main {

	public static void main(String[] args) {
		
<<<<<<< HEAD
		Usuario u = new Usuario("ibai", "ibai@jasnka.es", 20, "BIO");
		Usuario u1 = new Usuario("ibai", "asidhaiubuad@jasnka.es", 20, "BIO");
		Usuario u2 = new Usuario("Jon", "jjj@jojo.com", 19, "BIO");
		Usuario u3 = new Usuario("Gorka", "gor@do.com", 20, "MAD");
=======
		Usuario u1 = new Usuario();
		u1.setNombre("ibai");u1.setEmail("asidhaiubuad@jasnka.es");
		u1.setEdad(20);u1.setAeropuerto_preferido("BIO");
>>>>>>> branch 'master' of https://github.com/Ibaii99/EasyBooking.git
		
		Usuario u2 = new Usuario();
		u2.setNombre("Jon");u1.setEmail("jjj@jojo.com");
		u2.setEdad(19);u1.setAeropuerto_preferido("BIO");
		
		Usuario u3 = new Usuario();
		u3.setNombre("Gorka");u3.setEmail("gor@do.com");
		u3.setEdad(20);u3.setAeropuerto_preferido("MAD");
		
		Usuario u4 = new Usuario();
		u4.setNombre("Yeray");u4.setEmail("yeray@elcrack.com");
		u4.setEdad(20);u4.setAeropuerto_preferido("BCN");
		
		
		
		Reserva r1 = new Reserva();
		r1.setTipoPago("tarjeta");r1.setNumeroAsientos(2);
		r1.setFecha("8-11-2019");
		Reserva r2 = new Reserva();
		r2.setTipoPago("paypal");r2.setNumeroAsientos(3);
		r2.setFecha("7-11-2019");
		
		Pago p1 = new Pago();
		p1.setPaypalEmail(u1.getEmail());
		p1.setPrecio(149.98);
		Pago p2 = new Pago();
		p2.setTarjetaNumero("VISA");
		p2.setTarjetaNumero("0000 1111 2222 3333");
		p2.setTarjetaFechaCaducidad("06/22");
		p2.setPrecio(231.97);
		

		u1.addReserva(r1);
		u2.addReserva(r2);
		
		try {
			System.out.println("Entra en el try");
			PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			
			//Insert data in the DB
			PersistenceManager pm = pmf.getPersistenceManager();				
			Transaction tx = pm.currentTransaction();	
			try {
				System.out.println("Entra en el segundo try");
				tx.begin();
				// 	TODO 
				pm.makePersistent(u1);
				System.out.println("1º usuario guardado");
				pm.makePersistent(u2);
				System.out.println("3º usuario guardado");
				pm.makePersistent(u3);
				System.out.println("3º usuario guardado");
				pm.makePersistent(u4);
				System.out.println("4º usuario guardado");
				
				
				System.out.println("- Inserted into db: ");
				tx.commit();
			} catch (Exception e) {
				System.err.println("* Exception inserting data into db: " + e.getMessage());
			} finally {
				if (tx.isActive()) {
					tx.rollback();
				}
				pm.close();
				System.out.println("Cierra conexion");
			}
			
			//Select data using a Query
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();
			
			try {
				System.out.println("- Usuarios con aeropuerto en BIO");			
				//Get the Persistence Manager
				pm = pmf.getPersistenceManager();
				//Obtain the current transaction
				tx = pm.currentTransaction();		
				//Start the transaction
				tx.begin();

				Query<Usuario> query = pm.newQuery(Usuario.class);
				query.setFilter("aeropuerto_preferido == 'BIO'" );
				
				@SuppressWarnings("unchecked")
				List<Usuario> usuarios = (List<Usuario>) query.execute();
				
				for (Usuario usuario : usuarios) {
					System.out.println("  -> " + usuario.getNombre());
				}

				//End the transaction
				tx.commit();
					
			} catch (Exception e) {
				System.err.println("* Exception executing a query: " + e.getMessage());
			} finally {
				if (tx.isActive()) {
			        tx.rollback();
			    }
	
			    pm.close();
			}
			
			
			try {
				System.out.println("- DELETE - ");			
				//Get the Persistence Manager
				pm = pmf.getPersistenceManager();
				//Obtain the current transaction
				tx = pm.currentTransaction();		
				//Start the transaction
				tx.begin();

				Query<Usuario> usuarios = pm.newQuery(Usuario.class);
				usuarios.deletePersistentAll();
				
				Query<Reserva> reservas = pm.newQuery(Reserva.class);
				reservas.deletePersistentAll();
				
				Query<Pago> pagos = pm.newQuery(Pago.class);
				pagos.deletePersistentAll();

				//End the transaction
				tx.commit();
					
			} catch (Exception e) {
				System.err.println("* Exception executing a query: " + e.getMessage());
			} finally {
				if (tx.isActive()) {
			        tx.rollback();
			    }
	
			    pm.close();
			}
			
			
			
		} catch (Exception e) {
			System.err.println("* Exception: " + e.getMessage());
		}
	}
}
