package view;

import domain.RacingCar;
import domain.RacingCars;
import java.util.List;

public class OutputView {

    public static void printResultMessage() {
        System.out.println(System.lineSeparator() + "실행 결과");
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
        return String.format("%s : %s", carName, distance);
    }

    private static String makeDistanceInfo(int position) {
        StringBuilder distance = new StringBuilder();

        while (position-- > 0) {
            distance.append("-");
        }

        return distance.toString();
    }

    public static void printWinner(final RacingCars racingCars) {
        System.out.printf("%s가 최종 우승했습니다.%n", makeWinnerInfo(racingCars.getWinnerNames()));
    }

    private static String makeWinnerInfo(List<String> winners) {
        return String.join(", ", winners);
    }
}
