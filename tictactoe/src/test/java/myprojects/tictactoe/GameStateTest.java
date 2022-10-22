package myprojects.tictactoe;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import myprojects.tictactoe.logic.GameState;

/**
 * Unit test for simple App.
 */
public class GameStateTest 
{
	
	GameState gameState = new GameState();

	@Test
    public void winnerIsFalseAndCurrentTurnLessThanMaxTurns() {
    	
    	this.gameState.setCurrentTurn(5);
    	
        assertTrue( this.gameState.progressGame() );
        
    }
	
	@Test
    public void winnerIsFalseAndCurrentTurnEqualsMaxTurns() {
    	
    	this.gameState.setCurrentTurn(8);
    	
        assertTrue( this.gameState.progressGame() );
        
    }
	
	@Test
    public void winnerIsFalseAndCurrentTurnGreaterThanMaxTurns() {
    	
    	this.gameState.setCurrentTurn(10);
    	
        assertFalse( this.gameState.progressGame() );
        
    }
	
	@Test
    public void winnerIsTrueAndCurrentTurnLessThanMaxTurns() {
    	
    	this.gameState.setCurrentTurn(5);
    	this.gameState.playerWon();
    	
        assertFalse( this.gameState.progressGame() );
        
    }
	
	@Test
    public void winnerIsTrueAndCurrentTurnEqualsMaxTurns() {
    	
    	this.gameState.setCurrentTurn(8);
    	this.gameState.playerWon();
    	
        assertFalse( this.gameState.progressGame() );
        
    }
	
	@Test
    public void winnerIsTrueAndCurrentTurnGreaterThanMaxTurns() {
    	
    	this.gameState.setCurrentTurn(10);
    	this.gameState.playerWon();
    	
        assertFalse( this.gameState.progressGame() );
        
    }
}
