package myprojects.tictactoe;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import myprojects.tictactoe.logic.GameState;
import myprojects.tictactoe.logic.MatchChecker;

public class GameStateTest {
	
	GameState gameState = new GameState();
	String[][] blankGameBoard = { {" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "} };
	String[][] winningGameBoard = { {"X", " ", " "}, {" ", "X", " "}, {" ", " ", "X"} };
	
	String expectedTrueErrorMessage = "Expected progessGame() to return true, but returned false.";
	String expectedFalseErrorMessage = "Expected progessGame() to return false, but returned true.";

	@Before
	public void resetMatchChecker() {
		
		MatchChecker.resetMatchChecker();
		
	}
	
	@Test
    public void winnerIsFalseAndCurrentTurnLessThanMaxTurns() {
		
    	this.gameState.setCurrentTurn(5);
    	this.gameState.updateGameBoard(this.blankGameBoard);
    	    	
        assertTrue( this.expectedTrueErrorMessage, this.gameState.progressGame() );
        
    }
	
	@Test
    public void winnerIsFalseAndCurrentTurnEqualsMaxTurns() {
    	
    	this.gameState.setCurrentTurn(8);
    	this.gameState.updateGameBoard(this.blankGameBoard);
    	    	
        assertTrue( this.expectedTrueErrorMessage, this.gameState.progressGame() );
        
    }
	
	@Test
    public void winnerIsFalseAndCurrentTurnGreaterThanMaxTurns() {
    	
    	this.gameState.setCurrentTurn(10);
    	this.gameState.updateGameBoard(this.blankGameBoard);
    	    	
        assertFalse( this.expectedFalseErrorMessage, this.gameState.progressGame() );
        
    }
	
	@Test
    public void winnerIsTrueAndCurrentTurnLessThanMaxTurns() {
    	
    	this.gameState.setCurrentTurn(5);
    	this.gameState.updateGameBoard(this.winningGameBoard);
    	    	
        assertFalse( this.expectedFalseErrorMessage, this.gameState.progressGame() );
        
    }
	
	@Test
    public void winnerIsTrueAndCurrentTurnEqualsMaxTurns() {
    	
    	this.gameState.setCurrentTurn(8);
    	this.gameState.updateGameBoard(this.winningGameBoard);
    	    	
        assertFalse( this.expectedFalseErrorMessage, this.gameState.progressGame() );
        
    }
	
	@Test
    public void winnerIsTrueAndCurrentTurnGreaterThanMaxTurns() {
    	
    	this.gameState.setCurrentTurn(10);
    	this.gameState.updateGameBoard(this.winningGameBoard);
    	    	
        assertFalse( this.expectedFalseErrorMessage, this.gameState.progressGame() );
        
    }
	
	@Test
	public void leftToRightDiagonalMatch() {
		
		this.gameState.setCurrentTurn(1);
		this.gameState.updateGameBoard(this.winningGameBoard);
		    	
        assertFalse( this.expectedFalseErrorMessage, this.gameState.progressGame() );
		
	}
	
	@Test
	public void rightToLeftDiagonalMatch() {
		
		String[][] rtlDiagoanlBoard = { {" ", " ", "X"}, {" ", "X", " "}, {"X", " ", " "} };
		
		this.gameState.setCurrentTurn(1);
		this.gameState.updateGameBoard(rtlDiagoanlBoard);
		    	
        assertFalse( this.expectedFalseErrorMessage, this.gameState.progressGame() );
		
	}
	
	@Test
	public void horizontalMatchRow1() {
		
		String[][] row1Board = { {"X", "X", "X"}, {" ", " ", " "}, {" ", " ", " "} };
		
		this.gameState.setCurrentTurn(1);
		this.gameState.updateGameBoard(row1Board);
		    	
        assertFalse( this.expectedFalseErrorMessage, this.gameState.progressGame() );
		
	}
	
	@Test
	public void horizontalMatchRow2() {
		
		String[][] row2Board = { {" ", " ", " "}, {"X", "X", "X"},  {" ", " ", " "} };
		
		this.gameState.setCurrentTurn(1);
		this.gameState.updateGameBoard(row2Board);
		    	
        assertFalse( this.expectedFalseErrorMessage, this.gameState.progressGame() );
		
	}
	
	@Test
	public void horizontalMatchRow3() {
		
		String[][] row3Board = { {" ", " ", " "}, {" ", " ", " "}, {"X", "X", "X"} };
		
		this.gameState.setCurrentTurn(1);
		this.gameState.updateGameBoard(row3Board);
		    	
        assertFalse( this.expectedFalseErrorMessage, this.gameState.progressGame() );
		
	}
	
	@Test
	public void verticalMatchColumn1() {
		
		String[][] column1Board = { {"X", " ", " "}, {"X", " ", " "}, {"X", " ", " "} };
		
		this.gameState.setCurrentTurn(1);
		this.gameState.updateGameBoard(column1Board);
		    	
        assertFalse( this.expectedFalseErrorMessage, this.gameState.progressGame() );
		
	}
	
	@Test
	public void verticalMatchColumn2() {
		
		String[][] column2Board = { {" ", "X", " "}, {" ", "X", " "}, {" ", "X", " "} };
		
		this.gameState.setCurrentTurn(1);
		this.gameState.updateGameBoard(column2Board);
		    	
        assertFalse( this.expectedFalseErrorMessage, this.gameState.progressGame() );
		
	}
	
	@Test
	public void verticalMatchColumn3() {
		
		String[][] column3Board = { {" ", " ", "X"}, {" ", " ", "X"}, {" ", " ", "X"} };
		
		this.gameState.setCurrentTurn(1);
		this.gameState.updateGameBoard(column3Board);
		    	
        assertFalse( this.expectedFalseErrorMessage, this.gameState.progressGame() );
		
	}
	
}
