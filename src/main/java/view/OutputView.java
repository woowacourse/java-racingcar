package view;

import domain.RacingCar;
import domain.RacingCars;

public class OutputView {

    public static void printResultMessage() {
        System.out.println("실행 결과");
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
}
