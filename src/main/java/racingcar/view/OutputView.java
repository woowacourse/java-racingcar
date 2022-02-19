package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.ParticipatedCars;
import racingcar.domain.WinnerNames;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String RACING_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_NAME_DELIMITER = ", ";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String RECORD_DELIMITER = " : ";
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
        return car.getName() + RECORD_DELIMITER + POSITION_TO_STRING.repeat(car.getPosition());
    }

    public static void printWinnerNames(WinnerNames winnerNames) {
        String winners = String.join(WINNER_NAME_DELIMITER, winnerNames.getWinnerNames());
        System.out.println(winners + WINNER_MESSAGE);
    }
}
