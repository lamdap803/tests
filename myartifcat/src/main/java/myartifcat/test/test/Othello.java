package myartifcat.test.test;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

public class Othello {

	private static Logger logger = Logger.getLogger(Othello.class.getName());
	protected static Set<String> allSteps = new HashSet <String>();
	static {
		allSteps.add("d4");
		allSteps.add("4e");
		allSteps.add("5d");
		allSteps.add("e5");
	}
	protected static boolean isXTurn = true;
	
	protected static boolean endGame = false;
	private static final int vrtSize = BoardConfig.VRT_UPPER_BOUND - BoardConfig.VRT_LOWER_BOUND + 1;
	private static final int horSize = BoardConfig.HOR_UPPER_BOUND - BoardConfig.HOR_LOWER_BOUND + 1;
	
	public static String initBoard() {
		String result = BoardPrintHelper.printBoard(allSteps, vrtSize, horSize);
		return result;
	}
	
	public static String playGame(String moves) {
		String[] moveSteps= moves.split(",");
		
		logger.info("Loading Boarding with size " + vrtSize + "x" + horSize);
		
		for (String eachStep : moveSteps) {
			System.out.println("before :" +allSteps.toString() +" <--- " + eachStep);
			
			loadStepToGame(purifyStep (eachStep.trim()));
			
			System.out.println(BoardPrintHelper.printBoard(allSteps, vrtSize, horSize));
			System.out.println("after :" +allSteps.toString());
		}
		
		String result = BoardPrintHelper.printBoard(allSteps, vrtSize, horSize);
		return result;
	}

	private static int loadStepToGame(String lastStep) {
		return loadStepToGame(lastStep, true);
	}
	
	private static int loadStepToGame(String currentStep, boolean flipStep) {
		int numOfFlips = 0;
		for (int vrtMove = -1 ; vrtMove < 2 ; vrtMove ++) {	
			for (int hozMove = -1 ; hozMove < 2 ; hozMove ++) {	
				Optional<String> destinateStep = findAllies(allSteps, currentStep, vrtMove, hozMove); 
				if (destinateStep.isPresent()) {
					if (flipStep) {
						allSteps.add(currentStep);
					}
					numOfFlips = numOfFlips + flipToAllies (allSteps, currentStep, destinateStep.get(), vrtMove, hozMove, flipStep);
				}
			}
		}
		return numOfFlips;
	}
	
	private static int flipToAllies(Set<String> allSteps, String startStep, String destStep, int vrtDirection, int hozDireztion, boolean flip) {
		boolean continueFlip = true;
		int numOfFlips = 0;
		Optional<String> nextStep = Optional.of(startStep);
		while (continueFlip) {
			nextStep = CoordinatesUtils.moveStep (nextStep.get(), vrtDirection, hozDireztion, BoardUtils.checkIsX(nextStep.get())); 
			if (nextStep.orElse(null).equals(destStep)) {
				continueFlip = false;
				continue;
			}
			Optional<String> swapStep = CoordinatesUtils.swapCoordinate(nextStep.get());
			if (swapStep.isPresent() && allSteps.contains(swapStep.get())) {
				if (flip) {
					allSteps.remove(swapStep.get());
					allSteps.add(nextStep.get());
					isXTurn = !isXTurn;
				}
				numOfFlips++;
			}
		}
		return numOfFlips;
	}

	private static Optional<String> findAllies (Set<String> allSteps, String startStep, int vrtDrt, int hozDrt) {
		if (vrtDrt == 0 && hozDrt == 0) {
			return Optional.empty();
		}
		Optional<String> nextOne = Optional.of(startStep);
		boolean isX = BoardUtils.checkIsX(nextOne.get());
		
		boolean keepChecking = true;
		while (keepChecking) {
			nextOne = CoordinatesUtils.moveStep (nextOne.get(), vrtDrt, hozDrt, isX);
			if (nextOne.isPresent()) {
				if (allSteps.contains(nextOne.get())) {
					// Found Same Kind
					keepChecking = false;
				} else if (!allSteps.contains(CoordinatesUtils.swapCoordinate(nextOne.get()).get())) {
					// Found Space
					keepChecking = false;
					nextOne = Optional.empty();
				}
			} else {	
				keepChecking = false;
			}
		}
		return nextOne;
	}

	public static String getScoreBoard() {
		int counterX = 0;
		int counterO = 0;
		for (String currentStep : allSteps) { 
			if (BoardUtils.checkIsX(currentStep)) {
				counterX ++;
			} else {
				counterO ++;
			}
		}
		
		if ((counterX+counterO) >= (vrtSize * horSize)) {
			System.out.println ("Game is ending with below ....");
			endGame = true;
		}
			
		if (counterX > counterO) {
			return String.format("X [%s] is winning O [%s]", counterX, counterO);
		} else if (counterX == counterO) {
			return String.format("X [%s] is drawing with O [%s]", counterX, counterO);
		} else {
			return String.format("O [%s] is winning X [%s]", counterO, counterX);
		}
		
	}

	public static boolean isEndGame() {
		return endGame;
	}

	public static String getSteps(Optional<String> lastStep) {
		StringBuilder allStepCSV = new StringBuilder ();
		for (String step : allSteps) {
			allStepCSV.append(step);
			allStepCSV.append(",");
		}
		if (lastStep.isPresent()) {
			return allStepCSV.append(lastStep.get()).substring(0, allStepCSV.length());
		}  
		return allStepCSV.substring(0, allStepCSV.length()-1);
	}

	private static String purifyStep(String eachStep) {
		if ((isXTurn && !BoardUtils.checkIsX(eachStep)) || (!isXTurn && BoardUtils.checkIsX(eachStep))) {
			return CoordinatesUtils.swapCoordinate(eachStep).orElse(null);
		} 
		return eachStep;
	}
	
	public static boolean validSteps(String userInput) {
		String validStep = purifyStep(userInput);
		if (allSteps.contains(validStep) || allSteps.contains(CoordinatesUtils.swapCoordinate(validStep).orElse(null))) {
			return false ;
		}
		if (!checkAvailableStep(validStep)) {
			return false;
		}
		return true;
	}

	private static boolean checkAvailableStep(String userInput) {
		if (allSteps.size() > (vrtSize*horSize)) {
			return false;
		}
		
		int numberOfSteps = loadStepToGame(userInput, false);
		if (numberOfSteps <= 0) {
			return false;
		}
		return true;
	}

	
	

	
	
	
	
}
