package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.utils.StringUtils;

import java.util.List;

public class OutputView {
    public static void printRounds(int numberOfTrials, Race race) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < numberOfTrials; i++) {
            for (int j = 0; j < race.getNumberOfCars(); j++) {
                printLane(race.startRound());
            }
            System.out.println();
        }
    }

    private static void printLane(Car car) {
        System.out.println(car + " : " + car.drawTrail());
    }

    public static void printWinners(List<Car> winners) {
        String winnerList = winners.toString();
        System.out.println(
                winnerList.substring(1, winnerList.length() - 1)
                + StringUtils.differentiateIGa(winnerList.charAt(winnerList.length() - 2))
                + " 최종 우승했습니다."
        );
    }
}