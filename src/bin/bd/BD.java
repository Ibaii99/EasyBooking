package bin.bd;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;


public class BD {
	
	public String location = "src/bin/bd/EasyBooking.db"; 
	private String name = "EasyBooking.db"; 
	private static Logger logger = Logger.getLogger("BDlogger");
//	private static Connection con;
//	private static ResultSet rs;
	
	
	public BD() throws SecurityException, IOException {
		// Si se quiere un logger con salida a texto : 
		//FileHandler fh = new FileHandler("BDlogger.txt"); 
		
		 // Logger con salida por consola para monitorizar las acciones que interesen:
		ConsoleHandler fh = new ConsoleHandler();
		logger.addHandler(fh);
		logger.info("Logger created succesfully."); 
	}
	
	public void anyadirABdEjemplo(){


		// Load Persistence Manager Factory - referencing the Persistence Unit defined in persistence.xml
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		// Persistence Manager
		PersistenceManager pm = null;
		//Transaction to group DB operations
		Transaction tx = null;
		
		
		
	}
	
	
	
}
