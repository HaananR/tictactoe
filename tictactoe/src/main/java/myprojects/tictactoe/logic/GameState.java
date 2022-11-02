package myprojects.tictactoe.logic;

public class GameState {

	private Player turnPlayer;
	private boolean winner;
	private final int MAX_TURNS;
	private int currentTurn;
	private MatchCheckerManager mcManager;
	
	public GameState() {
		
		this.turnPlayer = Player.X;
		this.winner = false;
		this.MAX_TURNS = 9;
		this.currentTurn = 1;
		this.mcManager = new MatchCheckerManager();
		
	}
	
	public Player getTurnPlayer() {
		
		return this.turnPlayer;
		
	}
	
	public boolean winner() {
		
		return this.winner;
		
	}
	
	public void setCurrentTurn(int turnNumber) {
		
		this.currentTurn = turnNumber;
		
	}
	
	public void setWinner(boolean winnerStatus) {
		
		this.winner = winnerStatus;
		
	}
	
	public boolean progressGame() {
		
		this.currentTurn++;
		
		if (this.playerWon() || this.currentTurn > this.MAX_TURNS) {
			
			return false;
			
		}
		
		this.changeTurnPlayer();
		
		return true;
		
	}
	
	public GameState resetGame() {
		
		MatchChecker.resetMatchChecker();
		
		return new GameState();
		
	}
	
	private void changeTurnPlayer() {
		
		this.turnPlayer = (this.turnPlayer.equals(Player.X)) ? Player.O : Player.X; 
		
	}
	
	public void updateGameBoard(String[][] gameBoard) {
		
		this.mcManager.setGameBoard(gameBoard);
		
	}
	
	private boolean playerWon() {
		
		this.winner = this.mcManager.matchFound();
		
		return this.winner;
		
	}
	
	
}
