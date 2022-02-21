package carracinggame.domain;

public class Car {

    public static final int INITIAL_POSITION = 0;
    public static final int REFERENCE_NUMBER = 4;

    private String name;
    private int position = INITIAL_POSITION;

    Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(int number) {
        if (isOverProbability(number)) {
            position++;
        }
    }

    private boolean isOverProbability(int number) {
        return number >= REFERENCE_NUMBER;
    }

    public boolean isWinner(Car car) {
        return this.position > car.position;
    }

    public boolean isCoWinner(Car car) {
        return this.position == car.position;
    }
}