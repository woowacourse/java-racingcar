package domain;

public class Car {
    private static final int MOVED_LOWER_BOUND = 4;

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVED_LOWER_BOUND) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
