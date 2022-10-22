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
    		
    		
    	}
    	
    }
    
    private void updateGameState() {
    	
    	System.out.println("THE GAME STATE WILL NOW BE UPDATED");
    	
    }
}
