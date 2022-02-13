package racingcar.view;

import java.util.List;
import racingcar.message.NoticeMessages;
import racingcar.model.CarStatus;

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

    public static void printStatus(List<CarStatus> statuses) {
        statuses.forEach(carStatus -> {
            System.out.println(createStatusString(carStatus));
        });
        System.out.println(System.lineSeparator());
    }

    private static String createStatusString(CarStatus carStatus) {
        return String.format("%s : ", carStatus.getName()) + DISTANCE_MARK.repeat(carStatus.getPosition());
    }
}
