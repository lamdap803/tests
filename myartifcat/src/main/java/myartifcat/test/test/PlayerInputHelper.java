package myartifcat.test.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlayerInputHelper {

	private static Logger logger = Logger.getLogger(Othello.class.getName());
	
	private BufferedReader bufferReader; 
	
	public PlayerInputHelper(BufferedReader bufferReader) {
		this.bufferReader = bufferReader;
	}

	public Optional<String> getUserInput(boolean isX) {
		String player = isX?"X":"O";
		System.out.println("\nPlease enter next step for ["+ player +"] as " + " or [Exit] or [<Enter> to auto generate]");
		String userInput = null;
		
		boolean waitingInput = true;
		while (waitingInput) {
			userInput = getInput(bufferReader);
			    if (BoardUtils.validBoundaryForBoth(userInput) 
			    		&& BoardUtils.validBoundaryForBoth(userInput) 
			    		&& Othello.validSteps(userInput)
			    		) {
			    	waitingInput = false;
			    } else if (userInput.equalsIgnoreCase("exit")){
			    	userInput = "exit";
			    	waitingInput = false;
			    } else if (userInput.equalsIgnoreCase("")){
			    	userInput = "auto";
			    	waitingInput = false;
			    } else {
			    	System.out.println("Invalid move. Please try again");
			    }
		}
		return Optional.ofNullable(userInput);
	}
	
	public String getInput(BufferedReader bufferReader) {
		try {
			return bufferReader.readLine();
		} catch(IOException ex) {
			logger.log(Level.WARNING, "error", ex);
		}
		return null;
	}
}