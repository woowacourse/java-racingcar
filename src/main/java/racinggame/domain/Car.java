package racinggame.domain;

public class Car {
    private static final int MOVE_LOWER_BOUND = 4;

    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void move(int power) {
        if (power >= MOVE_LOWER_BOUND) {
            this.distance++;
        }
    }

    public boolean isWinner(int distance) {
        return this.distance == distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }


}
