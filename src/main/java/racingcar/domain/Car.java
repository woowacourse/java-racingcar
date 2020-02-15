package racingcar.domain;

public class Car implements Comparable<Car> {
    public static final int MAXIMUM_LENGTH = 5;
    public static final int CRITERIA = 4;

    private final String name;
    private int position;

    public Car(String name) {
        if (isInvalid(name)) {
            throw new IllegalArgumentException("빈 문자열이거나 각각의 이름의 길이가 5자를 넘어갈 수는 없습니다.");
        }
        this.name = name;
        this.position = 0;
    }

    private boolean isInvalid(String name) {
        if (isEmpty(name)) {
            return true;
        }
        return name.length() > MAXIMUM_LENGTH;

    }

    private boolean isEmpty(String name) {
        return name == null || name.trim().isEmpty();
    }

    public void move(int random) {
        if (isMoving(random)) {
            position++;
        }
    }

    private boolean isMoving(int random) {
        return random >= CRITERIA;
    }

    public String nameIfOn(int maxPosition) {
        if (position == maxPosition) {
            return name;
        }
        return "";
    }

    @Override
    public int compareTo(Car other) {
        return other.position - position;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
