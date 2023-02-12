package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static racingcar.constant.GameConstant.RACE_START_POINT;

public class CarFactory {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final int CAR_NAME_MINIMUM_LENGTH = 1;
    private static final int CAR_NAME_MAXIMUM_LENGTH = 5;

    public static List<Car> generate(String input) {
        final List<String> carNames = Arrays.stream(input.split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toUnmodifiableList());

        validateDuplicatedCarNames(carNames);

        return createCarsByNames(carNames);
    }

    private static List<Car> createCarsByNames(List<String> carNames) {
        return carNames.stream()
                .map(carName -> {
                    validateLengthOfCarName(carName);
                    return new Car(carName, RACE_START_POINT);
                })
                .collect(Collectors.toUnmodifiableList());
    }

    private static void validateDuplicatedCarNames(List<String> carNames) {
        if (Set.copyOf(carNames).size() != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복되지 않아야 합니다.");
        }
    }

    private static void validateLengthOfCarName(String name) {
        if (name.length() > CAR_NAME_MAXIMUM_LENGTH || name.length() < CAR_NAME_MINIMUM_LENGTH) {
            throw new IllegalArgumentException("자동차 이름의 길이는 1이상 5이하여야 합니다.");
        }
    }

}
