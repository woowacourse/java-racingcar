public class Car {
    private final int MOVE_LOWER_BOUND = 4;
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    @Override
    public String toString() {
        return String.format("%s  : %s", name, "-".repeat(distance));
    }

    public void move() {
        int moveCount = RandomNumberGenerator.randomNumberGenerate();
        if (moveCount >= MOVE_LOWER_BOUND) {
            this.distance++;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
