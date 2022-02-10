package racingcar;

public class Car {
    private static final int STANDARD = 4;
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(int number) {
        if (number >= STANDARD) {
            position++;
        }
    }
}
