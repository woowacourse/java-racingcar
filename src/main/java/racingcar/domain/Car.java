package racingcar.domain;

public class Car implements Comparable<Car> {
    public static final String POSITION_MARK = "-";
    public static final String BETWEEN_CAR_AND_POSITION = " : ";

    private Name name;
    private int position;

    public Car(Name name) {
        this.name = name;
        this.position = 0;
    }

    public int movePosition(NumberGenerator numberGenerator) {
        if (numberGenerator.isMovable()) {
            position++;
        }
        return position;
    }

    public String getCurrentPosition() {
        StringBuilder currentPosition = new StringBuilder(name.getName());
        currentPosition.append(BETWEEN_CAR_AND_POSITION);

        for (int i = 0; i < position; i++) {
            currentPosition.append(POSITION_MARK);
        }
        return currentPosition.toString();
    }

    public boolean isWinnerWith(Car maxPositionCar) {
        return this.position == maxPositionCar.position;
    }

    @Override
    public String toString() {
        return name.getName();
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.position;
    }
}