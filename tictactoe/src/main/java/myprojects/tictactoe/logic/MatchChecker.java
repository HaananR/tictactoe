package myprojects.tictactoe.logic;

public class MatchChecker implements Runnable {

	private Direction direction;
	private static String[][] gameBoard;
	private static boolean matchFound = false;
	
	
	MatchChecker(Direction direction) {
		
		this.direction = direction;
		
	}


	@Override
	public void run() {
		
		switch (this.direction) {
		
			case DIAGONAL:
				this.diagonalCheck();
				break;
				
			case HORIZONTAL:
				this.horizontalCheck();
				break;
				
			case VERTICAL:
				this.verticalCheck();
		
		}
		
	}
	
	static void setGameBoard(String[][] array) {
		
		gameBoard = array;
		
	}
	
	static boolean matchFound() {
		
		return matchFound;
		
	}	
	
	private boolean isTicTacToe(int row, int column, int rowIncrement, int columnIncrement, int lastRowIndex, int lastColumnIndex) {
						
		for (; row != lastRowIndex || column != lastColumnIndex; row += rowIncrement, column += columnIncrement) {
			
			String cell1 = this.gameBoard[row][column];
			String cell2 = this.gameBoard[row+rowIncrement][column+columnIncrement];
			
			if ( !cell1.equals(cell2) || ( cell1.equals(" ") || cell2.equals(" ")) ) {
				
				return false;
				
			}

		}
						
		return true;
		
	}
	
	private void diagonalCheck() {
		
		int row = 0, column = 0, rowIncrement = 1, columnIncrement = 1, lastRowIndex = 2, lastColumnIndex = 2;
		
		for (int diagonal = 1; !matchFound && diagonal <= 2; diagonal += 1) {

			if (this.isTicTacToe(row, column, rowIncrement, columnIncrement, lastRowIndex, lastColumnIndex)) {
				
				matchFound = true;
				
			}
						
			column = 2; columnIncrement = -1; lastRowIndex = 2; lastColumnIndex = 0;
			
		}
		
				
	}
	
	private void horizontalCheck() {
		
	}
	
	private void verticalCheck() {
		
	}
	

	
}
