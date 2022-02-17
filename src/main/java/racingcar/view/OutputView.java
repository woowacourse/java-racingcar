package racingcar.view;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

import java.util.List;

public class OutputView {

    private static final String TRIAL_RESULT = "실행 결과:";
    private static final String POSITION_LOCATION = "-";
    private static final String CAR_POSITION_PARTITION_FORMAT = ":";
    private static final String WINNER_ANNOUNCEMENT = "가 최종 우승했습니다.";
    private static final String WINNER_NAME_DELIMITER = ", ";

    public static void printGameStartMessage() {
        System.out.println(TRIAL_RESULT);
    }

    public static void printCurrentRacingSituation(RacingCars racingCars) {
        List<RacingCar> racingCarList = racingCars.getRacingCars();
        for (RacingCar racingCar : racingCarList) {
            String currentPosition = getCurrentPosition(racingCar);
            System.out.println(racingCar.getName() + CAR_POSITION_PARTITION_FORMAT + currentPosition);
        }
        System.out.println();
    }

    private static String getCurrentPosition(RacingCar racingCar) {
        StringBuilder sb = new StringBuilder();
        int position = racingCar.getPosition();
        for (int i = 0; i < position; i++) {
            sb.append(POSITION_LOCATION);
        }
        return sb.toString();
    }

    public static void printWinners(RacingCars racingCars) {
        List<String> winnersNameList = racingCars.getWinners().getNames();
        String winners = String.join(WINNER_NAME_DELIMITER, winnersNameList);
        System.out.println(winners + WINNER_ANNOUNCEMENT);
    }

}
