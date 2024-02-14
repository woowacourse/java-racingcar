package racingcar.domain;

public class Game {
    private final int tryCount;

    public static Game from(String userTryCount) throws NumberFormatException {
        int tryCount = parseUserInput(userTryCount);
        return new Game(tryCount);
    }

    private static int parseUserInput(String userTryCount) {
        return Integer.parseInt(userTryCount);
    }

    private Game(int tryCount) {
        this.tryCount = tryCount;
    }
}
