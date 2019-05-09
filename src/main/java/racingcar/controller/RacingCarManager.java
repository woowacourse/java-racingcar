package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class RacingCarManager {
    private List<Car> cars;
    private int gameCount;

    RacingCarManager() {
        racingGameStart();
    }

    private void racingGameStart() {
        init();
    }

    private void init() {
        cars = new ArrayList<>();
        gameCount = 0;
    }

    private void getCarName() {
        String[] carNames = InputView.getRacingCarInput().split(",");
        for (String carName : carNames) {
            try {
                checkNameValid(carName);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkNameValid(String carName) {
        if (carName.length() < 1 || carName.length() > 5) {
            throw new IllegalArgumentException("이름을 1 글자이상 5 글자이하로 해주세요 ");
        }
    }

    private void getGameCount() {
        try {
            gameCount = InputView.getRacingCount();
            checkGameCountValid(gameCount);
        } catch (InputMismatchException e) {
            getGameCount();
        }
    }

    private void checkGameCountValid(int gameCount) {
        if (gameCount < 0) {
            throw new InputMismatchException();
        }
    }


}
