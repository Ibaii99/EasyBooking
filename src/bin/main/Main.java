package bin.main;

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
		
		Usuario u = new Usuario("ibai", "ibai@jasnka.es", 20, "BIO");
		Usuario u1 = new Usuario("ibai", "asidhaiubuad@jasnka.es", 20, "BIO");
		Usuario u2 = new Usuario("Jon", "jjj@jojo.com", 19, "BIO");
		Usuario u3 = new Usuario("Gorka", "gor@do.com", 20, "MAD");
		
		Reserva r1 = new Reserva("tarjeta", 2, "8-11-2019");
		Reserva r2 = new Reserva("paypal", 3, "7-11-2019");
		
		Pago p1 = new Pago(u1.getEmail(), 149.98);
		Pago p2 = new Pago("VISA","0000 1111 2222 3333", "06/22", 231.97);
		
		u1.getReservas().add(r1);
		u2.getReservas().add(r2);
		
		
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
				tx.begin();
				// TODO 
				
				
				
				
				
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
