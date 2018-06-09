package myartifcat.test.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class BoardPrintHelperTest {

	@Test
	public void printBoard() {
		Set<String> allSteps = new HashSet<String>();
		allSteps.add("e2");
		allSteps.add("a4");
		allSteps.add("4e");
		allSteps.add("6a");
		
		String actual = BoardPrintHelper.printBoard(allSteps, 8, 8);
		String expect = "1--------\n" + 
						"2----O---\n" + 
						"3--------\n" + 
						"4O---X---\n" + 
						"5--------\n" + 
						"6X-------\n" + 
						"7--------\n" + 
						"8--------\n" + 
						" abcdefgh";
		assertEquals(expect, actual);
	}
}