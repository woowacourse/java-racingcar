package model;

public class Car {

    private static final int FORWARD_MIN_NUMBER = 4;
    private static final int INITIAL_POSITION = 0;
    private int position;

    public Car() {
        this.position = INITIAL_POSITION;
    }

    public void moveForward(int randomNumber) {
        if (randomNumber >= FORWARD_MIN_NUMBER) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}