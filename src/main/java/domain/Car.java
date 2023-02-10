package domain;

public class Car implements Comparable<Car> {

    protected static final int INIT_POSITION = 1;
    private static final int MIN_MOVE_NUM = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = INIT_POSITION;
    }

    public void move(int num) {
        if (num >= MIN_MOVE_NUM) {
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

