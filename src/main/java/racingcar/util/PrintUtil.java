package racingcar.util;

public class PrintUtil {
    public static final int DEFAULT_SLEEP_TIME = 1000;

    public static void pause() {
        pause(DEFAULT_SLEEP_TIME);
    }

    public static void pause(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
