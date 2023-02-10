package controller;

import racingcar.Car;
import racingcar.CarRepository;
import racingcar.RacingCarGame;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private static final int MINIMUM_NUMBER_OF_MOVING = 1;
    private static final String CAR_NAME_DELIMITER = ",";

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarGame racingCarGame;

    public GameController(OutputView outputView) {
        this.inputView = new InputView(outputView);
        this.outputView = outputView;
        this.racingCarGame = new RacingCarGame();
    }

    public void run() {
        addCars(inputView.readCarNames());
        startRacing(readNumberOfMoving());
        outputView.printWinners(racingCarGame.getWinners());
    }

    private void addCars(String carNames) {
        try {
            CarRepository.updateCars(makeCars(carNames));
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printException(illegalArgumentException.getMessage());
            addCars(inputView.readCarNames());
        }
    }

    private List<Car> makeCars(String carNames) {
        return Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
                .filter(this::validateCarName)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private boolean validateCarName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(",는 하나만 입력해주세요.");
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
        if (numberOfMoving < MINIMUM_NUMBER_OF_MOVING) {
            throw new IllegalArgumentException("1회 이상만 입력할 수 있습니다.");
        }
    }

    private void startRacing(int numberOfMoving) {
        for (int round = 0; round < numberOfMoving; round++) {
            racingCarGame.repeatRounds();
            outputView.printCarsStatus(CarRepository.findAll());
        }
    }
}
