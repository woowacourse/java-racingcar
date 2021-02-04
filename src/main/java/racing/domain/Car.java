package racing.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car {
    private static final Pattern PATTERN = Pattern.compile("[a-zA-Z]{1,5}");
    private static final int MINIMUM_MOVE_NUMBER = 4;
    private static final int DEFAULT_POSITION = 0;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = DEFAULT_POSITION;
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

    public boolean move(int randomNumber) {
        if (randomNumber >= MINIMUM_MOVE_NUMBER) {
            this.position++;
            return true;
        }
        return false;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}

