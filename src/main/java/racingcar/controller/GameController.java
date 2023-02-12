package racingcar.controller;

import racingcar.domain.CarRepository;
import racingcar.domain.RacingCarGame;
import racingcar.validator.NumberOfTryValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

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

    private void startRacing(int numberOfTry) {
        while (numberOfTry-- > 0) {
            racingCarGame.repeatRounds();
            OutputView.printCarsStatus(CarRepository.findAll());
        }
    }

    private void addCorrectCars(String carNames) {
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
