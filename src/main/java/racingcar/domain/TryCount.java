package racingcar.domain;

public class TryCount {
    private final int tryCount;

    public static TryCount from(final String userTryCount) {
        int tryCount = parseUserInput(userTryCount);
        validate(tryCount);
        return new TryCount(tryCount);
    }

    private TryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    private static void validate(final int tryCount) {
        if (isSmallerThanZero(tryCount)) {
            throw new NumberFormatException();
        }
    }

    private static boolean isSmallerThanZero(final int number) {
        return number <= 0;
    }

    private static int parseUserInput(final String userTryCount) {
        return Integer.parseInt(userTryCount);
    }

    public int getTryCount() {
        return tryCount;
    }
}
