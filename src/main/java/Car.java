public class Car {
    private static final int INIT_POSITION = 0;
    private static final int MIN_MOVABLE_POWER = 4;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = INIT_POSITION;
    }

    public void move(int power) {
        if (movable(power)) {
            position = position + 1;
        }
    }

    private boolean movable(int power) {
        return power >= MIN_MOVABLE_POWER;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
