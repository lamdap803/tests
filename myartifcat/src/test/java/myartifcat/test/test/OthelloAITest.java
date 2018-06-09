package myartifcat.test.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class OthelloAITest {

	@Test
	public void find_expected_steps_for_x() {
		OthelloAI.isXTurn = true;
		Set<String> expectSteps = new HashSet <String>();
		expectSteps.addAll(Arrays.asList("3d","5f","4c","6e"));
		
		Set<String> possibleSteps = OthelloAI.generateStep();
		System.out.println(possibleSteps);
		for (String eachPossibleStep : possibleSteps) {
			assertTrue (expectSteps.contains(eachPossibleStep));
		}
	}
	
	@Test
	public void find_expected_steps_for_o() {
		OthelloAI.isXTurn = false;
		Set<String> expectSteps = new HashSet <String>();
		expectSteps.addAll(Arrays.asList("c5","d6","e3","f4"));
		
		Set<String> possibleSteps = OthelloAI.generateStep();
		System.out.println(possibleSteps);
		for (String eachPossibleStep : possibleSteps) {
			assertTrue (expectSteps.contains(eachPossibleStep));
		}
	}	
	
	@Test
	public void pick_up_random_set() {
		OthelloAI.isXTurn = true;
		Set<String> expectSteps = new HashSet <String>();
		expectSteps.addAll(Arrays.asList("3d","5f","4c","6e"));
		
		Set<String> possibleSteps = OthelloAI.generateStep();
		String actual = OthelloAI.pickUpRandomSetep(possibleSteps);
		assertTrue (expectSteps.contains(actual));
		
	}	
	
	

}
