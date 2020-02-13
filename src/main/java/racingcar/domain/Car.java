package racingcar.domain;

public class Car implements Comparable<Car> {
    public static final String POSITION_MARK = "-";

    private Name name;
    private int position;

    public Car(Name name) {
        this.name = name;
        this.position = 0;
    }

    public int movePosition(int moveValue) {
        if (moveValue >= 4) {
            position++;
        }
        return position;
    }

    public String getCurrentPosition() {
        StringBuilder currentPosition = new StringBuilder(name.getName());
        currentPosition.append(" : ");

        for (int i = 0; i < position; i++) {
            currentPosition.append(POSITION_MARK);
        }
        return currentPosition.toString();
    }

    public boolean isMaxPosition(Car maxPositionCar) {
        return this.position >= maxPositionCar.position;
    }

    @Override
    public String toString() { return name.getName(); }

    @Override
    public int compareTo(Car car) {
        return this.position - car.position;
    }
}
