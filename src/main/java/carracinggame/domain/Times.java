package carracinggame.domain;

public class Times {

    public static final int POSSIBLE_REMAINED_TIMES = 0;

    public static void isRightTimes(String input) throws IllegalArgumentException {
        final String REGEX = "^[0-9]+$";
        if (!input.matches(REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isEnd(int remainedTimes) {
        if (remainedTimes <= POSSIBLE_REMAINED_TIMES) {
            return true;
        }
        return false;
    }
}