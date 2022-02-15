package racingcar.view;

import java.util.List;
import racingcar.message.NoticeMessages;
import racingcar.model.car.CarInfo;

public class OutputView {
    private static final String DISTANCE_MARK = "-";

    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printStartMessage() {
        System.out.println(NoticeMessages.RUN_RESULT);
    }

    public static void printCurrentCarInfo(List<CarInfo> carInfos) {
        carInfos.forEach(carInfo -> {
            System.out.println(createCarInfoString(carInfo));
        });
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(createWinnersString(winners));
    }

    private static String createCarInfoString(CarInfo carInfo) {
        return String.format("%s : %s", carInfo.getName(), DISTANCE_MARK.repeat(carInfo.getPosition()));
    }

    private static String createWinnersString(List<String> winners) {
        return String.format("%s%s", String.join(", ", winners), NoticeMessages.WINNERS_MESSAGE);
    }
}
