package racingcar.domain;

public class Car {

    private static final int ZERO = 0;
    private static final int MINIMUM_MOVEMENT_CONDITION = 4;
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void moveCar(int number) {
        if (distance < ZERO) {
            throw new IllegalArgumentException("이동 거리는 음수가 될 수 없습니다.");
        }
        if (number >= MINIMUM_MOVEMENT_CONDITION) {
            distance++;
        }
    }
}
