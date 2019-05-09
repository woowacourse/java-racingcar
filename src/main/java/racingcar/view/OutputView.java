package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Winner;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void printCarState(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append("-");
        }
        System.out.println(sb.toString());
    }

    public static void printEmptyLine() {
        System.out.println("");
    }

    public static void printWinners(Winner winner) {
        List<Car> winnersOfRacing = winner.getWinners();
        List<String> winners = new ArrayList<>();
        for (Car winnerOfRacing : winnersOfRacing) {
            winners.add(winnerOfRacing.getName());
        }
        System.out.println(String.join(",", winners) + "가 최종 우승했습니다.");
    }
}
