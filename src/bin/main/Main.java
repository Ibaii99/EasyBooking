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
		
		Usuario u1 = new Usuario("ibai", "asidhaiubuad@jasnka.es", 20, "BIO");
		Usuario u2 = new Usuario("Jon", "jjj@jojo.com", 19, "BIO");
		Usuario u3 = new Usuario("Gorka", "gor@do.com", 20, "MAD");
		Usuario u4 = new Usuario("Yeray","yeray@elcrack.com",20,"BCN");
		
		
		
		Reserva r1 = new Reserva("tarjeta", 2, "8-11-2019");
		Reserva r2 = new Reserva("paypal", 3, "7-11-2019");
		
		Pago p1 = new Pago(u1.getEmail(), 149.98);
		Pago p2 = new Pago("VISA","0000 1111 2222 3333", "06/22", 231.97);
		

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
				usuarios.deletePersistentAll();

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
