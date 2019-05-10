package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.utils.StringUtils;

import java.util.List;

public class OutputView {
    public static void printRounds(int numOfTrials, Race race) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < numOfTrials; i++) {
            for (int j = 0; j < race.getNumOfCars(); j++) {
                printLane(race.startRound());
            }
            System.out.println();
        }
    }

    private static void printLane(Car car) {
        System.out.println(car + " : " + car.drawTrail());
    }

    public static void printWinners(List<Car> winners) {
        String winnersName = winners.toString();
        System.out.println(
                winnersName.substring(1, winnersName.length() - 1)
                        + StringUtils.differentiateIGa(winnersName.charAt(winnersName.length() - 2))
                        + " 최종 우승했습니다."
        );
    }
}