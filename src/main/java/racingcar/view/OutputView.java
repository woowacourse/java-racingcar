package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.ParticipatedCars;
import racingcar.domain.WinnerNames;

import java.util.List;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String RACING_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_NAME_DELIMITER = ", ";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String STATUS_DELIMITER = " : ";
    private static final String POSITION_TO_STRING = "-";

    public static void printResultMessage() {
        System.out.println(NEW_LINE + RACING_RESULT_MESSAGE);
    }

    public static void printRacingRecords(ParticipatedCars participatedCars) {
        participatedCars.getCars()
                .stream()
                .forEach(car -> System.out.println(getCarRecord(car)));
        System.out.println();
    }

    private static String getCarRecord(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(car.getName()).append(STATUS_DELIMITER);
        for (int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append(POSITION_TO_STRING);
        }
        return stringBuilder.toString();
    }

    public static void printWinnerNames(WinnerNames winnerNames) {
        String winners = String.join(WINNER_NAME_DELIMITER, winnerNames.getWinnerNames());
        System.out.println(winners + WINNER_MESSAGE);
    }
}
