package racingcar.controller;

import java.util.List;
import java.util.Objects;

import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.Round;
import racingcar.domain.WinningRule;
import racingcar.view.OutputView;

/**
 * 자동차 경주 진행 클래스
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/13
 */
public class RacingGame {
	private final Cars cars;
	private final Round round;
	private final RandomNumberGenerator randomNumberGenerator;

	public RacingGame(final Cars cars, final Round round, final RandomNumberGenerator randomNumberGenerator) {
		this.cars = Objects.requireNonNull(cars);
		this.round = Objects.requireNonNull(round);
		this.randomNumberGenerator = Objects.requireNonNull(randomNumberGenerator);
	}

	public void run() {
		OutputView.printFirstRoundResult(cars);
		while (!round.isFinal()) {
			cars.moveAll(randomNumberGenerator);
			round.next();
			OutputView.printRoundResult(cars);
		}
		WinningRule winningRule = cars.getWinningRule();
		List<Name> winnerNames = winningRule.decideWinners();
		OutputView.printWinnerNames(winnerNames);
	}
}
