package racingcar.view;

import java.util.List;
import racingcar.message.NoticeMessages;
import racingcar.model.car.CarNameAndPosition;

public class OutputView {
    private static final String DISTANCE_MARK = "-";

    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printStartMessage() {
        System.out.println(NoticeMessages.RUN_RESULT);
    }

    public static void printCurrentCarInfo(List<CarNameAndPosition> carNameAndPositions) {
        carNameAndPositions.forEach(carNameAndPosition -> {
            System.out.println(createCarInfoString(carNameAndPosition));
        });
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(createWinnersString(winners));
    }

    private static String createCarInfoString(CarNameAndPosition carNameAndPosition) {
        return String.format("%s : %s", carNameAndPosition.getName(), DISTANCE_MARK.repeat(carNameAndPosition.getPosition()));
    }

    private static String createWinnersString(List<String> winners) {
        return String.format("%s%s", String.join(", ", winners), NoticeMessages.WINNERS_MESSAGE);
    }
}
