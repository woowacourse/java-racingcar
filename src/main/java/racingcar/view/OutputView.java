package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Winner;

import java.util.List;

public class OutputView {

    public static void printResultStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printMoveResult(List<Car> cars) {
        for(Car car : cars) {
            printCarDistance(car);
        }
        System.out.println();
    }

    public static void printCarDistance(Car car) {
        System.out.print(car.getName() + ": ");
        for (int i = 0; i < car.getPosition(); ++i) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(Winner winner) {
        System.out.println(String.join(",", winner.getWinnerNames()) + "가 우승했습니다.");
    }
}
