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
			
			PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();				
			Transaction transaction = persistentManager.currentTransaction();	
			try {
				transaction.begin();
				// 	TODO 
				System.out.println("- Inserted into db: ");
				transaction.commit();
			} catch (Exception e) {
				System.err.println("* Exception inserting data into db: " + e.getMessage());
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
