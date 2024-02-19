package racingcar.domain;

public record TryCount(int tryCount) {

    public static TryCount from(final int userTryCount) {
        validate(userTryCount);
        return new TryCount(userTryCount);
    }

    private static void validate(final int tryCount) {
        if (isSmallerThanZero(tryCount)) {
            throw new NumberFormatException();
        }
    }

    private static boolean isSmallerThanZero(final int number) {
        return number <= 0;
    }
}