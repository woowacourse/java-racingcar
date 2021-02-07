package racingcar.model;

public class Car {

    private static final int MOVE_POINT_NUMBER = 4;
    private static final int NAME_LEN = 5;
    private String name;
    private int distance;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int distance) {
        validateName(name);
        this.name = name;
        this.distance = distance;
    }

    public int move(int randomNumber) {
        if (checkMoveCondition(randomNumber)) {
            this.distance++;
        }
        return this.distance;
    }

    private boolean checkMoveCondition(int randomNumber) {
        return (randomNumber >= MOVE_POINT_NUMBER);
    }

    private void validateName(String name) {
        if (name.length() > NAME_LEN) {
            throw new IllegalArgumentException("[Error] 자동차 이름은 5자이하여야 합니다.\n");
        }
    }

    public boolean isWinner(int maxDistance) {
        return (maxDistance == this.distance);
    }

    public String getCarName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

}
