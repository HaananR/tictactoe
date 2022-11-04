package myprojects.tictactoe.logic;

import java.util.ArrayList;

public class MatchCheckerManager {

	private ArrayList<MatchChecker> matchCheckers;
	
	MatchCheckerManager() {
		
		this.matchCheckers = new ArrayList<>();
		this.matchCheckers.add(new MatchChecker(Direction.DIAGONAL));
		this.matchCheckers.add(new MatchChecker(Direction.HORIZONTAL));
	//	this.matchCheckers.add(new MatchChecker(Direction.VERTICAL));
		
	}
	
	void setGameBoard(String[][] gameBoard) {
		
		MatchChecker.setGameBoard(gameBoard);
		
	}
	
	void add(MatchChecker matchChecker) {
		
		this.matchCheckers.add(matchChecker);
		
	}
	
	boolean matchFound() {
		
		for (MatchChecker matchChecker : this.matchCheckers) {
			
			matchChecker.run();
			
		}
		
		if (MatchChecker.matchFound()) {
			
			return true;
			
		}
		
		return false;
		
	}
	
}
