package racingcar.domain;

import java.util.Map;
import racingcar.constants.CarConstant;

public class Car {
    private String name;
    private int distance;

    public Car(String name, int distance) {
        validateNameLength(name);
        this.name = name;
        this.distance = distance;
    }

    private void validateNameLength(String name) {
        if (name.length() > CarConstant.NAME_MAX_LENGTH.getNumber() || name.length() <= CarConstant.NAME_MIN_LENGTH.getNumber()){
            throw new IllegalArgumentException("[ERROR] 자동차 이름의 길이는 1부터 5 사이여야 합니다.");
        }
    }
}
