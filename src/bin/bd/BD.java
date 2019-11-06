package bin.bd;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import com.sun.jdi.connect.spi.Connection;

public class BD {
	
	public String location = "src/bin/bd/EasyBooking.db"; 
	
	private static Logger logger = Logger.getLogger("BDlogger");
	private static Connection con;
	private static ResultSet rs;
	
	
	public BD() throws SecurityException, IOException {
		// Si se quiere un logger con salida a texto : 
		//FileHandler fh = new FileHandler("BDlogger.txt"); 
		
		 // Logger con salida por consola para monitorizar las acciones que interesen:
		ConsoleHandler fh = new ConsoleHandler();
		logger.addHandler(fh);
		logger.info("Logger created succesfully."); 
	
	}
	
	
	
}
