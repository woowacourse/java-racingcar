package racingCar.view;

import java.util.List;
import racingCar.domain.Car;

public class OutputView {

    public static final String SHOW_RACING_GAME_WINNERS = "최종 우승자";
    public static final String RACING_GAME_WINNERS_MESSAGE = "가 최종우승했습니다.";

    public static void printCars(List<Car> cars) {
        cars.forEach(car-> System.out.println(car.toString()));
    }

    public static void printWinners(String winners) {
        System.out.println(SHOW_RACING_GAME_WINNERS);
        System.out.println(winners + RACING_GAME_WINNERS_MESSAGE);
    }
}
