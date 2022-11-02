package myprojects.tictactoe;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;

import myprojects.tictactoe.logic.GameState;
import myprojects.tictactoe.logic.MatchChecker;

public class GameStateTest {
	
	GameState gameState = new GameState();
	String[][] blankGameBoard = { {" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "} };
	String[][] winningGameBoard = { {"X", " ", " "}, {" ", "X", " "}, {" ", " ", "X"} };

	@Before
	public void resetMatchChecker() {
		
		MatchChecker.resetMatchChecker();
		
	}
	
	@Test
    public void winnerIsFalseAndCurrentTurnLessThanMaxTurns() {
		
    	this.gameState.setCurrentTurn(5);
    	this.gameState.updateGameBoard(this.blankGameBoard);
    	
    	String errorMessage = "Expected progessGame() to return true, but returned false.";
    	
        assertTrue( errorMessage, this.gameState.progressGame() );
        
    }
	
	@Test
    public void winnerIsFalseAndCurrentTurnEqualsMaxTurns() {
    	
    	this.gameState.setCurrentTurn(8);
    	this.gameState.updateGameBoard(this.blankGameBoard);
    	
    	String errorMessage = "Expected progessGame() to return true, but returned false.";
    	
        assertTrue( errorMessage, this.gameState.progressGame() );
        
    }
	
	@Test
    public void winnerIsFalseAndCurrentTurnGreaterThanMaxTurns() {
    	
    	this.gameState.setCurrentTurn(10);
    	this.gameState.updateGameBoard(this.blankGameBoard);
    	
    	String errorMessage = "Expected progessGame() to return false, but returned true.";
    	
        assertFalse( errorMessage, this.gameState.progressGame() );
        
    }
	
	@Test
    public void winnerIsTrueAndCurrentTurnLessThanMaxTurns() {
    	
    	this.gameState.setCurrentTurn(5);
    	this.gameState.updateGameBoard(this.winningGameBoard);
    	
    	String errorMessage = "Expected progessGame() to return false, but returned true.";
    	
        assertFalse( errorMessage, this.gameState.progressGame() );
        
    }
	
	@Test
    public void winnerIsTrueAndCurrentTurnEqualsMaxTurns() {
    	
    	this.gameState.setCurrentTurn(8);
    	this.gameState.updateGameBoard(this.winningGameBoard);
    	
    	String errorMessage = "Expected progessGame() to return false, but returned true.";
    	
        assertFalse( errorMessage, this.gameState.progressGame() );
        
    }
	
	@Test
    public void winnerIsTrueAndCurrentTurnGreaterThanMaxTurns() {
    	
    	this.gameState.setCurrentTurn(10);
    	this.gameState.updateGameBoard(this.winningGameBoard);
    	
    	String errorMessage = "Expected progessGame() to return false, but returned true.";
    	
        assertFalse( errorMessage, this.gameState.progressGame() );
        
    }
	
	@Test
	public void leftToRightDiagonalMatch() {
		
		this.gameState.setCurrentTurn(1);
		this.gameState.updateGameBoard(this.winningGameBoard);
		
		String errorMessage = "Expected progessGame() to return false, but returned true.";
    	
        assertFalse( errorMessage, this.gameState.progressGame() );
		
	}
	
	@Test
	public void rightToLeftDiagonalMatch() {
		
		String[][] rtlDiagoanlBoard = { {" ", " ", "X"}, {" ", "X", " "}, {"X", " ", " "} };
		
		this.gameState.setCurrentTurn(1);
		this.gameState.updateGameBoard(rtlDiagoanlBoard);
		
		String errorMessage = "Expected progessGame() to return false, but returned true.";
    	
        assertFalse( errorMessage, this.gameState.progressGame() );
		
	}
}
