package racingcar;

public class CarGoForwardOrStopUtils {
    private static final int MIN_NUMBER_TO_GO_FORWARD = 4;

    private CarGoForwardOrStopUtils() {
    }

    public static void goForwardIfRandomNumberIsFourOrMore(Car car, int generatedRandomNumber) {
        if (generatedRandomNumber >= MIN_NUMBER_TO_GO_FORWARD) {
            car.goForward();
        }
    }
}
