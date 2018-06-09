package myartifcat.test.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class OthelloTest {

	@Test
	public void get_difference_score_board_when_x_winning() {
		Set<String> allSteps = new HashSet <String>();
		allSteps.addAll(Arrays.asList("4c","5b","2d","3d","8e","c3","e4","c2"));
		Othello.allSteps = allSteps;
		String printTxt = Othello.getScoreBoard();
		assertEquals ("X [5] is winning O [3]", printTxt);
	}
	
	@Test
	public void get_difference_score_board_when_o_winning() {
		Set<String> allSteps = new HashSet <String>();
		allSteps.addAll(Arrays.asList("4c","b3","d2","3d","8e","c3","e4","c2"));
		Othello.allSteps = allSteps;
		String printTxt = Othello.getScoreBoard();
		assertEquals ("O [5] is winning X [3]", printTxt);
	}


}
