package racingcar.controller;

import racingcar.domain.CarRepository;
import racingcar.domain.RacingCarGame;
import racingcar.validator.NumberOfTryValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final RacingCarGame racingCarGame;
    private final InputView inputView;
    private final OutputView outputView;
    
    public GameController(InputView inputView, OutputView outputView, RacingCarGame racingCarGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarGame = racingCarGame;
    }

    public void run() {
        addCorrectCars(readCarNames());
        startRacing(getCorrectNumberOfTry());
        outputView.printWinners(racingCarGame.getWinners());
    }

    private int getCorrectNumberOfTry() {
        try {
            String numberOfTry = readNumberOfTry();
            NumberOfTryValidator.validate(numberOfTry);
            return Integer.parseInt(numberOfTry);
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printException(illegalArgumentException.getMessage());
            return getCorrectNumberOfTry();
        }
    }

    private String readNumberOfTry() {
        outputView.readNumberOfTry();
        return inputView.readNumberOfTry();
    }

    private void startRacing(int numberOfTry) {
        while (numberOfTry-- > 0) {
            racingCarGame.repeatRounds();
            outputView.printCarsStatus(CarRepository.findAll());
        }
    }

    private void addCorrectCars(String carNames) {
        try {
            racingCarGame.addCars(carNames);
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printException(illegalArgumentException.getMessage());
            addCorrectCars(readCarNames());
        }
    }

    private String readCarNames() {
        outputView.readCarNames();
        return inputView.readCarNames();
    }
}
