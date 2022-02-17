package racingcar.domain;

public class RacingCar {

    private static final int DEFAULT_POSITION = 0;

    private final Name name;
    private final MoveGenerator moveGenerator;
    private int position = DEFAULT_POSITION;

    public RacingCar(final Name name, final MoveGenerator moveGenerator) {
        this.name = name;
        this.moveGenerator = moveGenerator;
    }

    public static RacingCar createRandomMoveCar(final Name name) {
        return new RacingCar(name, new RandomMoveGenerator());
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    public int move() {
        if (moveGenerator.isMovable()) {
            return ++position;
        }
        return position;
    }

    public boolean comparePosition(final int position) {
        return this.position == position;
    }
}
