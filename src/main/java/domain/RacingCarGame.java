package domain;

public class RacingCarGame {
    private Cars cars;
    private final Count count;

    public RacingCarGame(Cars cars, Count count) {
        this.cars = cars;
        this.count = count;
    }

    /**
     * Move cars for $count times
     */
    public void race() {
        // TODO : for문을 다르게 쓸 수 없을까?
        for (int i = 0; i < count.getValue(); i++) {
            cars.move();
        }
    }
}
