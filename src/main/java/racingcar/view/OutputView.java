package racingcar.view;

import java.util.List;
import racingcar.message.NoticeMessages;
import racingcar.domain.Car;
import racingcar.domain.Winners;

public class OutputView {
    private static final String DISTANCE_MARK = "-";
    private static final String DELIMITER = ", ";
    private static final String WINNER_SENTENCE = "가 최종 우승했습니다.";

    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printStartMessage() {
        System.out.println(NoticeMessages.RUN_RESULT);
    }

    public static void printString(String string) {
        System.out.println(string);
    }

    public static void printWinners(Winners winners) {
        System.out.println(String.join(DELIMITER, winners.getNames()) + WINNER_SENTENCE);
    }

    public static void printCarsStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(getCarStatus(car));
        }
        System.out.println();
    }

    private static String getCarStatus(Car car) {
        String carPositionString = getGaugeBar(car.getPosition());
        return car.getName() + " : " + carPositionString;
    }

    private static String getGaugeBar(int cnt) {
        return DISTANCE_MARK.repeat(Math.max(0, cnt));
    }
}
