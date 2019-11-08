package bin.main;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import entidades.usuario.Usuario;


public class Main {

	public static void main(String[] args) {
		
		Usuario u = new Usuario("ibai", "asidhaiubuad@jasnka.es", 20, "BIO");
		
		
		try {
			System.out.println("Entra en el try");
			PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			
			//Insert data in the DB
			PersistenceManager pm = pmf.getPersistenceManager();				
			Transaction tx = pm.currentTransaction();	
			try {
				tx.begin();
				// 	TODO 
				pm.makePersistent(u);
				
				
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
