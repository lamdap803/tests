package myartifcat.test.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Optional;

public class OthelloRunPartTwo {

	public static void main(String[] args) {
		
		Optional<String> newStep = Optional.empty(); 
		
		System.out.println(Othello.initBoard());
		
		while (!Othello.isEndGame()) {
			
			PlayerInputHelper playerInputHelper = new PlayerInputHelper(new BufferedReader(new InputStreamReader(System.in)));
			newStep = playerInputHelper.getUserInput(Othello.isXTurn);
			if (!newStep.isPresent()) {
				Othello.endGame = true;
			} else if (newStep.get().equalsIgnoreCase("exit")) {
				System.out.println(" Game has force to end");
				break;
			} else if (newStep.get().equalsIgnoreCase("auto")) {
				System.out.println("Generating ....");
				newStep = Optional.ofNullable(OthelloAI.pickUpRandomSetep(OthelloAI.generateStep()));
				if (!newStep.isPresent()) {
					System.out.println(" Generating no more step");
					break;
				}
				System.out.println(" Generated with: " + newStep.get());
			}
			
			//steps = Othello.getSteps(newStep);
			String board = Othello.playGame(newStep.get());
			System.out.println(board);
			System.out.println(Othello.getScoreBoard());
			if (Othello.isEndGame()) {
				break;
			}
			
		}
	}
}