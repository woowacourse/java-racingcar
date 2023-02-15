package racingcar.vo;

import racingcar.util.Validator;

public class Name {

    private final String name;

    public Name(String name) {
        Validator.validateCarNames(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
