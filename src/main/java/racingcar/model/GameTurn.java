package racingcar.model;

import racingcar.service.CheckingService;

public class GameTurn {
	private int gameTurn;
	
	public GameTurn(String gameTurn) {
		CheckingService.checkGameTurnNumber(gameTurn);
		this.gameTurn = Integer.parseInt(gameTurn);
	}

	public boolean isPositive() {
		return gameTurn > 0;
	}

	public void removeTurn() {
		gameTurn--;
	}
}
