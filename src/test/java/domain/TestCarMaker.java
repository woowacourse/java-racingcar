package domain;

public abstract class TestCarMaker {

    private static final int MOVE_LOWER_LIMIT = 4;
    private static final int NOT_MOVE_HIGHER_LIMIT = 3;

    public RacingCar makeCarByValue(final String carName, final int value) {
        return new RacingCar(carName) {
            @Override
            protected int getRandomInteger() {
                return value;
            }
        };
    }

    public RacingCar createMoveRacingCar(final String carName) {
        return makeCarByValue(carName, MOVE_LOWER_LIMIT);
    }

    public RacingCar createNotMoveRacingCar(final String carName) {
        return makeCarByValue(carName, NOT_MOVE_HIGHER_LIMIT);
    }
}
