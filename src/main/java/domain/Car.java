package domain;

public class Car {
    private final String name;
    private int position;
    private static final int MOVE_FORWERD_NUMBER = 4;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public void move(int power) {
        if (power>=MOVE_FORWERD_NUMBER) {
            this.position++;
        }
    }


    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
