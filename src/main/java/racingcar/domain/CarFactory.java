package racingcar.domain;

import racingcar.constant.ErrorConstant;
import racingcar.constant.GameConstant;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarFactory {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final int MINIMUM_CARS_COUNT = 2;

    public static List<Car> generate(String input) {
        List<String> carNames = List.of(input.split(CAR_NAME_DELIMITER));
        validateDuplicatedNames(carNames);
        validateCarCount(carNames.size());

        return createCarsByNames(carNames);
    }

    private static List<Car> createCarsByNames(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new Car(carName, GameConstant.START_POINT))
                .collect(Collectors.toUnmodifiableList());
    }

    private static void validateCarCount(int size) {
        if (size < MINIMUM_CARS_COUNT) {
            throw new IllegalArgumentException(ErrorConstant.ERROR_PREFIX + "자동차 수는 2대 이상이어야 합니다.");
        }
    }

    private static void validateDuplicatedNames(List<String> carNames) {
        if (Set.copyOf(carNames).size() != carNames.size()) {
            throw new IllegalArgumentException(ErrorConstant.ERROR_PREFIX + "자동차 이름이 중복됩니다.");
        }
    }

}
