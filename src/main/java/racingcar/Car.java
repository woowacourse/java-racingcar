package racingcar;

public class Car {

    public static final int START_POSITION = 0;
    public static final int MINIMUM_MOVE = 4;
    public static final int RANDOM_RANGE = 10;

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }

    public void movePosition() {
        if (isMovable()) {
            position++;
        }
    }

    private boolean isMovable() {
        return makeRandom() >= MINIMUM_MOVE;
    }

    private int makeRandom() {
        return (int) (Math.random() * RANDOM_RANGE);
    }

    public boolean isSamePosition(int number) {
        return position == number;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
