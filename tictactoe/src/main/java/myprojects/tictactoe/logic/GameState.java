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
	
}
