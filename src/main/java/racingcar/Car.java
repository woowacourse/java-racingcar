package racingcar;

public class Car {

    private String name;
    private int position;

    private static final int START_POSITION = 0;
    private static final int RANDOM_RANGE = 10;
    private static final int MINIMUM_MOVE = 4;

    public Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }

    private int makeRandom() {
        return (int) (Math.random() * RANDOM_RANGE);
    }

    public boolean isMovable() {
        return makeRandom() >= MINIMUM_MOVE;
    }

    public void movePosition() {
        if (isMovable()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isSamePosition(int number) {
        return position == number;
    }
}
