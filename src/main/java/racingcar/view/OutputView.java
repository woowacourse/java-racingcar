package racingcar.view;

import racingcar.message.NoticeMessages;
import racingcar.model.Car;
import racingcar.util.StringUtils;

public class OutputView {

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
        String carPositionString = StringUtils.convertNumberToString(car.getPosition());
        System.out.println(car.getName() + " : " + carPositionString);
    }


}
