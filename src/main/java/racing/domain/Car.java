package racing.domain;

public class Car implements Comparable<Car> {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_FORWARD_CONDITION = 4;

    private final String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = 0;
    }

    private void validate(String name) {
        validateSize(name);
    }

    private void validateSize(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void moveByNumber(int value) {
        if (value >= MIN_FORWARD_CONDITION) {
            this.position++;
        }
    }

    public boolean isSame(Car car) {
        return this.position == car.position;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }

    @Override
    public int compareTo(Car otherCar) {
        return otherCar.position - this.position;
    }

    public String getName() {
        return name;
    }
}
