package racingcar.domain;

public class Car implements Comparable<Car>{
    public static final String POSITION_MARK = "-";

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public boolean isMaxDistance(Car maxDistanceCar) {
        return this.position >= maxDistanceCar.position;
    }

    public int movePosition(int moveValue) {
        if (moveValue >= 4) {
            this.position++;
        }
        return this.position;
    }

    public String getCurrentPosition() {
        StringBuilder currentPosition = new StringBuilder(this.name);
        currentPosition.append(" : ");

        for (int i = 0 ; i < this.position ; i++) {
            currentPosition.append(POSITION_MARK);
        }
        return currentPosition.toString();
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.position;
    }
}
