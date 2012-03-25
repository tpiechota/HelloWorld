import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class loggingErrors {

	private static Logger logger = Logger.getLogger("");
	FileHandler h = new FileHandler("mylog.txt");
	
	
	/***
	 *
	 * Author: Tomasz Piechota
	 *  
	 ***/


	boolean testOK;
	boolean isNumber;
	String fName;

	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	
	public loggingErrors() throws SecurityException, IOException{

	
		//Send logger output to our
		logger.addHandler(h);
		
		//Request that every detail gets logged.
		logger.setLevel(Level.ALL);
		
		//Log a simple INFO
		logger.info("My Info - Error log");
		
		
		
		try{
			
			enterName();  
			
		
		}catch (Error ex){
			
			testOK =  false;
			
			//logger.log(Level.WARNING, "trouble sneezing", ex);
			logger.log(Level.WARNING, "trouble processing input", ex);
			
		}
		
		logger.fine("done");
		
		System.out.println("Users First Name: " + fName);

		
	}
	
	
	public void enterName(){
		
		do{// First Name BEGIN.
			
			System.out.print("ENTER FIRST NAME.......: ");
			
			testOK =  true;
			isNumber = true;
			
			try{
				
				fName = reader.readLine();
				
		    	// Validates if FirstName is a number.
				try{
		    		
		    		Integer.parseInt(fName);
		    		
		    		isNumber = true;
		    		
		    	}catch( Exception e){

		    		isNumber = false;

		    	}
		    	
				//Checks if the user entered any value and it is at least 3 characters long.
				if(fName.isEmpty() || fName.length() <= 3){
				
					testOK = false;
					
					logger.log(Level.SEVERE, "User input too short (min. 3 characters)");

					System.out.println("*** ERROR! TRY AGAIN (min. 3 characters) ***");
					System.out.println();
				
				}else if(isNumber == true){// If the input is a number testOK = false.
					
					testOK = false;
					
					logger.log(Level.WARNING, "User entered Integer value instead String/Char.");
					
					System.out.println("*** ERROR! NO NUMBERS ALLOWED! TRY AGAIN ***");
					System.out.println();
					
				}else if(fName.contains(" ")){// If the input contains spaces " " then testOK = false.
					
					testOK = false;
					
					logger.log(Level.WARNING, "User entered blank characters.");
					
					System.out.println("*** ERROR! NO SPACES ALLOWED! TRY AGAIN ***");
					System.out.println();
					
				}else{
					
					testOK = true;
					
				}
				
			}catch(Exception e){
				
				testOK = false;
				
				logger.log(Level.WARNING, "trouble processing input", e);
				
				System.out.println("*** ERROR! TRY AGAIN ***");
				System.out.println();
				
			}
			
		}while(!testOK);// First Name END.
		
		
	}
	
	public static void main (String [] args){

		try {
			
			new loggingErrors();
			
		} catch (SecurityException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}

}