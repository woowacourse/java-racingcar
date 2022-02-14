package racingcar;

public class Car {

    private String name;
    private int position;

    private static final int START_POSITION = 0;
    private static final int MINIMUM_MOVE = 4;

    public Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }

    public boolean isMovable(int number) {
        return number >= MINIMUM_MOVE;
    }

    public void movePosition(int number) {
        if (isMovable(number)) {
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

    public void setPosition(int number) {
        position = number;
    }

}
