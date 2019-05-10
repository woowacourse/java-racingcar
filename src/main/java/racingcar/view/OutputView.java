package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Race;

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

    public static void printLane(Car car) {
        System.out.println(car + " : " + car.drawTrail());
    }

    public static void printWinners(List<Car> winners) {
        String result = winners.toString().replace("[", "").replace("]", "");
        System.out.println(
                result
                + Hangul.differentiateIGa(result)
                + " 최종 우승했습니다."
        );
    }
}