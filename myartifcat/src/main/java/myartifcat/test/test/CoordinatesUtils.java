package myartifcat.test.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CoordinatesUtils extends BoardUtils{
	
	private static final Map<Character, Integer> transferMap;
	static
	{
		char startChar = BoardConfig.HOR_LOWER_BOUND;
		char endChar = BoardConfig.HOR_UPPER_BOUND;
		transferMap = new HashMap<Character, Integer> ();
		int numbericIndex = 1;
		for (char currentChar = startChar; currentChar <= endChar; currentChar++) {
			transferMap.put (currentChar, numbericIndex);
			numbericIndex++;
		}
	}
	
	public static Optional<String> swapCoordinate (String input) {
		if (!validCordinateForBoth(input)) {
			return Optional.empty();
		}
		
		StringBuilder result = new StringBuilder();
		result.append(input.charAt(1)).append(input.charAt(0));
		return Optional.of(result.toString());
	}
	
	public static Optional<String> moveStep(String startStep, int vrtDrt, int hozDrt, boolean isX) {
		if (!validCordinateForBoth(startStep)) {
			return Optional.empty();
		}
		
		Character yCord = null;
		Character xCord = null;
		if (isX) {
			yCord = startStep.charAt(0);
			xCord = startStep.charAt(1);
		} else {
			yCord = startStep.charAt(1);
			xCord = startStep.charAt(0);
		}
		
		if (vrtDrt == 1) {
			yCord++;
		} else if (vrtDrt == -1) {
			yCord--;
		}
		if (yCord < BoardConfig.VRT_LOWER_BOUND || yCord > BoardConfig.VRT_UPPER_BOUND) {
			return Optional.empty();
		}
		
		if (hozDrt == 1) {
			xCord++;
		} else if (hozDrt == -1) {
			xCord--;
		}
		if (xCord < BoardConfig.HOR_LOWER_BOUND || xCord > BoardConfig.HOR_UPPER_BOUND) {
			return Optional.empty();
		}
		
		StringBuilder combineCoord = new StringBuilder();
		if (isX) {
			combineCoord.append(yCord).append(xCord);
		} else {
			combineCoord.append(xCord).append(yCord);
		}
		return Optional.of(combineCoord.toString());
	}
	
	public static Integer convertHozIndex (Character input) {
		return transferMap.get(input);
	}
	
}
