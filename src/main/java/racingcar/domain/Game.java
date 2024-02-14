package racingcar.domain;

public class Game {
    private final int tryCount;

    public static Game from(String userTryCount) throws NumberFormatException {
        int tryCount = parseUserInput(userTryCount);
        validNaturalNumber(tryCount);
        return new Game(tryCount);
    }

    private static void validNaturalNumber(int tryCount) {
        if (tryCount <= 0) {
            throw new NumberFormatException();
        }
    }

    private static int parseUserInput(String userTryCount) {
        return Integer.parseInt(userTryCount);
    }

    private Game(int tryCount) {
        this.tryCount = tryCount;
    }
}
