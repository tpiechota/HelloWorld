import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class loggingErrors {
	
	private static Logger logger = Logger.getLogger("");

	
/***
 * 
 * Author: Tomasz Piechota
 * 
 * ***/
	
	public static void main (String [] args) throws Exception{
		
		
	FileHandler h = new FileHandler("mylog.txt");	
	
		//Send logger output to our 
		logger.addHandler(h);
		
		//Request that every detail	gets logged.
		logger.setLevel(Level.ALL);
		
		//Log a simple INFO
		logger.info("My Info - Error log");
		
		try{
			
		}catch (Error ex){
			logger.log(Level.WARNING, "trouble sneezing", ex);
		}
		
		logger.fine("done");
	}
	
}
