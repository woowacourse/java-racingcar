package domain;

public class RacingCar {

    private static final int MOVE_THRESHOLD = 4;

    private final Name name;
    private int position;
    private Pickable picker;

    public RacingCar(final String carName, final Pickable picker) {
        this.name = new Name(carName);
        this.position = 0;
        this.picker = picker;
    }

    public RacingCar(final Name name) {
        this(name.getName(), new RandomPicker());
    }

    public void move() {
        if (isMovable()) {
            position++;
        }
    }

    private boolean isMovable() {
        return picker.pickNumber() >= MOVE_THRESHOLD;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }
}
