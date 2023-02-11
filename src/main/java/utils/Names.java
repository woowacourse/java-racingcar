package utils;

import java.util.List;
import java.util.stream.Stream;

public class Names {

    private static final int NAME_LENGTH_LOWER_BOUND = 0;
    private static final int NAME_LENGTH_UPPER_BOUND = 6;
    private static final String INVALID_NAME_LENGTH_MESSAGE = "[ERROR] 자동차의 이름은 1글자부터 5글자까지 가능합니다.";

    private final List<String> names;

    public Names(String line) {
        List<String> names = StringParser.splitByComma(line);
        validate(names);
        this.names = names;
    }

    public Stream<String> getStream() {
        return names.stream();
    }

    private void validate(List<String> names) {
        names.forEach(this::validate);
    }

    private void validate(String name) {
        int length = name.length();

        if (length > NAME_LENGTH_LOWER_BOUND && length < NAME_LENGTH_UPPER_BOUND) {
            return;
        }

        throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
    }
}
