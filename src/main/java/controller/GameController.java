package controller;

import racingcar.Car;
import racingcar.CarRepository;
import racingcar.RacingCarGame;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static constant.Constants.COMMA_NOT_ALLOWED_EXCEPTION;
import static constant.Constants.TRIAL_INPUT_EXCEPTION;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarGame racingCarGame;

    public GameController(OutputView outputView) {
        this.inputView = new InputView(outputView);
        this.outputView = outputView;
        this.racingCarGame = new RacingCarGame();
    }

    public void run() {
        CarRepository.updateCars(makeCars());
        startRacing(readNumberOfMoving());
        outputView.printWinners(racingCarGame.getWinners());
    }

    private List<Car> makeCars() {
        try {
            String carNames = inputView.readCarNames();
            return Arrays.stream(carNames.split(","))
                    .filter(this::validateCarName)
                    .map(Car::new)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printException(illegalArgumentException.getMessage());
            return makeCars();
        }
    }

    private boolean validateCarName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(COMMA_NOT_ALLOWED_EXCEPTION);
        }
        return true;
    }

    private int readNumberOfMoving() {
        try {
            int numberOfMoving = inputView.readNumberOfMoving();
            validateTrial(numberOfMoving);
            return numberOfMoving;
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception.getMessage());
            return readNumberOfMoving();
        }
    }

    private void validateTrial(int numberOfMoving) {
        if (numberOfMoving < 1) {
            throw new IllegalArgumentException(TRIAL_INPUT_EXCEPTION);
        }
    }

    private void startRacing(int numberOfMoving) {
        for (int round = 0; round < numberOfMoving; round++) {
            racingCarGame.repeatRounds();
            outputView.printCarsStatus(CarRepository.findAll());
        }
    }
}
