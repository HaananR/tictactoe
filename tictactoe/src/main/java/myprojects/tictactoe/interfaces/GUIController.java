package myprojects.tictactoe.interfaces;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import myprojects.tictactoe.logic.GameState;

public class GUIController {
	
	@FXML private Label statusBar;
	@FXML private GridPane gameBoard;
	
	private GameState gameState = new GameState();
	
    @FXML
    private void checkCurrentCell(ActionEvent event)  {

    	Button button = (Button) event.getTarget();
    	
    	if (button.getText().equals(" ") && !this.gameState.winner()) {
    		
    		button.setText(this.gameState.getTurnPlayer().toString());
    		this.updateGameState();
    		
    	}
    	
    }
    
    @FXML
    private void restartGame() {
    	
    	this.resetGameBoard();
    	this.gameState = this.gameState.resetGame();
    	
    	this.statusBar.setText("Turn Player: "+this.gameState.getTurnPlayer().toString());
    	
    }
    
    private void resetGameBoard() {
    	
    	ObservableList<Node> gridPaneNodes = this.gameBoard.getChildren();
    	
    	for (Node gridCell : gridPaneNodes) {
    		
    		((Button) gridCell).setText(" ");
    		
    	}
    	
    }
    
    private void updateGameState() {
    	
    	this.gameState.updateGameBoard(this.getGameBoard());
    	
    	if (this.gameState.progressGame()) {
    		
    		this.statusBar.setText("Turn Player: "+this.gameState.getTurnPlayer().toString());
    		
    	} else {
    		
    		String turnPlayer = this.gameState.getTurnPlayer().toString();
    		String endGameStatus = (this.gameState.winner()) ? "Player "+turnPlayer+" Wins!!!!" : "Game Over";
    		
    		this.statusBar.setText(endGameStatus);
    		
    	}
    	
    }
    
    private String[][] getGameBoard() {
    	
    	int maxRows = 3; int maxColumns = maxRows;
    	
    	ObservableList<Node> gridPaneNodes = this.gameBoard.getChildren();
    	String[][] gameBoard = new String[maxRows][maxColumns];
    	
    	int node = 0;
    	
    	for (int row = 0; row < maxRows; row++) {
			
			for (int column = 0; column < maxColumns; column++) {
				
				gameBoard[row][column] = ( (Button) gridPaneNodes.get(node) ).getText();
				
				node++;
				
			}
			
		}
    	    	    	
    	return gameBoard;
    	
    }
    
}
