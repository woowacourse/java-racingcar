package controller;

import racingcar.CarRepository;
import racingcar.RacingCarGame;
import view.InputView;
import view.OutputView;

public class GameController {
    private static final int MINIMUM_NUMBER_OF_MOVING = 1;


    private final RacingCarGame racingCarGame;

    public GameController() {
        this.racingCarGame = new RacingCarGame();
    }

    public void run() {
        addCorrectCars(readCarNames());
        getNumberOfMoving(readNumberOfTry());
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

    private void getNumberOfMoving(int numberOfMoving) {
        try {
            startRacing(numberOfMoving);
            OutputView.printWinners(racingCarGame.getWinners());
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printException(illegalArgumentException.getMessage());
            getNumberOfMoving(readNumberOfTry());
        }
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

    //    private void validateTrial(int numberOfMoving) {
//        if (numberOfMoving < MINIMUM_NUMBER_OF_MOVING) {
//            throw new IllegalArgumentException("1회 이상만 입력할 수 있습니다.");
//        }
//    }

    private static int readNumberOfTry() {
        OutputView.readNumberOfTry();
        return InputView.readNumberOfMoving();
    }


    private void startRacing(int numberOfMoving) {
        for (int round = 0; round < numberOfMoving; round++) {
            racingCarGame.repeatRounds();
            OutputView.printCarsStatus(CarRepository.findAll());
        }
    }
}
