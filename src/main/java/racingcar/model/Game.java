package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
			play();
			gameResult.add(cars.getPresentCars());
		}
	}

	private void play() {
		roundCount.moveNextRound();
		cars.startRound();
	}

	public List<Cars> getGameResult() {
		return gameResult;
	}

	public List<String> getWinners() {
		return cars.findWinner().stream().map(RacingCar::getName).collect(Collectors.toUnmodifiableList());
	}
}
