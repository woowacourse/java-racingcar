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

    private final RacingCarGame racingCarGame;

    public GameController() {
        this.racingCarGame = new RacingCarGame();
    }

    public void run() {
        addCars(readCarNames());
        getNumberOfMoving(readNumberOfTry());
    }

    private void getNumberOfMoving(int numberOfMoving) {
        try {
            startRacing(numberOfMoving);
            OutputView.printWinners(racingCarGame.getWinners());
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printException(illegalArgumentException.getMessage());
            getNumberOfMoving(readNumberOfTry());
        }
    }

    private static String readCarNames() {
        OutputView.readCarNames();
        return InputView.readCarNames();
    }

    private void addCars(String carNames) {
        try {
            CarRepository.updateCars(makeCars(carNames));
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printException(illegalArgumentException.getMessage());
            addCars(InputView.readCarNames());
        }
    }

    private List<Car> makeCars(String carNames) {
        return Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
                .filter(this::validateCarName)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private boolean validateCarName(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("빈 문자열 및 공백은 입력할 수 없습니다.");
        }
        return true;
    }

//    private int readNumberOfMoving() {
//        try {
//            int numberOfMoving = readNumberOfTry();
//            validateTrial(numberOfMoving);
//            return numberOfMoving;
//        } catch (IllegalArgumentException exception) {
//            OutputView.printException(exception.getMessage());
//            return readNumberOfMoving();
//        }
//    }

    private static int readNumberOfTry() {
        OutputView.readNumberOfTry();
        return InputView.readNumberOfMoving();
    }

//    private void validateTrial(int numberOfMoving) {
//        if (numberOfMoving < MINIMUM_NUMBER_OF_MOVING) {
//            throw new IllegalArgumentException("1회 이상만 입력할 수 있습니다.");
//        }
//    }

    private void startRacing(int numberOfMoving) {
        for (int round = 0; round < numberOfMoving; round++) {
            racingCarGame.repeatRounds();
            OutputView.printCarsStatus(CarRepository.findAll());
        }
    }
}
