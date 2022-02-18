package racingcar.model;

public class Car implements Comparable<Car> {
    private static final String NULL_EMPTY_CAR_NAME_ERROR_MESSAGE = "[Error] 다시 이름을 입력하세요";
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = String.format("[Error] %d자 이하의 이름을 입력하세요.",
            MAX_CAR_NAME_LENGTH);
    private static final String ONE_STEP = "-";
    private static final String COLON = " : ";

    private final String name;
    private int position;
    private MovingCarStrategy movingCarStrategy;

    public Car(String name, MovingCarStrategy movingCarStrategy) {
        this(name, 0);
        this.movingCarStrategy = movingCarStrategy;
    }

    public Car(String name, int position) {
        checkCarNamesBlank(name);
        checkCarNamesLength(name);
        this.name = name;
        this.position = position;
    }

    private void checkCarNamesBlank(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(NULL_EMPTY_CAR_NAME_ERROR_MESSAGE);
        }
    }

    private void checkCarNamesLength(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    @Override
    public String toString() {
        String step = ONE_STEP;
        step = step.repeat(position);
        return name + COLON + step;
    }

    @Override
    public int compareTo(Car other) {
        return position - other.position;
    }

    public void move() {
        if (movingCarStrategy.canMove()) {
            position += 1;
        }
    }

    public boolean isSamePosition(Car otherCar) {
        return this.position == otherCar.position;
    }

    public String getName() {
        return name;
    }
}
