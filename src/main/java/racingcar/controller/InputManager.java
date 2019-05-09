package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;

import java.util.*;

public class InputManager {
    private static final String COMMA = ",";
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String INPUT_NAME_ERROR_MENT = "자동자 이름을 정확하게 입력하세요.";
    private static final String INPUT_GAME_COUNT_ERROR_MENT = "시도할 횟수를 정확하게 입력하세요";
    private static final int MIN_GAME_COUNT = 0;

    List<Car> getRacingCar() {
        List<Car> racingCars = new ArrayList<>();
        List<String> racingCarNames;
        try {
            racingCarNames = getCarName();
            checkDuplicateOfCarName(racingCarNames);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
        for (String racingCarName : racingCarNames) {
            racingCars.add(new Car(racingCarName));
        }
        return racingCars;
    }

    private void checkDuplicateOfCarName(List<String> racingCarNames) {
        Set<String> carNameSet = new HashSet<>(racingCarNames);
        if (carNameSet.size() != racingCarNames.size()) {
            throw new IllegalArgumentException(INPUT_NAME_ERROR_MENT);
        }
    }

    private List<String> getCarName() {
        String[] carNames = InputView.getRacingCarInput().split(COMMA);
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
        if (carName.length() < MIN_CAR_NAME_LENGTH || carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(INPUT_NAME_ERROR_MENT);
        }
    }

    int getGameCount() {
        int gameCount = 0;
        try {
            gameCount = InputView.getRacingCount();
            checkGameCountValid(gameCount);
        } catch (InputMismatchException e) {
            throw new InputMismatchException(INPUT_GAME_COUNT_ERROR_MENT);
        }
        return gameCount;
    }

    private void checkGameCountValid(int gameCount) {
        if (gameCount < MIN_GAME_COUNT) {
            throw new InputMismatchException(INPUT_GAME_COUNT_ERROR_MENT);
        }
    }
}
