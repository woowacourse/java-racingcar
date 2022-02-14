package racingcargame.model;

public class Car implements Comparable<Car> {
    private static final int MINIMUM_MOVE_ACCESSIBLE = 4;
    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 0;

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
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(MIN_NUMBER, MAX_NUMBER + 1);
        return randomNumberGenerator.pickRandomNumber() >= MINIMUM_MOVE_ACCESSIBLE;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(position, car.getPosition());
    }
}
