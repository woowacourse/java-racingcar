package racingcar.domain;

import java.util.Map;
import racingcar.constants.CarConstant;

public class Car {
    private String name;
    private int distance;

    public Car(String name, int distance) {
        validateNameLength(name);
        validateNameFormat(name);
        this.name = name;
        this.distance = distance;
    }

    private void validateNameLength(String name) {
        if (name.length() > CarConstant.NAME_MAX_LENGTH.getNumber() || name.length() <= CarConstant.NAME_MIN_LENGTH.getNumber()){
            throw new IllegalArgumentException("[ERROR] 자동차 이름의 길이는 1부터 5 사이여야 합니다.");
        }
    }

    private void validateNameFormat(String name) {
        if(!name.matches("^[a-zA-Z0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 영숫자로 이루어져야 합니다.");
        }
    }

    public void increaseDistance() {
        this.distance++;
    }
}
