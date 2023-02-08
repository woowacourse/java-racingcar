package racingcar.domain;

import racingcar.enumType.CarConstant;

public class Car {
    private final String name;

    private final StringBuilder drivingMark;

    public Car(String name) {
        this.name =  name;
        this.drivingMark = new StringBuilder();
    }

    public void move(int forwardCondition) {
        if (forwardCondition >= CarConstant.FORWARD_NUMBER.getNumber()) {
            drivingMark.append("-");
        }
    }

    @Override
    public String toString() {
        return name + " : " + drivingMark;
    }
}
