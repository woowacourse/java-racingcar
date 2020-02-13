package com.woowacourse.racingGame;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.woowacourse.racingGame.controller.RacingGame;
import com.woowacourse.racingGame.domain.Cars;
import com.woowacourse.racingGame.domain.MovementNumber;
import com.woowacourse.racingGame.domain.Result;
import com.woowacourse.racingGame.utils.CarsFactory;
import com.woowacourse.racingGame.view.InputView;
import com.woowacourse.racingGame.view.OutputView;

public class Application {
	private static InputView inputview;
	private static OutputView outputView;

	public static void main(String[] args) {
		inputview = new InputView();
		outputView = new OutputView();

		final Cars cars = generateCars();
		final MovementNumber movementNumber = receiveInputMovementNumber();
		final RacingGame racingGame = new RacingGame(cars);

		final List<Result> results = playRacingGame(racingGame, movementNumber);

		outputView.printRacingGameResult(results);
		outputView.printWinners(getFinalResult(results, movementNumber));
	}

	private static Cars generateCars() {
		try {
			final String carName = inputview.inputCarName();
			return CarsFactory.generate(carName);
		} catch (IllegalArgumentException e) {
			outputView.printExceptionMessage(e.getMessage());
			return generateCars();
		}
	}

	private static MovementNumber receiveInputMovementNumber() {
		try {
			final String movementNumber = inputview.inputMovementNumber();
			return new MovementNumber(movementNumber);
		} catch (IllegalArgumentException e) {
			outputView.printExceptionMessage(e.getMessage());
			return receiveInputMovementNumber();
		}
	}

	private static List<Result> playRacingGame(final RacingGame racingGame,
		final MovementNumber movementNumber) {
		return IntStream.range(0, movementNumber.getMovementNumber())
			.mapToObj(i -> racingGame.play())
			.collect(Collectors.toList());
	}

	private static Result getFinalResult(final List<Result> results, final MovementNumber movementNumber) {
		return results.get(movementNumber.getMovementNumber() - 1);
	}
}
