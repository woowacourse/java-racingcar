package racingcar.utils;

public class GoForwardOrStopUtils {
    public static final int MIN_GO_FORWARD_VALUE = 4;

    private GoForwardOrStopUtils() {
    }

    public static boolean isGoForward(int goForwardOrStopValue) {
        return MIN_GO_FORWARD_VALUE <= goForwardOrStopValue;
    }
}
