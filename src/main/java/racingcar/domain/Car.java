package racingcar.domain;

import racingcar.condition.MovingCarCondition;

public class Car {

    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void moveCar(MovingCarCondition condition) {
        if (condition.isSatisfied()) {
            distance++;
        }
        if (distance < 0) {
            throw new IllegalArgumentException("이동 거리는 음수가 될 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
