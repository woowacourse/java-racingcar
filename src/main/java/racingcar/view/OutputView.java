package racingcar.view;

import java.util.List;
import racingcar.domain.CarStatusDTO;
import racingcar.domain.RacingRecordDTO;

public class OutputView {
    private static final String RACING_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_NAME_DELIMITER = ", ";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void printRacingRecordsMsg() {
        System.out.println("\n" + RACING_RESULT_MESSAGE);
    }

    public static void printRacingRecords(RacingRecordDTO racingRecords) {
        for (CarStatusDTO racingRecord : racingRecords.getRacingRecord()) {
            System.out.println(buildStatusView(racingRecord));
        }
        System.out.println();
    }

    public static void printWinnerNames(List<String> winnerNames) {
        String winners = String.join(WINNER_NAME_DELIMITER, winnerNames);
        System.out.println(winners + WINNER_MESSAGE);
    }

    private static StringBuilder buildStatusView(CarStatusDTO carStatus) {
        StringBuilder stringBuilder = new StringBuilder(carStatus.getCarName() + " : ");
        for (int i = 0; i < carStatus.getPosition(); i++) {
            stringBuilder.append("-");
        }
        return stringBuilder;
    }
}
