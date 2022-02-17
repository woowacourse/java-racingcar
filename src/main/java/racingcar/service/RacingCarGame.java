package racingcar.service;

import racingcar.domain.Attempt;
import racingcar.domain.Cars;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class RacingCarGame {
	private static final int START_VALUE = 0;

	private final StepGenerator stepGenerator;
	private Cars cars;
	private Attempt attempt;

	public RacingCarGame(StepGenerator stepGenerator) {
		this.stepGenerator = stepGenerator;
	}

	public void run() {
		init();
		round();
		win();
	}

	private void init() {
		cars = Input.carName();
		attempt = Input.attempt();
	}

	private void round() {
		int nowAttempt = START_VALUE;

		while (!attempt.isSame(nowAttempt)) {
			cars.play(stepGenerator);
			Output.roundResult(cars.getCars());
			nowAttempt++;
		}
	}

	private void win() {
		List<String> winners = cars.findWinners();
		Output.showResult(winners);
	}
}
