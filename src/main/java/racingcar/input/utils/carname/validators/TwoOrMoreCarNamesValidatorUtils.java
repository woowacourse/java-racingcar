package racingcar.input.utils.carname.validators;

import java.util.List;
import racingcar.input.utils.carname.validators.exceptions.LessThanTwoCarNamesException;

public class TwoOrMoreCarNamesValidatorUtils {
    private static final int ALLOWED_MIN_NUMBER_OF_CARS = 2;

    private TwoOrMoreCarNamesValidatorUtils() {
    }

    public static void validateTwoOrMoreCarNames(List<String> carNames) {
        if (carNames.size() < ALLOWED_MIN_NUMBER_OF_CARS) {
            throw new LessThanTwoCarNamesException("경주할 자동차는 두 대 이상이어야 합니다.");
        }
    }
}
