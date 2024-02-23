package racingcar.domain.car;

public record CarDistance(int distance) {
    private static final CarDistance INITIAL_DISTANCE = new CarDistance(0);

    public CarDistance getNextDistance() {
        return new CarDistance(this.distance() + 1);
    }

    public static CarDistance getInitialDistance() {
        return INITIAL_DISTANCE;
    }
}
