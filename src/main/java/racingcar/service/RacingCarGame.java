package racingcar.service;

import racingcar.domain.Attempt;
import racingcar.domain.Cars;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class RacingCarGame {
	private Cars cars;
	private Attempt attempt;

	private final Input input;

	public RacingCarGame() {
		input = new Input();
	}

	public void run() {
		init();
		round();
		win();
	}

	private void init() {
		cars = input.carName();
		attempt = input.attempt();
	}

	private void round() {
		int nowAttempt = 0;

		while (!attempt.isSame(nowAttempt)) {
			cars.play();
			nowAttempt++;
		}
	}

	private void win() {
		List<String> winners = cars.findWinners();
		Output.showResult(winners);
	}
}
