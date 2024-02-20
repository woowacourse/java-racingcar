package controller;

import domain.Car;
import domain.Cars;
import domain.ErrorMessage;
import domain.RacingCarGame;
import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class RacingCarController {
    public static final int MINIMUM_ATTEMPT_LIMIT = 1;
    private final OutputView outputView;
    private final InputView inputView;

    public RacingCarController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        RacingCarGame racingCarGame = new RacingCarGame(inputCarName());
        racingCarGame.playGame(inputAttemptLimit());
        outputView.printWinners(racingCarGame.getWinnerName());
    }

    private Cars inputCarName() {
        try {
            List<String> inputCarNames = inputView.requestCarName();
            return setCars(inputCarNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCarName();
        }
    }

    public Cars setCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        return new Cars(carList);
    }

    private int inputAttemptLimit() {
        try {
            String inputAttemptLimit = inputView.requestAttemptLimit();
            int attemptLimit = validateInputAttemptLimit(inputAttemptLimit);
            validateNumber(attemptLimit);
            return attemptLimit;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputAttemptLimit();
        }
    }

    public int validateInputAttemptLimit(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INTEGER_REQUIRED.getMessage());
        }
    }

    public void validateNumber(int inputAttemptLimit) {
        if (inputAttemptLimit < MINIMUM_ATTEMPT_LIMIT) {
            throw new IllegalArgumentException(ErrorMessage.POSITIVE_NUMBER_REQUIRED.getMessage());
        }
    }
}
