package myprojects.tictactoe.interfaces;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import myprojects.tictactoe.logic.GameState;

public class GUIController {
	
	private GameState gameState = new GameState();
	
	@FXML private Label statusBar;
	
    @FXML
    private void checkCurrentCell(ActionEvent event)  {

    	Button button = (Button) event.getTarget();
    	
    	if (button.getText().equals(" ")) {
    		
    		button.setText(this.gameState.getTurnPlayer().toString());
    		this.updateGameState();
    		
    	}
    	
    }
    
    private void updateGameState() {
    	
    	if (this.gameState.progressGame()) {
    		
    		this.statusBar.setText("Turn Player: "+this.gameState.getTurnPlayer().toString());
    		
    	} else {
    		
    		String turnPlayer = this.gameState.getTurnPlayer().toString();
    		String endGameStatus = (this.gameState.winner()) ? "Player "+turnPlayer+" Wins!!!!" : "Game Over";
    		
    		this.statusBar.setText(endGameStatus);
    		
    	}
    	
    }
}
