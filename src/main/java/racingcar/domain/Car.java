package racingcar.domain;

public class Car {

    private static final int ZERO = 0;
    private final static int MAXIMUM_NAME_LENGTH = 5;
    private final static String MESSAGE_LENGTH_OF_CAR_NAME = "자동차 이름은 1자 이상 5자 이하여야 합니다.";
    private String name;
    private int distance;

    public Car(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(MESSAGE_LENGTH_OF_CAR_NAME);
        }
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void moveCar() {
        if (distance < ZERO) {
            throw new IllegalArgumentException("이동 거리는 음수가 될 수 없습니다.");
        }
        distance++;
    }
}
