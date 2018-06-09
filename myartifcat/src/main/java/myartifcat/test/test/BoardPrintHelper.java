package myartifcat.test.test;

import java.util.Set;

public class BoardPrintHelper {

	public static String printBoard (Set<String> allSteps, int vrtSize, int horSize) {
	
		String[][] board = new String[vrtSize][horSize];
		for (String currentStep : allSteps) {
			
			int vi = -1;
			int hi = -1;
	
			if (BoardUtils.checkIsX(currentStep))  {
				vi = Integer.valueOf(currentStep.substring(0,1));
				hi = CoordinatesUtils.convertHozIndex(currentStep.charAt(1));
				board [vi-1][hi-1] = "X";
			} else {
				vi = Integer.valueOf(currentStep.substring(1,2));
				hi = CoordinatesUtils.convertHozIndex(currentStep.charAt(0));
				board [vi-1][hi-1] = "O";
			} 
			
		}
		
		StringBuilder fullBoard = new StringBuilder();
		for (int x = 0; x < board.length; x ++) {
		    String subArray[] = board[x]; 
		    StringBuilder line = new StringBuilder();
		    
		    line.append(String.valueOf(x+1));
		    for (int y = 0; y < subArray.length; y ++) {
		        String item = subArray[y];
		        if (item==null) {
		        	item = "-";
		        }
		        line.append(item);
		    }
		    fullBoard.append(line.toString()).append("\n");
		}
		fullBoard.append(" abcdefgh");
		return fullBoard.toString();
	}
}
