package myartifcat.test.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;

import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

public class PlayerInputHelperTest {

	@Test
	public void get_input_return() throws IOException {
		BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
		Mockito.when(bufferedReader.readLine()).thenReturn("4a");
		PlayerInputHelper playerInputHelper = new PlayerInputHelper (bufferedReader);
		assertEquals("4a", playerInputHelper.getInput(bufferedReader));
	}
	
	@Test
	public void get_input_return_with_execption() throws IOException {
		BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
		Mockito.when(bufferedReader.readLine()).thenThrow(new IOException ("Some Exception"));
		PlayerInputHelper playerInputHelper = new PlayerInputHelper (bufferedReader);
		assertEquals(null, playerInputHelper.getInput(bufferedReader));
	}
	
	@Test
	public void get_user_input_until_the_valid_one() throws IOException {
		BufferedReader bufferedReader = PowerMockito.mock(BufferedReader.class);
		PowerMockito.when(bufferedReader.readLine()).thenReturn("4a","9a", "e7", "aaa", "aa" ,"3d");
		PlayerInputHelper playerInputHelper = new PlayerInputHelper (bufferedReader);
		Optional<String> actual = playerInputHelper.getUserInput(true);
		assertEquals("3d", actual.orElse(null));
	}
	
	@Test
	public void get_user_input_with_exit() throws IOException {
		BufferedReader bufferedReader = PowerMockito.mock(BufferedReader.class);
		PowerMockito.when(bufferedReader.readLine()).thenReturn("exit");
		PlayerInputHelper playerInputHelper = new PlayerInputHelper (bufferedReader);
		Optional<String> actual = playerInputHelper.getUserInput(true);
		assertEquals(Optional.of("exit"), Optional.ofNullable(actual.orElse(null)));
	}
	
	@Test
	public void get_user_input_with_auto() throws IOException {
		BufferedReader bufferedReader = PowerMockito.mock(BufferedReader.class);
		PowerMockito.when(bufferedReader.readLine()).thenReturn("");
		PlayerInputHelper playerInputHelper = new PlayerInputHelper (bufferedReader);
		Optional<String> actual = playerInputHelper.getUserInput(true);
		assertEquals(Optional.of("auto"), Optional.ofNullable(actual.orElse(null)));
	}
}