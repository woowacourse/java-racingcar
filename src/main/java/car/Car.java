package car;

public class Car {
    private static final int INITIAL_POSITION = 0;

    private final String name;
    private int position;

    public Car(String name) {
        this(name, INITIAL_POSITION);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public boolean isFartherThan(int otherPosition) {
        return position > otherPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(MoveChance moveChance) {
        if (moveChance.isMovable())
            position++;
    }
}
