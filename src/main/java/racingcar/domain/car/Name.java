package racingcar.domain.car;

import racingcar.exception.CarNameBlankException;

public class Name {

    private final String name;

    public Name(String name) {
        if (name.isEmpty() || name.isBlank()) {
            throw new CarNameBlankException("자동차 이름은 공백이 될 수 없습니다.");
        }
        this.name = name;
    }
}
