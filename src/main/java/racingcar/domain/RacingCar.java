package racingcar.domain;

public class RacingCar {

    private static final int DEFAULT_POSITION = 0;

    private final Name name;
    private final MoveGenerator moveGenerator;
    private int position = DEFAULT_POSITION;

    public RacingCar(Name name, MoveGenerator moveGenerator) {
        this.name = name;
        this.moveGenerator = moveGenerator;
    }

    public static RacingCar createRandomMoveCar(Name name) {
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

    public boolean comparePosition(int position) {
        return this.position == position;
    }
}
