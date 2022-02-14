package racingcar.domain;

public class RacingCar {

    private static final int DEFAULT_POSITION = 0;

    private final RandomMoveGenerator generator = new RandomMoveGenerator();
    private final Name name;
    private int position = DEFAULT_POSITION;

    public RacingCar(Name name) {
        this.name = name;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    public int move() {
        if (generator.isMovable()) {
            return ++position;
        }
        return position;
    }

    public boolean comparePosition(int position) {
        return this.position == position;
    }
}
