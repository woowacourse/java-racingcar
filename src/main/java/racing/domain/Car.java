package racing.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Car {
    private static final Pattern PATTERN = Pattern.compile("[a-zA-Z]{1,5}");

    private final String name;

    public Car(String name) {
        this.name = name;
        validateName();
    }

    private void validateName() {
        if (Objects.isNull(this.name)) {
            throw new IllegalArgumentException();
        }
        Matcher matcher = PATTERN.matcher(this.name);
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }
}

