package racingcar;

public class RacingGame {

    private final int count;
    private final Cars cars;

    public RacingGame(String input, Cars cars) {
        int count = parseInt(input);
        validateCount(count);
        this.count = count;
        this.cars = cars;
    }

    private void validateCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException();
        }
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void gameStart() {

    }

    private int generateRandomNumber() {
        return 0;
    }
}
