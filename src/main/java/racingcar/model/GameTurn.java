package racingcar.model;

public class GameTurn {
	private int gameTurn;

	public GameTurn(int gameTurn) {
		this.gameTurn = gameTurn;
	}

	public boolean isPositive() {
		return gameTurn > 0;
	}

	public void removeTurn() {
		gameTurn--;
	}
}
