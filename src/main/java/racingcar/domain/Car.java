package racingcar.domain;

public class Car implements Comparable<Car> {
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

    public boolean isMaxPosition(Car maxPositionCar) {
        return this.position >= maxPositionCar.position;
    }

    @Override
    public String toString() {
        return name.getName();
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.position;
    }

    public int getPosition() { return position; }
}
