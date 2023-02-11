package racingcar.dto;

import static racingcar.domain.Car.Validator.*;
import static racingcar.dto.RacingCarNamesRequest.Validator.validateDuplicateCarNames;
import static racingcar.exception.ExceptionMessage.DUPLICATE_CAR_NAME;

import java.util.Arrays;
import java.util.List;

public class RacingCarNamesRequest {
    private final List<String> names;

    private RacingCarNamesRequest(List<String> names) {
        this.names = names;
    }

    public static RacingCarNamesRequest of(String input) {
        String[] names = input.split(",");
        validate(names);
        return new RacingCarNamesRequest(List.of(names));
    }

    private static void validate(String[] names) {
        for (String name : names) {
            validateBlankCarName(name);
            validateCarNameLength(name);
        }
        validateDuplicateCarNames(names);
    }

    public static class Validator {
        private Validator() {
        }

        public static void validateDuplicateCarNames(String[] names) {
            long noDuplicateCount = Arrays.stream(names)
                    .distinct()
                    .count();
            if (noDuplicateCount != names.length) {
                throw new IllegalArgumentException(DUPLICATE_CAR_NAME.getMessage());
            }
        }
    }

    public List<String> getNames() {
        return names;
    }
}
