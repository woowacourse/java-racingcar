package racingcar.view;

import racingcar.domain.car.Car;

import java.util.List;

public class GamePage {

    public static void printResultPage() {
        System.out.println(System.lineSeparator() + "실행 결과");
    }

    public static void printSingleRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.formatSingleRoundInformation());
        }
        System.out.println();
    }

    public static void printFinalResult(String winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
