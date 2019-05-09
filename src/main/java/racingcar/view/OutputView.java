package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Winner;

public class OutputView {
    public static void printCarDistance(Car car) {
        System.out.print(car.getName() + ": ");
        for (int i = 0; i < car.getPosition(); ++i) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(Winner winner) {
        System.out.println(String.join(",", winner.getWinnerNames())+"가 우승했습니다.");
    }
}
