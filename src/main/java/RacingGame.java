public class RacingGame {
    private final int count;
    private Cars cars;

    public RacingGame(int count) {
        this.count = count;
    }

    public static RacingGame fromCount(int count) {
        return new RacingGame(count);
    }

    public static RacingGame fromEmpty() {
        return new RacingGame(0);
    }

    public void play() {
        for (int i = 0; i < count; i++) {
            cars.move();
        }
    }
}
