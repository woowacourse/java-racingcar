package carracinggame.domain;

public class Car {

    public static final int INITIAL_POSITION = 0;
    public static final int REFERENCE_NUMBER = 4;

    String name;
    int position = INITIAL_POSITION;

    Car(String name) {
        this.name = name;
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
        if (number >= REFERENCE_NUMBER) {
            return true;
        }
        return false;
    }

}
