package racingcar.controller;

import racingcar.domain.Attempt;
import racingcar.domain.Cars;
import racingcar.domain.RoundResult;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class RacingCarGame {
	private Cars cars;
	private Attempt attempt;
	private final RoundResult roundResult = new RoundResult();

	private final Input input;

	public RacingCarGame() {
		input = new Input();
	}

	public void run() {
		init();
		round();
		win();
	}

	@Override
	public String toString() {
		return "- cars\n" + cars + "- " + attempt;
	}

	private void init() {
		cars = createCars(input.carName());
		attempt = createAttempt(input.attempt());
	}

	private Cars createCars(final String carName) {
		return new Cars(carName);
	}

	private Attempt createAttempt(final String attempt) {
		return new Attempt(attempt);
	}

	private void round() {
		Output.resultTitle();

		int nowAttempt = 0;
		while (!attempt.isSame(nowAttempt++)) {
			cars.play(roundResult);
			roundResult.roundEnd();
		}
		Output.result(roundResult);
	}

	private void win() {
		List<String> winners = cars.findWinners();
		Output.showResult(winners);
	}
}
