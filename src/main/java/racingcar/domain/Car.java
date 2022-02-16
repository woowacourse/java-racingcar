package racingcar.domain;

public class Car implements Comparable<Car> {
    private static final int INIT_POSITION = 1;
    private static final int LOWER_MOVABLE_BOUND = 4;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    private final String name;
    private int position = INIT_POSITION;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    public void move(int number) {
        if (isMovable(number)) {
            position++;
        }
    }

    private void validate(String name) {
        if (name.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름 길이는 " + MAXIMUM_CAR_NAME_LENGTH + "이하여야 합니다");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요");
        }
    }

    private boolean isMovable(int number) {
        return number >= LOWER_MOVABLE_BOUND;
    }

    public boolean isSamePositionWith(Car competitor) {
        return this.position == competitor.position;
    }

    @Override
    public int compareTo(Car o) {
        return position - o.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
