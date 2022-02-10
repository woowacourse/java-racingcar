package racingcar.model.car;

import racingcar.util.StringValidator;

public class Name {
    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name from(String input) {
        StringValidator.validateIsEmpty(input);
        return new Name(input);
    }
}
