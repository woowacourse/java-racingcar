package racingcar.domain;

public class Game {
    private final int tryCount;
    private final Vehicles vehicles;

    public static Game from(String userTryCount, Vehicles vehicles) throws NumberFormatException {
        int tryCount = parseUserInput(userTryCount);
        validNaturalNumber(tryCount);
        return new Game(tryCount, vehicles);
    }

    private static void validNaturalNumber(int tryCount) {
        if (tryCount <= 0) {
            throw new NumberFormatException();
        }
    }

    private static int parseUserInput(String userTryCount) {
        return Integer.parseInt(userTryCount);
    }

    private Game(int tryCount, Vehicles vehicles) {
        this.tryCount = tryCount;
        this.vehicles = vehicles;
    }

    public void proceed() {
        vehicles.move();
    }
}
