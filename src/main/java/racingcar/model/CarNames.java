package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CarNames {

    private static final String SEPARATOR = ",";

    private final List<CarName> carNames;

    private CarNames(final List<CarName> carNames) {
        validateDuplicateName(carNames);
        this.carNames = carNames;
    }

    public static CarNames from(final String input) {
        validateSeparator(input);

        final List<CarName> carNames = Arrays.stream(input.split(SEPARATOR))
                .map(CarName::new)
                .toList();

        return new CarNames(carNames);
    }

    private static void validateSeparator(final String carsName) {
        if (carsName.endsWith(SEPARATOR)) {
            throw new IllegalArgumentException("[ERROR] 구분자로 끝날 수 없습니다.");
        }
    }

    private void validateDuplicateName(final List<CarName> carNames) {
        if (carNames.size() != Set.copyOf(carNames).size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름이 존재합니다.");
        }
    }

    public List<CarName> getCarNames() {
        return carNames;
    }
}
