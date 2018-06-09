package myartifcat.test.test;

import org.apache.commons.lang3.CharUtils;

public class BoardUtils {
	
	public static boolean validCordinate(boolean isX, String cordintate) {
		if (cordintate != null && cordintate.length() != 2) {
			return false;
		}
		if (isX) {
			return CharUtils.isAsciiNumeric(cordintate.charAt(0)) && CharUtils.isAsciiAlpha(cordintate.charAt(1));
		} else {
			return CharUtils.isAsciiNumeric(cordintate.charAt(1)) && CharUtils.isAsciiAlpha(cordintate.charAt(0));
		}
	}
	
	public static boolean validCordinateForBoth (String cordintate) {
		if (!validCordinate (true, cordintate) && !validCordinate (false, cordintate)) {
			return false;
		}
		return true;
	}
	
	public static boolean validBoundary(boolean isCheckingX, String inputString) {
		if (!validCordinateForBoth(inputString)) {
			return false;
		}
		if (isCheckingX) {
			if (inputString.charAt(0) >= BoardConfig.VRT_LOWER_BOUND 
			&& inputString.charAt(0) <= BoardConfig.VRT_UPPER_BOUND  
			&& inputString.charAt(1) >= BoardConfig.HOR_LOWER_BOUND 
			&& inputString.charAt(1) <= BoardConfig.HOR_UPPER_BOUND) {
				return true;
			}
		} else {
			if (inputString.charAt(1) >= BoardConfig.VRT_LOWER_BOUND 
			&& inputString.charAt(1) <= BoardConfig.VRT_UPPER_BOUND  
			&& inputString.charAt(0) >= BoardConfig.HOR_LOWER_BOUND 
			&& inputString.charAt(0) <= BoardConfig.HOR_UPPER_BOUND) {
				return true;
			}
		}
		return false;
	}

	public static boolean validBoundaryForBoth (String cordintate) {
		if (!validBoundary (true, cordintate) && !validBoundary (false, cordintate)) {
			return false;
		}
		return true;
	}
	
	public static boolean checkIsX (String stepCoordinate) {
		if (!validBoundaryForBoth(stepCoordinate)) {
			return false;
		}
		return validCordinate(true, stepCoordinate);
	}
}