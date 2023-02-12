package controller;

import racingcar.CarRepository;
import racingcar.RacingCarGame;
import validator.NumberOfTryValidator;
import view.InputView;
import view.OutputView;

public class GameController {
    
    private final RacingCarGame racingCarGame;

    public GameController() {
        this.racingCarGame = new RacingCarGame();
    }

    public void run() {
        addCorrectCars(readCarNames());
        startRacing(getCorrectNumberOfTry());
        OutputView.printWinners(racingCarGame.getWinners());
    }

    private int getCorrectNumberOfTry() {
        try {
            String numberOfTry = readNumberOfTry();
            NumberOfTryValidator.validate(numberOfTry);
            return Integer.parseInt(numberOfTry);
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printException(illegalArgumentException.getMessage());
            return getCorrectNumberOfTry();
        }
    }

    private static String readNumberOfTry() {
        OutputView.readNumberOfTry();
        return InputView.readNumberOfTry();
    }

    private void startRacing(final int numberOfTry) {
        for (int trial = 0; trial < numberOfTry; trial++) {
            racingCarGame.repeatRounds();
            OutputView.printCarsStatus(CarRepository.findAll());
        }
    }

    private void addCorrectCars(final String carNames) {
        try {
            racingCarGame.addCars(carNames);
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printException(illegalArgumentException.getMessage());
            addCorrectCars(readCarNames());
        }
    }

    private static String readCarNames() {
        OutputView.readCarNames();
        return InputView.readCarNames();
    }
}