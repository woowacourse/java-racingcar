package com.woowacourse.racingGame;

import java.util.ArrayList;
import java.util.List;

import com.woowacourse.racingGame.controller.RacingGame;
import com.woowacourse.racingGame.domain.Cars;
import com.woowacourse.racingGame.domain.MovementNumber;
import com.woowacourse.racingGame.domain.Result;
import com.woowacourse.racingGame.utils.CarsFactory;
import com.woowacourse.racingGame.view.Inputview;
import com.woowacourse.racingGame.view.OutputView;

public class Application {
	private static Inputview inputview;
	private static OutputView outputView;
	private static RacingGame racingGame;

	public static void main(String[] args) {
		inputview = new Inputview();
		outputView = new OutputView();

		final Cars cars = generateCarsByInput();
		final MovementNumber movementNumber = generateMovementNumber();
		racingGame = new RacingGame(cars);

		final List<Result> results = playRacingGameAndGetResultFor(movementNumber);
		outputView.printRacingGameResult(results);

		Result finalResult = getFinalResult(results, movementNumber);
		outputView.printWinners(finalResult);
	}

	private static Result getFinalResult(final List<Result> results, final MovementNumber movementNumber) {
		return results.get(movementNumber.getMovementNumber() - 1);
	}

	private static List<Result> playRacingGameAndGetResultFor(final MovementNumber movementNumber) {
		List<Result> results = new ArrayList<>();

		for (int i = 0; i < movementNumber.getMovementNumber(); i++) {
			results.add(racingGame.play());
		}
		return results;
	}

	private static MovementNumber generateMovementNumber() {
		try {
			final String movementNumber = inputview.inputMovementNumber();
			return new MovementNumber(movementNumber);
		} catch (IllegalArgumentException e) {
			outputView.printExceptionMessage(e.getMessage());
			return generateMovementNumber();
		}
	}

	private static Cars generateCarsByInput() {
		try {
			final String carName = inputview.inputCarName();
			return CarsFactory.generate(carName);
		} catch (IllegalArgumentException e) {
			outputView.printExceptionMessage(e.getMessage());
			return generateCarsByInput();
		}
	}
}
