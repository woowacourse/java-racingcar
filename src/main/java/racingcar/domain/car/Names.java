package racingcar.domain.car;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.ErrorMessages;

public class Names {

    private static final String DELIMITER = ",";
    private static final int THRESHOLD = -1;

    private Names() {
        throw new IllegalStateException("Names class is an utility class.");
    }

    public static List<Name> create(final String rawNames) {
        List<Name> names =  Arrays.stream(rawNames.split(DELIMITER, THRESHOLD))
                .map(Name::new)
                .collect(Collectors.toList());
        validate(names);
        return names;
    }

    private static void validate(final List<Name> names) {
        validateUnique(names);
    }

    private static void validateUnique(final List<Name> names) {
        if (names.size() != new HashSet<>(names).size()) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_CARS_HAVE_DUPLICATE_NAMES);
        }
    }
}
