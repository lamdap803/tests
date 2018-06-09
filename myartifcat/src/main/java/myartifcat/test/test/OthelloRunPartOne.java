package myartifcat.test.test;

public class OthelloRunPartOne {

	public static void main(String[] args) {
		
		
		System.out.println(Othello.initBoard());
		String board = Othello.playGame("f5, 6f, f7, 4f, f3, 3e, d3, 5c");
		System.out.println (board);
	}

}
