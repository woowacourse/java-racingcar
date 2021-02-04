package racingcar;

public class GoForwardOrStop {
    private static final int MIN_GO_FORWARD_VALUE = 3;

    public static boolean isGoForward(int goForwardOrStopValue) {
        return goForwardOrStopValue > MIN_GO_FORWARD_VALUE;
    }
}
