package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

	private final Cars cars;
	private final RoundCount roundCount;

	public RacingGame(final Cars cars, final RoundCount roundCount) {
		this.cars = cars;
		this.roundCount = roundCount;
	}

	public RacingGameResult run() {
		List<List<RacingGameRecord>> racingGameRecords = new ArrayList<>();
		while (roundCount.isEnd()) {
			play();
			racingGameRecords.add(cars.getPresentCars());
		}
		return new RacingGameResult(racingGameRecords);
	}

	private void play() {
		roundCount.moveNextRound();
		cars.startRound();
	}

	public List<String> getWinners() {
		return cars.findWinner().stream().map(RacingCar::getName).collect(Collectors.toUnmodifiableList());
	}
}
