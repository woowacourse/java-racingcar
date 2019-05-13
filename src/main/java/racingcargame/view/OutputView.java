package racingcargame.view;

import racingcargame.model.Car;

import java.util.List;

public class OutputView {

    private static final String WINNER_MESSAGE = "가 최종 우승했습니다";

    public static void printRound(List<Car> carList) {
        carList.forEach(car -> System.out.println(car.toString()));
        System.out.println();
    }

    public static void printGameResult(String winners) {
        System.out.println(winners + WINNER_MESSAGE);
    }
}
