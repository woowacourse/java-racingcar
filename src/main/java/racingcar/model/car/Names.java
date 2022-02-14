package racingcar.model.car;

import racingcar.util.StringValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private static final String SPLIT_DELIMITER = ",";
    private static final String TO_STRING_DELIMITER = ", ";

    private final List<Name> names;

    private Names(List<Name> names) {
        this.names = names;
    }

    public static Names from(String text) {
        String[] splitText = text.split(SPLIT_DELIMITER);
        StringValidator.validateDuplicated(splitText);

        return new Names(Arrays.stream(splitText)
                .map(Name::from)
                .collect(Collectors.toList()));
    }

    public static Names from(List<Name> names) {
        return new Names(names);
    }

    public List<Name> get() {
        return names;
    }

    @Override
    public String toString() {
        return names.stream()
                .map(Name::toString)
                .collect(Collectors.joining(TO_STRING_DELIMITER));
    }
}
