package racingcar.domain;

import java.util.*;

import static racingcar.domain.CarName.ERROR_MESSAGE_OF_INVALID_INPUT;

public class Cars {
    private static final char COMMA = ',';
    private static final String COMMA_DELIMITER = ",";
    private static final String ERROR_MESSAGE_OF_DUPLICATED_NAME = "이름이 중복됩니다.";

    private final List<Car> cars = new ArrayList<>();

    public Cars(String inputNames) {
        validateBothEnds(inputNames);
        for (String name : inputNames.split(COMMA_DELIMITER)) {
            cars.add(new Car(name));
        }
        validateDuplicate(inputNames);
    }

    private void validateBothEnds(String inputNames) {
        if (inputNames.charAt(0) == COMMA || inputNames.charAt(inputNames.length() - 1) == COMMA) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OF_INVALID_INPUT);
        }
    }

    private void validateDuplicate(String inputNames) {
        Set<String> unDuplicateNames = new HashSet<>(Arrays.asList(inputNames.split(COMMA_DELIMITER)));
        if (cars.size() != unDuplicateNames.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OF_DUPLICATED_NAME);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
