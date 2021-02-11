package racingcar.domain.car;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.ErrorMessages;

public class CarNames {

    private static final String DELIMITER = ",";
    private static final int THRESHOLD = -1;

    private final List<Name> names;

    private CarNames(final List<Name> names) {
        validate(names);
        this.names = names;
    }

    public static CarNames create(final String rawNames) {
        List<Name> names =  Arrays.stream(rawNames.split(DELIMITER, THRESHOLD))
                .map(Name::new)
                .collect(Collectors.toList());
        return new CarNames(names);
    }

    private void validate(final List<Name> names) {
        validateUnique(names);
    }

    private void validateUnique(final List<Name> names) {
        if (names.size() != new HashSet<>(names).size()) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_CARS_HAVE_DUPLICATE_NAMES);
        }
    }

    public List<Name> toList() {
        return Collections.unmodifiableList(names);
    }
}
