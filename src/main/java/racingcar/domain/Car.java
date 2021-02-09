package racingcar.domain;

public class Car {

    private static final int MOVE_POINT_NUMBER = 4;
    private Name name;
    private int distance;

    public Car(Name name) {
        this(name, 0);
    }

    public Car(Name name, int distance) {
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

    public boolean isWinner(int maxDistance) {
        return (maxDistance == this.distance);
    }

    public String getName() {
        return this.name.getValue();
    }

    public int getDistance() {
        return this.distance;
    }

}
