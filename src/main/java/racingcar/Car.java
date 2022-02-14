package racingcar;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = Constant.START_POSITION;
    }

    public void movePosition() {
        if (isMovable()) {
            position++;
        }
    }

    private boolean isMovable() {
        return makeRandom() >= Constant.MINIMUM_MOVE;
    }

    private int makeRandom() {
        return (int) (Math.random() * Constant.RANDOM_RANGE);
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
