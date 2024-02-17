package racingcar.domain.car;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CarNames {

    private static final String SEPARATOR = ",";

    private final List<CarName> carNames;

    private CarNames(final String input) {
        final String[] separatedInput = separate(input, SEPARATOR);

        final List<CarName> carNames = Arrays.stream(separatedInput)
                .map(CarName::new)
                .toList();

        validateDuplicateName(carNames);

        this.carNames = carNames;
    }

    public static CarNames from(final String input) {
        return new CarNames(input);
    }

    private String[] separate(final String input, final String separator) {
        if (input.endsWith(separator)) {
            throw new IllegalArgumentException("[ERROR] 구분자로 끝날 수 없습니다.");
        }

        return input.split(separator);
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
