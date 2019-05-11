package racingcar.util;

public class PrintUtil {
    public static final int DEFAULT_SLEEP_TIME = 500;

    private PrintUtil() {}

    public static void sleep() {
        sleep(DEFAULT_SLEEP_TIME);
    }

    public static void sleep(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
