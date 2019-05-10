package racingcar.util;

import java.io.IOException;

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

    public static void pause() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printErrorMessageWithPause(Exception e) {
        System.out.print(e.getMessage());
        pause();
    }
}
