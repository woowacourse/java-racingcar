package racingcargame.view;

import racingcargame.domain.Car;
import racingcargame.domain.Cars;

import java.util.List;

public class ResultView {
    public static void showResult(Cars cars) {
        List<String> winnerNames = cars.getWinnerNames();
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }

    public static void showStatus(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + createBar(car.getDistance()));
        }
        System.out.println();
    }

    public static String createBar(int distance) {
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            bar.append("-");
        }
        return bar.toString();
    }

    public static void showGameStart() {
        System.out.println("실행 결과");
    }
}
