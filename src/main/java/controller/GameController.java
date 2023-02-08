package controller;

import racingcar.Car;
import racingcar.CarRepository;
import racingcar.RacingCarGame;
import view.InputView;
import view.OutputView;

import java.util.Arrays;

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
        startRacing(inputView.readNumberOfMoving());
        outputView.printWinners(racingCarGame.getWinners());
    }

    private void startRacing(int numberOfMoving) {
        for (int round = 0; round < numberOfMoving; round++) {
            racingCarGame.moveCars();
            outputView.printCarsStatus(CarRepository.findAll());
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
