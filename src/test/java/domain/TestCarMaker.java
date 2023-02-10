package domain;

public abstract class TestCarMaker {

    private static final int MOVE_LOWER_LIMIT = 4;
    private static final int NOT_MOVE_HIGHER_LIMIT = 3;

    public RacingCar makeCarByValue(final String carName, final int value) {
        if (value >= MOVE_LOWER_LIMIT) {
            return createMoveRacingCar(carName);
        }

        return createNotMoveRacingCar(carName);
    }

    public RacingCar createMoveRacingCar(final String carName) {
        return new RacingCar(carName, new MoveCarPicker());
    }

    public RacingCar createNotMoveRacingCar(final String carName) {
        return new RacingCar(carName, new NotMoveCarPicker());
    }

    private class MoveCarPicker implements Pickable {
        @Override
        public int pickNumber() {
            return MOVE_LOWER_LIMIT;
        }
    }

    private class NotMoveCarPicker implements Pickable {
        @Override
        public int pickNumber() {
            return NOT_MOVE_HIGHER_LIMIT;
        }
    }
}
