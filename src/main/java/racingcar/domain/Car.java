package racingcar.domain;

public class Car {
    private static final int MOVEMENT_CRITERIA = 3;

    private final String name;
    private int movement;

    public Car(final String name) {
        this.name = name;
        this.movement = 0;
    }

    public void move(final int condition) {
        if (condition > MOVEMENT_CRITERIA ) {
            this.movement += 1;
        }
    }

    public boolean isSameMovement(final int movement) {
        return this.movement == movement;
    }

    public boolean isAlsoWinner(final Car car) {
        return car.isSameMovement(movement);
    }

    public String getName() {
        return name;
    }

    public int getMovement() {
        return movement;
    }
}