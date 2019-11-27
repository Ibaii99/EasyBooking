package bin.main;

import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import entidades.pago.Pago;
import entidades.reserva.Reserva;
import entidades.usuario.Usuario;


public class Main {

	public static void main(String[] args) {
		
		Usuario u1 = new Usuario();
		u1.setNombre("ibai");u1.setEmail("asidhaiubuad@jasnka.es");
		u1.setEdad(20);u1.setAeropuerto_preferido("BIO");
		
		Usuario u2 = new Usuario();
		u2.setNombre("Jon");u1.setEmail("jjj@jojo.com");
		u2.setEdad(19);u1.setAeropuerto_preferido("BIO");
		
		Usuario u3 = new Usuario();
		u3.setNombre("Gorka");u3.setEmail("gor@do.com");
		u3.setEdad(20);u3.setAeropuerto_preferido("MAD");
		
		Usuario u4 = new Usuario();
		u4.setNombre("Yeray");u4.setEmail("yeray@elcrack.com");
		u4.setEdad(20);u4.setAeropuerto_preferido("BCN");
		
		
		
		Reserva r1 = new Reserva("tarjeta", 2, "8-11-2019");
		Reserva r2 = new Reserva("paypal", 3, "7-11-2019");
		
		Pago p1 = new Pago();
		p1.setPaypal_email(u1.getEmail());
		p1.setPrecio(149.98);
		Pago p2 = new Pago();
		p2.setTarjeta_tipo("VISA");
		p2.setTarjeta_numero("0000 1111 2222 3333");
		p2.setTarjeta_fecha_caducidad("06/22");
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
				tx.begin();
				// 	TODO 
				pm.makePersistent(u1);
				pm.makePersistent(u2);
				pm.makePersistent(u3);
				pm.makePersistent(u4);
				
				
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
