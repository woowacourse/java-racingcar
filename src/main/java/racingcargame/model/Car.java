package racingcargame.model;

import racingcargame.utils.RandomNumberGenerator;

public class Car implements Comparable<Car> {
    private static final int MINIMUM_MOVE_ACCESSIBLE = 4;

    private final String name;
    private int position;

    public Car(final String name, int position) {
        this.name = name;
        this.position = position;
    }

    String getName(){
        return name;
    }

    int getPosition() {
        return position;
    }

    boolean isWinner(Car winner) {
        return position == winner.getPosition();
    }

    void moveCar() {
        if (isMoveCar()) {
            position ++;
        }
    }

    private boolean isMoveCar() {
        int number = RandomNumberGenerator.makeRandomNumber();
        return number >= MINIMUM_MOVE_ACCESSIBLE;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(position, car.getPosition());
    }
}
