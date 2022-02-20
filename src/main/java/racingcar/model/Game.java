package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private final Cars cars;
	private final RoundCount roundCount;
	private final List<Cars> gameResult;

	public Game(final Cars cars, final RoundCount roundCount) {
		this.cars = cars;
		this.roundCount = roundCount;
		this.gameResult = new ArrayList<>();
	}

	public void run() {
		while (roundCount.isEnd()) {
			playGame();
			gameResult.add(cars.getThisRoundResult());
		}
	}

	private void playGame() {
		roundCount.moveNextRound();
		cars.startRound();
	}

	public List<Cars> getResult() {
		return gameResult;
	}

	public List<String> getWinners() {
		return cars.findWinner();
	}
}
