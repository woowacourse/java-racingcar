package racingcar.controller;

import racingcar.ErrorMessage;
import racingcar.model.Car;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class InputManager {

    public List<Car> getRacingCar() {
        List<Car> racingCars = new ArrayList<>();
        List<String> racingCarNames = getCarName();
        for (String racingCarName : racingCarNames) {
            racingCars.add(new Car(racingCarName));
        }
        return racingCars;
    }

    private List<String> getCarName() {
        String[] carNames = InputView.getRacingCarInput().split(",");
        for (String carName : carNames) {
            try {
                checkNameValid(carName);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(e);
            }
        }
        return Arrays.asList(carNames);
    }

    private void checkNameValid(String carName) {
        if (carName.length() < 1 || carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.inputErrorMessage.get("ERROR_CAR_NAME_LENGTH"));
        }
    }

    int getGameCount() {
        int gameCount = 0;
        try {
            gameCount = InputView.getRacingCount();
            checkGameCountValid(gameCount);
        } catch (InputMismatchException e) {
            throw new InputMismatchException(ErrorMessage.inputErrorMessage.get("ERROR_GAME_COUNT"));
        }
        return gameCount;
    }

    private void checkGameCountValid(int gameCount) {
        if (gameCount < 0) {
            throw new InputMismatchException(ErrorMessage.inputErrorMessage.get("ERROR_GAME_COUNT"));
        }
    }
}
