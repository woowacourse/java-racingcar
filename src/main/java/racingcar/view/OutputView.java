package racingcar.view;

import java.util.List;
import racingcar.message.NoticeMessages;
import racingcar.model.car.CarStatus;

public class OutputView {
    private static final String DISTANCE_MARK = "-";

    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printStartMessage() {
        System.out.println(NoticeMessages.RUN_RESULT);
    }

    public static void printStatus(List<CarStatus> statuses) {
        statuses.forEach(carStatus -> {
            System.out.println(createStatusString(carStatus));
        });
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(createWinnersString(winners));
    }

    private static String createStatusString(CarStatus carStatus) {
        return String.format("%s : ", carStatus.getName()) + DISTANCE_MARK.repeat(carStatus.getPosition());
    }

    private static String createWinnersString(List<String> winners) {
        return String.join(", ", winners) + NoticeMessages.WINNERS_MESSAGE;
    }
}
