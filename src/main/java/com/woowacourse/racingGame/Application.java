package com.woowacourse.racingGame;

import java.util.ArrayList;
import java.util.List;

import com.woowacourse.racingGame.domain.Cars;
import com.woowacourse.racingGame.domain.CarsFactory;
import com.woowacourse.racingGame.domain.MovementNumber;
import com.woowacourse.racingGame.domain.Result;
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

		// NOTE : Log처럼 기록을 출력하는 것이 맞는지 여부 물어보기.
		final List<Result> results = playRacingGame(cars, movementNumber);

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

	private static List<Result> playRacingGame(final Cars cars, final MovementNumber movementNumber) {
		List<Result> results = new ArrayList<>();

		for (int i = 0; i < movementNumber.getMovementNumber(); i++) {
			attemptMove(cars);
			results.add(new Result(cars));
		}
		return results;
	}

	private static void attemptMove(final Cars cars) {
		cars.attemptMove();
	}

	private static Result getFinalResult(final List<Result> results, final MovementNumber movementNumber) {
		return results.get(movementNumber.getMovementNumber() - 1);
	}
}
