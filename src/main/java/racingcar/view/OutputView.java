package racingcar.view;

import racingcar.message.NoticeMessages;
import racingcar.model.Car;

public class OutputView {
    private static final String DISTANCE_MARK = "-";

    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printStartMessage() {
        System.out.println(NoticeMessages.RUN_RESULT);
    }

    public static void printString(String string) {
        System.out.println(string);
    }

    public static void printCarStatus(Car car) {
        System.out.println(car.getName() + " : " + convertNumberToString(car.getPosition()));
    }

    private static String convertNumberToString(int cnt) {
        return DISTANCE_MARK.repeat(Math.max(0, cnt));
    }
}
