package racingcar.domain;

public class Car implements Comparable<Car> {
    private static final int CAR_MOVE_CONDITION = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveOrNot(int randomNumber) {
        if (randomNumber >= CAR_MOVE_CONDITION) {
            ++position;
        }
    }

    public boolean isMaxPosition(int maxDistance) {
        return (this.position == maxDistance);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public int compareTo(Car anotherCar) {
        if (this.position == anotherCar.position) {
            return 0;
        }
        return (this.position < anotherCar.position) ? 1 : -1;
    }
}
