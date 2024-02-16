package racingcar.domain;

public class Car {
    private final String name;
    private int movement;

    public Car(final String name) {
        this.name = name;
        this.movement = 0;
    }

    public void move(final int condition) {
        if (condition > 3 ) {
            this.movement += 1;
        }
    }

    public boolean isSameCount(final int count) {
        return this.movement == count;
    }

    public boolean isAlsoWinner(final Car car) {
        return car.isSameCount(movement);
    }

    public String getName() {
        return name;
    }

    public int getMovement() {
        return movement;
    }
}
