package domain;

public class Car implements Comparable<Car> {

    private static final int MOVABLE_POWER_MIN = 4;
    private static final int NAME_LENGTH_MAX = 5;

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차 이름이 null입니다.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
        }
        if (name.length() > NAME_LENGTH_MAX) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public boolean moveOrStayByPower(int power) {
        if (isMovable(power)) {
            ++this.position;
            return true;
        }
        return false;
    }

    private boolean isMovable(int power) {
        return power >= MOVABLE_POWER_MIN;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }
}
