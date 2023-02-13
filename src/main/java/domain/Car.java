package domain;

public class Car implements Comparable<Car> {

    private static final int INIT_POSITION = 1;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = INIT_POSITION;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(boolean doMove) {
        if (doMove) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car o) {
        return position - o.position;
    }
}

