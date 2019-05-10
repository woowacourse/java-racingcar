package racingcar.error;

import racingcar.domain.GameCount;
import racingcar.domain.RacingGame;
import racingcar.utils.StringUtils;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Validator {
    private Validator() {
    }

    public static void checkNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("잘못된 입력값입니다. 입력을 확인해 주세요.");
        }
    }

    public static void checkBlank(String input) {
        if (input.matches(StringUtils.BLANK_REGEX)) {
            throw new IllegalArgumentException("해당 입력값은 공백 등이 될 수 없습니다. 입력을 확인해 주세요.");
        }
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

    public static void checkAccuracyOfGameCount(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException("게임 횟수는 " + GameCount.MIN_COUNT + " 이상의 정수로 입력해 주세요.");
        }
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
