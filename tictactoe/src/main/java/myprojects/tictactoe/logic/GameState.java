package myprojects.tictactoe.logic;

public class GameState {

	private Player turnPlayer;
	private boolean winner;
	private final int MAX_TURNS;
	private int currentTurn;
	
	public GameState() {
		
		this.turnPlayer = Player.X;
		this.winner = false;
		this.MAX_TURNS = 9;
		this.currentTurn = 1;
		
	}
	
	public Player getTurnPlayer() {
		
		return this.turnPlayer;
		
	}
	
	public boolean winner() {
		
		return this.winner;
		
	}
	
	public boolean progressGame() {
		
		this.currentTurn++;
		
		if (this.currentTurn > this.MAX_TURNS || this.winner) {
			
			return false;
			
		}
		
		this.changeTurnPlayer();
		
		return true;
		
	}
	
	private void changeTurnPlayer() {
		
		this.turnPlayer = (this.turnPlayer.equals(Player.X)) ? Player.O : Player.X; 
		
	}
	
}
