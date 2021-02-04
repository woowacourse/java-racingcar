package racingcar.model;

public class Car {
    private String name;
    private int distance;
    private static final int MOVE_POINT_NUMBER = 4;
    private static final int NAME_LEN = 5;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.distance = 0;
    }

    public void move(int randomNumber) {
        if (checkMoveCondition(randomNumber)) {
            this.distance++;
        }
    }

    private boolean checkMoveCondition(int randomNumber) {
        return (randomNumber >= MOVE_POINT_NUMBER);
    }

    private void validateName(String name) {
        if (name.length() > NAME_LEN)
            throw new IllegalArgumentException();
    }

}
