package racingcar.validator;

import racingcar.domain.RacingGame;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class CarInputValidator {
    private CarInputValidator() {
    }

    public static void checkAccuracyOfCarNames(String[] inputs) {
        if (isSmallNumOfCars(inputs)) {
            throw new IllegalArgumentException("자동차 게임을 위한 차의 이름을 "
                    + RacingGame.MIN_NUM_OF_CARS_FOR_GAME + "개 이상 입력해 주세요.");
        }
        if (isDuplicated(inputs)) {
            throw new IllegalArgumentException("서로 다른 이름을 입력해 주세요.");
        }
    }

    private static boolean isSmallNumOfCars(String[] inputs) {
        return (inputs.length < RacingGame.MIN_NUM_OF_CARS_FOR_GAME);
    }

    private static boolean isDuplicated(String[] inputs) {
        Set<String> set = Arrays.stream(inputs).collect(Collectors.toSet());
        return (inputs.length != set.size());
    }

}
