package racingcar.controller;

import java.io.IOException;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.car.CarNameAndPosition;
import racingcar.model.car.Cars;
import racingcar.model.value.GameRound;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private static final int RANDOM_LOWER_BOUND = 0;
    private static final int RANDOM_UPPER_BOUND = 10;

    public void playGame() {
        Cars cars = inputCars();
        GameRound gameRound = inputGameRound();

        race(cars, gameRound);
        terminateGame(cars);
    }

    private Cars inputCars() {
        try {
            return new Cars(InputView.inputCarNames());
        } catch (IllegalArgumentException | IOException e) {
            OutputView.printException(e);
            return inputCars();
        }
    }

    private GameRound inputGameRound() {
        try {
            return GameRound.fromString(InputView.inputGameRound());
        } catch (IllegalArgumentException | IOException e) {
            OutputView.printException(e);
            return inputGameRound();
        }
    }

    private void race(Cars cars, GameRound gameRound) {
        OutputView.printStartMessage();
        while (gameRound.continuable()) {
            cars.moveAll(RandomNumberGenerator.fromBounds(RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND));
            OutputView.printCurrentCarNameAndPosition(getCarsNameAndPosition(cars));
            gameRound.proceed();
        }
    }

    private void terminateGame(Cars cars) {
        OutputView.printCurrentCarNameAndPosition(getCarsNameAndPosition(cars));
        OutputView.printWinners(cars.getWinners());
    }

    private List<CarNameAndPosition> getCarsNameAndPosition(Cars cars) {
        return cars.getCars().stream()
                .map(CarNameAndPosition::new)
                .collect(Collectors.toList());
    }
}

