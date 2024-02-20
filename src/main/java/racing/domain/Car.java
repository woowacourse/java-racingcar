package racing.domain;

public class Car implements Comparable<Car> {
    public static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = 0;
    }

    public void validate(String name) {
        validateSize(name);
    }

    private void validateSize(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isEmpty()) {
            throw new IllegalArgumentException("[Error] 이름은 5글자 이하여야 합니다.");
        }
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            this.position++;
        }
    }

    @Override
    public int compareTo(Car otherCar) {
        return otherCar.position - this.position;
    }

    public boolean isSamePosition(Car car) {
        return this.position == car.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
