package myartifcat.test.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoordinatesUtilsTest {

	@Test
	public void move_steps_within_boundary() {
		// for X
		assertEquals("5e", CoordinatesUtils.moveStep("4d", 1, 1, true).orElse(null));
		assertEquals("5d", CoordinatesUtils.moveStep("4d", 1, 0, true).orElse(null));
		assertEquals("5c", CoordinatesUtils.moveStep("4d", 1, -1, true).orElse(null));
		assertEquals("4e", CoordinatesUtils.moveStep("4d", 0, 1, true).orElse(null));
		assertEquals("4d", CoordinatesUtils.moveStep("4d", 0, 0, true).orElse(null));
		assertEquals("4c", CoordinatesUtils.moveStep("4d", 0, -1, true).orElse(null));
		assertEquals("4e", CoordinatesUtils.moveStep("4d", 0, 1, true).orElse(null));
		assertEquals("4d", CoordinatesUtils.moveStep("4d", 0, 0, true).orElse(null));
		assertEquals("4c", CoordinatesUtils.moveStep("4d", 0, -1, true).orElse(null));
		// for O
		assertEquals("e5", CoordinatesUtils.moveStep("d4", 1, 1, false).orElse(null));
		assertEquals("d5", CoordinatesUtils.moveStep("d4", 1, 0, false).orElse(null));
		assertEquals("c5", CoordinatesUtils.moveStep("d4", 1, -1, false).orElse(null));
		assertEquals("e4", CoordinatesUtils.moveStep("d4", 0, 1, false).orElse(null));
		assertEquals("d4", CoordinatesUtils.moveStep("d4", 0, 0, false).orElse(null));
		assertEquals("c4", CoordinatesUtils.moveStep("d4", 0, -1, false).orElse(null));
		assertEquals("e4", CoordinatesUtils.moveStep("d4", 0, 1, false).orElse(null));
		assertEquals("d4", CoordinatesUtils.moveStep("d4", 0, 0, false).orElse(null));
		assertEquals("c4", CoordinatesUtils.moveStep("d4", 0, -1, false).orElse(null));
	}

	@Test
	public void move_steps_at_edge() {
		// for x
		assertEquals(null, CoordinatesUtils.moveStep("1a", -1, 1, true).orElse(null));
		assertEquals(null, CoordinatesUtils.moveStep("1a", -1, 0, true).orElse(null));
		assertEquals(null, CoordinatesUtils.moveStep("1a", -1, -1, true).orElse(null));
		assertEquals("1b", CoordinatesUtils.moveStep("1a", 0, 1, true).orElse(null));
		assertEquals("1a", CoordinatesUtils.moveStep("1a", 0, 0, true).orElse(null));
		assertEquals(null, CoordinatesUtils.moveStep("1a", 0, -1, true).orElse(null));
		assertEquals("2b", CoordinatesUtils.moveStep("1a", 1, 1, true).orElse(null));
		assertEquals("2a", CoordinatesUtils.moveStep("1a", 1, 0, true).orElse(null));
		assertEquals(null, CoordinatesUtils.moveStep("1a", 1, -1, true).orElse(null));
		// for x
		assertEquals(null, CoordinatesUtils.moveStep("h8", -1, 1, false).orElse(null));
		assertEquals("h7", CoordinatesUtils.moveStep("h8", -1, 0, false).orElse(null));
		assertEquals("g7", CoordinatesUtils.moveStep("h8", -1, -1, false).orElse(null));
		assertEquals(null, CoordinatesUtils.moveStep("h8", 0, 1, false).orElse(null));
		assertEquals("h8", CoordinatesUtils.moveStep("h8", 0, 0, false).orElse(null));
		assertEquals("g8", CoordinatesUtils.moveStep("h8", 0, -1, false).orElse(null));
		assertEquals(null, CoordinatesUtils.moveStep("h8", 1, 1, false).orElse(null));
		assertEquals(null, CoordinatesUtils.moveStep("h8", 1, 0, false).orElse(null));
		assertEquals(null, CoordinatesUtils.moveStep("h8", 1, -1, false).orElse(null));
	}
	
	@Test
	public void move_steps_at_invalid_input() {
		assertEquals(null, CoordinatesUtils.moveStep("ee", 1, 1, true).orElse(null));
		assertEquals(null, CoordinatesUtils.moveStep("55", 1, 1, true).orElse(null));
		assertEquals(null, CoordinatesUtils.moveStep("4dd", 1, 1, true).orElse(null));
		assertEquals(null, CoordinatesUtils.moveStep("d44", 1, 1, true).orElse(null));
	}
	
	@Test
	public void swap_cordinate() {
		assertEquals("a4", CoordinatesUtils.swapCoordinate("4a").orElse(null));
		assertEquals("g1", CoordinatesUtils.swapCoordinate("1g").orElse(null));
		assertEquals("8h", CoordinatesUtils.swapCoordinate("h8").orElse(null));
		assertEquals("8h", CoordinatesUtils.swapCoordinate("h8").orElse(null));
		assertEquals(null, CoordinatesUtils.swapCoordinate("4aa").orElse(null));
		assertEquals(null, CoordinatesUtils.swapCoordinate("d4e").orElse(null));
	}
}
