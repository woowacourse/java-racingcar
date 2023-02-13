package validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatedCarNameValidation {

    private static final String SPLIT_DELIMITER = ",";

    public static void validateCar(String input) {
        final String[] cars = input.split(SPLIT_DELIMITER);
        validateDuplicatedCarName(cars);
    }

    private static void validateDuplicatedCarName(final String[] cars) {
        Set<String> checkDuplicated = new HashSet<>(List.of(cars));

        if (checkDuplicated.size() != cars.length) {
            throw new IllegalArgumentException("자동차 이름은 중복되지 않아야합니다.");
        }
    }

}
