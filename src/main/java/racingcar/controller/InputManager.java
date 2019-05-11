package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;

import java.util.*;
import java.util.stream.Collectors;

public class InputManager {
    private static final String COMMA = ",";
    private static final String INPUT_NAME_ERROR_MENT = "자동자 이름을 정확하게 입력하세요.";
    private static final String INPUT_GAME_COUNT_ERROR_MENT = "시도할 횟수를 정확하게 입력하세요";
    private static final int MIN_GAME_COUNT = 0;

    List<Car> getRacingCar() {
        List<String> racingCarNames = getCheckedCarNames();
        return racingCarNames.stream()
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }

    private List<String> getCheckedCarNames() {
        List<String> racingCarNames;
        racingCarNames = getCarNames();
        validateDuplicate(racingCarNames);
        return racingCarNames;
    }

    private List<String> getCarNames() {
        String[] carNames = InputView.getRacingCarInput().split(COMMA);
        validateNameSize(carNames);
        return Arrays.asList(carNames);
    }

    private void validateNameSize(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException(INPUT_NAME_ERROR_MENT);
        }
    }

    private void validateDuplicate(List<String> racingCarNames) {
        Set<String> carNameSet = new HashSet<>(racingCarNames);
        if (carNameSet.size() != racingCarNames.size()) {
            throw new IllegalArgumentException(INPUT_NAME_ERROR_MENT);
        }
    }

    int getGameCount() {
        int gameCount = InputView.getRacingCount();
        checkGameCountValid(gameCount);
        return gameCount;
    }

    private void checkGameCountValid(int gameCount) {
        if (gameCount < MIN_GAME_COUNT) {
            throw new InputMismatchException(INPUT_GAME_COUNT_ERROR_MENT);
        }
    }
}
