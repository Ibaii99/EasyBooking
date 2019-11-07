package bin.main;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;


public class Main {

	public static void main(String[] args) {
		try {
			PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			
			//Insert data in the DB
			PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();				
			Transaction transaction = persistentManager.currentTransaction();	
			try {
				transaction.begin();
				// 	TODO 
				
				
				
				System.out.println("- Inserted into db: ");
				transaction.commit();
			} catch (Exception e) {
				System.err.println("* Exception inserting data into db: " + e.getMessage());
			} finally {
				if (transaction.isActive()) {
					transaction.rollback();
				}
				persistentManager.close();
			}
			
			//Select data using a Query
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			
			try {
				transaction.begin();
				// TODO 
				
				
				
				
				
				transaction.commit();
			} catch (Exception e) {
				System.err.println("* Exception executing a query: " + e.getMessage());
			} finally {
				if (transaction.isActive()) {
			        transaction.rollback();
			    }
	
			    persistentManager.close();
			}
		} catch (Exception e) {
			System.err.println("* Exception: " + e.getMessage());
		}
	}
}
