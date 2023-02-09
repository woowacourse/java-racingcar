package view;

import domain.RacingCar;
import domain.RacingCars;
import java.util.List;

public class OutputView {

    private static final String RACING_CAR_INFO_FORMAT = "%s : %s";
    private static final String WINNER_INFO_FORMAT = "%s가 최종 우승했습니다.%n";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_INFO_DELIMITER = ", ";
    private static final String DISTANCE_PROGRESS_BAR = "-";

    public static void printResultMessage() {
        System.out.println(System.lineSeparator() + RESULT_MESSAGE);
    }

    public static void printScoreBoard(final RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            System.out.println(createRacingCarInfo(racingCar));
        }
        System.out.println();
    }

    private static String createRacingCarInfo(RacingCar racingCar) {
        String carName = racingCar.getName();
        String distance = makeDistanceInfo(racingCar.getPosition());
        return String.format(RACING_CAR_INFO_FORMAT, carName, distance);
    }

    private static String makeDistanceInfo(int position) {
        StringBuilder distance = new StringBuilder();

        while (position-- > 0) {
            distance.append(DISTANCE_PROGRESS_BAR);
        }

        return distance.toString();
    }

    public static void printWinner(final RacingCars racingCars) {
        System.out.printf(WINNER_INFO_FORMAT, makeWinnerInfo(racingCars.getWinnerNames()));
    }

    private static String makeWinnerInfo(List<String> winners) {
        return String.join(WINNER_INFO_DELIMITER, winners);
    }
}
