package racingcar.utils;

import java.io.IOException;

public class PrintUtils {
    private static final int DEFAULT_SLEEP_TIME = 1000;

    private PrintUtils() {
    }

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
