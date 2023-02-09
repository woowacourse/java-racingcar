package controller;

import racingcar.Car;
import racingcar.CarRepository;
import racingcar.RacingCarGame;
import view.InputView;
import view.OutputView;

import java.util.Arrays;

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
        makeCars();
        startRacing(readNumberOfMoving());
        outputView.printWinners(racingCarGame.getWinners());
    }

    private void startRacing(int numberOfMoving) {
        // TODO : 시도횟수 RacingCarGame으로 이동하기 (리팩토링
        for (int round = 0; round < numberOfMoving; round++) {
            racingCarGame.repeatRounds();
            outputView.printCarsStatus(CarRepository.findAll());
        }
    }

    private int readNumberOfMoving() {
        try {
            int numberOfMoving = inputView.readNumberOfMoving();
            if (numberOfMoving < 1) {
                throw new IllegalArgumentException(TRIAL_INPUT_EXCEPTION);
            }
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

    private void makeCars() {
        try {
            String carNames = inputView.readCarNames();
            Arrays.stream(carNames.split(","))
                    .map(Car::new)
                    .forEach(CarRepository::updateCars);
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printException(illegalArgumentException.getMessage());
            makeCars();
        }
    }
}
