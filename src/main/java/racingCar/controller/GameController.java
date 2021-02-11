package racingCar.controller;

import java.util.Scanner;
import racingCar.domain.RacingGame;
import racingCar.domain.Round;
import racingCar.domain.car.Cars;
import racingCar.domain.car.Engine.RandomEngine;
import racingCar.domain.car.factory.CarsFactory;
import racingCar.exception.InvalidCarNameException;
import racingCar.exception.InvalidNumOfMoveException;
import racingCar.utils.ValidateUtils;
import racingCar.view.InputView;
import racingCar.view.OutputView;

public class GameController {

    private final InputView inputView;

    public GameController(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public void play() {
        Cars cars = inputCars();
        Round round = inputRacingRound();
        RacingGame racingGame = new RacingGame(cars, round);
        while (!racingGame.isEnd()) {
            racingGame.race();
            OutputView.printCars(cars);
        }
        OutputView.printWinners(cars.findWinners());
    }

    private Cars inputCars() {
        try {
            OutputView.printInputCarNameMessage();
            String[] carNames = inputView.inputCarNames();
            return CarsFactory.create(carNames, new RandomEngine());
        } catch (InvalidCarNameException e) {
            OutputView.printExceptionMessage(e);
            return inputCars();
        }
    }

    private Round inputRacingRound() {
        try {
            OutputView.printInputNumOfRoundMessage();
            return new Round(ValidateUtils.numberedCount(inputView.inputValue()));
        } catch (InvalidNumOfMoveException e) {
            OutputView.printExceptionMessage(e);
            return inputRacingRound();
        }
    }
}
