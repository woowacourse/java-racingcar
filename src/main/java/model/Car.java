package model;

import java.util.List;

public class Car {
    private final String EXCEPTION_MESSAGE = "자동차 이름은 1~5자 이내의 이름으로 입력하여야 합니다.";
    public String name;
    public int location;

    public Car(String name) {
        validCarName(name);
        this.name = name;
        this.location = 0;
    }

    private void validCarName(String name) {
        if (name.isEmpty() || name.length() > 5)
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
    }

    public void moveCar() {
        this.location += 1;
    }
}
