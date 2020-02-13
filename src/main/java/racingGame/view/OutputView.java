package racingGame.view;

import racingGame.domain.Car;
import racingGame.domain.Cars;
import racingGame.utils.StringUtil;

import java.util.List;

public class OutputView {
    public static void printCars(Cars cars) {
        for (Car individualCar : cars.getCars()) {
            System.out.println(individualCar.toString());
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        String result = String.join(",", StringUtil.extractWinnersName(winners));

        System.out.println(result + "가 최종 우승했습니다.");
    }
}
