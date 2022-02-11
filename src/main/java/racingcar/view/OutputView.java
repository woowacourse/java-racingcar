package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RacingRecord;

public class OutputView {
    private static final String NAME_AND_SCORE_DELIMITER = " : ";
    private static final String DRIVE_SCORE_VIEW = "-";

    public static void printRacingRecord(RacingRecord racingRecord) {
        for (Car car : racingRecord.getRacingRecord()) {
            System.out.println(car.getName() + NAME_AND_SCORE_DELIMITER + printDash(car.getPosition()));
        }
        System.out.println();
    }

    private static String printDash(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(DRIVE_SCORE_VIEW);
        }
        return stringBuilder.toString();
    }
}
