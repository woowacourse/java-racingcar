package racingcar.model;

import racingcar.service.CheckingService;

public class GameTurn {
	private int gameTurn;

	public GameTurn(String gameTurn) {
		CheckingService.checkGameTurnNumber(gameTurn);
		this.gameTurn = Integer.parseInt(gameTurn);
	}

	public boolean checkRemain() {
		return gameTurn > 0;
	}

	public void play() {
		gameTurn--;
	}
}
