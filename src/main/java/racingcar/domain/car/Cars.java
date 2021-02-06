package racingcar.domain.car;

import java.util.*;

public class Cars {
    public static final String COMMA_DELIMITER = ",";
    public static final char COMMA = ',';

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
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private void validateDuplicate(String inputNames) {
        Set<String> unDuplicateNames = new HashSet<>(Arrays.asList(inputNames.split(COMMA_DELIMITER)));
        if (cars.size() != unDuplicateNames.size()) {
            throw new IllegalArgumentException("이름이 중복됩니다.");
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
