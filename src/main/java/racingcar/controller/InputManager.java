package racingcar.controller;

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
                throw new IllegalArgumentException();
            }
        }
        return Arrays.asList(carNames);
    }

    private void checkNameValid(String carName) {
        if (carName.length() < 1 || carName.length() > 5) {
            throw new IllegalArgumentException("이름을 1 글자이상 5 글자이하로 해주세요 ");
        }
    }

    int getGameCount() {
        int gameCount = 0;
        try {
            gameCount = InputView.getRacingCount();
            checkGameCountValid(gameCount);
        } catch (InputMismatchException e) {
            getGameCount();
        }
        return gameCount;
    }

    private void checkGameCountValid(int gameCount) {
        if (gameCount < 0) {
            throw new InputMismatchException();
        }
    }
}
