package myartifcat.test.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class OthelloAI extends Othello{

	public static Set<String> generateStep () {
		
		Set<String> possibleSteps = new HashSet <String>();
		allSteps.forEach(step -> possibleSteps.addAll(pickSurrondingStep(step, isXTurn)));
		
		System.out.println ("Possible are : "+possibleSteps.toString());
		return possibleSteps;
	}

	private static Set<String> pickSurrondingStep(String step, boolean generateX) {
		Set<String> possibleNeighbourStep = new HashSet <String>();
		for (int vrtMove = -1 ; vrtMove < 2 ; vrtMove ++) {	
			for (int hozMove = -1 ; hozMove < 2 ; hozMove ++) {	
				Optional<String> neighbourStep = CoordinatesUtils.moveStep (step, vrtMove, hozMove, BoardUtils.checkIsX(step));
				
				
				if (neighbourStep.isPresent()) {
					
					System.out.print("->" + neighbourStep.get());
					if (generateX != BoardUtils.checkIsX(step)) {
						neighbourStep = CoordinatesUtils.swapCoordinate(neighbourStep.get());
					}
					
					if (validSteps(neighbourStep.get())){
						possibleNeighbourStep.add(neighbourStep.get());
					}
				}
			}
		}
		return possibleNeighbourStep;
	}
	
	public static String pickUpRandomSetep (Set<String> possibleSteps) {
		List<String> shuffleList = new ArrayList<String> (possibleSteps);
		Collections.shuffle(shuffleList);
		return shuffleList.size() > 0?shuffleList.get(0):null;
	}
}
