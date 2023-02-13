package racingcar.domain;

public class Car {
    public static final int NAME_MAX_LENGTH = 5;
    public static final int NAME_MIN_LENGTH = 0;
    public static final int START_DISTANCE_VALUE = 0;
    public static final int MIN_TRY_COUNT = 0;
    public static final int RANDOM_NUMBER_BOUNDARY = 10;
    public static final int FORWARD_BOUNDARY = 4;

    private final String name;
    private int distance;

    public Car(String name, int distance) {
        validateNameLength(name);
        validateNameFormat(name);
        validateStartDistance(distance);
        this.name = name;
        this.distance = distance;
    }

    private void validateNameLength(String name) {
        int nameMinLength = NAME_MIN_LENGTH;
        int nameMaxLength = NAME_MAX_LENGTH;

        if (name.length() > nameMaxLength || name.length() <= nameMinLength) {
            throw new IllegalArgumentException(String.format("[ERROR] 자동차 이름의 길이는 %d부터 %d 사이여야 합니다.", nameMinLength, nameMaxLength));
        }
    }

    private void validateNameFormat(String name) {
        if (!name.matches("^[a-zA-Z0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 영숫자로 이루어져야 합니다.");
        }
    }

    private void validateStartDistance(int distance) {
        int startDistance = START_DISTANCE_VALUE;
        if (distance != startDistance) {
            throw new IllegalArgumentException(String.format("[ERROR] 자동차의 시작 위치는 %d으로 설정되어야 합니다.", startDistance));
        }
    }

    public void validateCurrentDistance(int round) {
        if (this.distance > round) {
            throw new IllegalArgumentException("[ERROR] 자동차의 현재 위치는 해당 라운드보다 클 수 없습니다.");
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
