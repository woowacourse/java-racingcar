package racingcar.domain.car;

import racingcar.utils.InputValidation;

public class Name {
    private static final String DEFAULT_NAME = "no_name";
    private final String name;

    public Name() {
        this(DEFAULT_NAME);
    }

    public Name(String name) {
        InputValidation.validateCarName(name);
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Name) {
            return ((Name) obj).name.equals(this.name);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
