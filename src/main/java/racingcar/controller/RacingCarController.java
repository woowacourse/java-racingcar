package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumberGenerator;
import racingcar.dto.CarStatus;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {
    private final RacingGame racingGame;

    public RacingCarController() {
        this.racingGame = initGame();
    }

    public void run() {
        OutputView.printResultMessage();
        race();
        showFinalResult();
    }

    private RacingGame initGame() {
        Cars cars = createCars();
        int tries = getTries();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        return new RacingGame(cars, tries, numberGenerator);
    }

    private Cars createCars() {
        try {
            String input = InputView.inputCarNames();
            List<String> carNames = splitCarNames(input);
            return new Cars(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createCars();
        }
    }

    private List<String> splitCarNames(String input) {
        return List.of(input.split(","));
    }

    private int getTries() {
        try {
            return InputView.inputTries();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getTries();
        }
    }

    private void race() {
        while (!racingGame.isFinish()) {
            List<CarStatus> turnResult = racingGame.takeOneTurn();
            OutputView.printCarStatus(turnResult);
        }
    }

    private void showFinalResult() {
        List<CarStatus> finalPosition = racingGame.getFinalPosition();
        OutputView.printCarStatus(finalPosition);
        prizeWinner();
    }

    private void prizeWinner() {
        List<String> winnersName = racingGame.getWinnersName();
        OutputView.printFinalResult(winnersName);
    }
}
