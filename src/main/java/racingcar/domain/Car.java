package racingcar.domain;

public class Car {
    private static final int NAME_MAX_LENGTH = 5;
    private static final int NAME_MIN_LENGTH = 0;
    private static final int DISTANCE_DEFAULT = 0;
    private final String name;
    private int distance;

    public Car(String name) {
        this(name, DISTANCE_DEFAULT);
    }

    public Car(String name, int distance) {
        validateNameLength(name);
        validateNameFormat(name);
        this.name = name;
        this.distance = distance;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH || name.length() <= NAME_MIN_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름의 길이는 1부터 5 사이여야 합니다.");
        }
    }

    private void validateNameFormat(String name) {
        if (!name.matches("^[a-zA-Z0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 영숫자로 이루어져야 합니다.");
        }
    }

    public void increaseDistance() {
        this.distance++;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
