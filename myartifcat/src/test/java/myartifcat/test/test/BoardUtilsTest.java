package myartifcat.test.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardUtilsTest {

	@Test
	public void validCordinate_for_any_string() {
		// Is X Test
		assertTrue(BoardUtils.validCordinate(true, "1a"));
		assertTrue(BoardUtils.validCordinate(true, "2b"));
		assertFalse(BoardUtils.validCordinate(true, "b3"));
		assertFalse(BoardUtils.validCordinate(true, "22"));
		assertFalse(BoardUtils.validCordinate(true, "ee"));
		assertFalse(BoardUtils.validCordinate(true, "7e7"));
		assertFalse(BoardUtils.validCordinate(true, "ae7"));
		// Is O Test
		assertTrue(BoardUtils.validCordinate(false, "a1"));
		assertTrue(BoardUtils.validCordinate(false, "d5"));
		assertFalse(BoardUtils.validCordinate(false, "1a"));
		assertFalse(BoardUtils.validCordinate(false, "22"));
		assertFalse(BoardUtils.validCordinate(false, "dd"));
		assertFalse(BoardUtils.validCordinate(false, "d4a"));
		assertFalse(BoardUtils.validCordinate(false, "aa1"));
	}
	
	@Test
	public void validCordinateForBoth_for_any_string() {
		assertTrue(BoardUtils.validCordinateForBoth("1a"));
		assertTrue(BoardUtils.validCordinateForBoth("b3"));
		assertFalse(BoardUtils.validCordinateForBoth("22"));
		assertFalse(BoardUtils.validCordinateForBoth("ee"));
		assertFalse(BoardUtils.validCordinateForBoth("7e7"));
		assertFalse(BoardUtils.validCordinateForBoth("d4a"));
		assertFalse(BoardUtils.validCordinateForBoth( "ae7"));
	}
	
	@Test
	public void validBoundary() {
		// for X
		assertTrue(BoardUtils.validBoundary(true, "1a"));
		assertTrue(BoardUtils.validBoundary(true, "8h"));
		assertFalse(BoardUtils.validBoundary(true, "9b"));
		assertFalse(BoardUtils.validBoundary(true, "2i"));
		// for O
		assertTrue(BoardUtils.validBoundary(false, "a1"));
		assertTrue(BoardUtils.validBoundary(false, "h8"));
		assertFalse(BoardUtils.validBoundary(false, "9a"));
		assertFalse(BoardUtils.validBoundary(false, "2i"));
	}
	
	@Test
	public void validBoundaryForBoth() {
		assertTrue(BoardUtils.validBoundaryForBoth("1a"));
		assertTrue(BoardUtils.validBoundaryForBoth("b3"));
		assertFalse(BoardUtils.validBoundaryForBoth("9a"));
		assertFalse(BoardUtils.validBoundaryForBoth("a9"));
		assertFalse(BoardUtils.validBoundaryForBoth("2o"));
		assertFalse(BoardUtils.validBoundaryForBoth("o2"));
		assertFalse(BoardUtils.validBoundaryForBoth("7e7"));
		assertFalse(BoardUtils.validBoundaryForBoth("d4a"));
		assertFalse(BoardUtils.validBoundaryForBoth( "ae7"));
	}
	
	@Test
	public void checking_isX (){
		assertTrue(BoardUtils.checkIsX("3d"));
		assertFalse(BoardUtils.checkIsX("d3"));
		assertFalse(BoardUtils.checkIsX("9d"));
		assertFalse(BoardUtils.checkIsX("dd"));
		assertFalse(BoardUtils.checkIsX("33"));
		assertFalse(BoardUtils.checkIsX("d3a"));
	}

}
