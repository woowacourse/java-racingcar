package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RacingResult;

import java.util.List;

public class OutputView {
    public static void printRacingResultTitle() {
        System.out.println("실행 결과");
    }

    public static void printRacingResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : " + car.toString());
        }
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        String winner = String.join(",", winners);

        System.out.println(winner + "가 최종 우승했습니다.");
    }
}
