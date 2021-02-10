package racing.domain.name;

import java.util.*;
import java.util.stream.Collectors;

public class CarNames {
    private static final String DELIMITER = ",";
    private static final int SPLIT_THRESHOLD = -1;

    private final List<CarName> carNames;

    private CarNames(final List<CarName> carNames) {
        ArrayList<CarName> copy = new ArrayList<>(carNames);
        validateCarNames(copy);
        this.carNames = copy;
    }

    public static CarNames of(final String inputName) {
        String[] splitNames = splitInputName(inputName);
        List<CarName> carNames = Arrays.stream(splitNames)
                .map(carName -> new CarName(carName))
                .collect(Collectors.toList());
        return new CarNames(carNames);
    }

    public static CarNames of(final List<CarName> carNames) {
        return new CarNames(carNames);
    }

    public static String[] splitInputName(final String carNames) {
        return carNames.split(DELIMITER, SPLIT_THRESHOLD);
    }

    private void validateCarNames(List<CarName> carNames) {
        if (!isUnique(carNames)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private boolean isUnique(List<CarName> carNames) {
        return carNames.stream()
                .map(CarName::getName)
                .allMatch(new HashSet<>()::add);
    }

    public List<CarName> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }
}
