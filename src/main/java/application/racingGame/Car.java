package application.racingGame;

public class Car {
    private static final int MINIMUM_NUMBER_OF_MOVE_FORWARD = 4;

    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveForward(int randomNumber){
        if (isOverMinimumNumberOfMoveForward(randomNumber)) {
            position++;
        }
    }

    private boolean isOverMinimumNumberOfMoveForward(int randomNumber) {
        return randomNumber >= MINIMUM_NUMBER_OF_MOVE_FORWARD;
    }

    public boolean isSameMaxPosition(int maxPosition) {
        return maxPosition == this.position;
    }
}
