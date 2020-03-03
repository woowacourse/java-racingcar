package racing.model;

public class Car implements Comparable<Car> {

    private static final int MAX_NAME_SIZE = 5;
    public static final int CRITERIA_NUMBER = 4;
    private final String name;
    private final Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        checkNullName(name);
        name = name.trim();
        checkEmptyName(name);
        checkNameLengthUnderSix(name);
        this.name = name;
        this.position = new Position(position);
    }

    private void checkNullName(final String name) {
        if (name == null) {
            throw new NullPointerException("차이름이 입력되지 않았습니다.");
        }
    }

    private void checkEmptyName(final String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("차이름은 공백 또는 빈 문자열일 수 없습니다.");
        }
    }

    private void checkNameLengthUnderSix(final String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public void move(final int number) {
        if (isMovable(number)) {
            position.add();
        }
    }

    private boolean isMovable(final int number) {
        return number >= CRITERIA_NUMBER;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public boolean isSamePosition(Car topPositionCar) {
        return position.equals(topPositionCar.position);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        return this.name.equals(((Car) o).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public int compareTo(Car car) {
        return this.getPosition() - car.getPosition();
    }
}
