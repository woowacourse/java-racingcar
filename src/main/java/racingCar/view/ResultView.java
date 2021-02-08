package racingCar.view;

import racingCar.domain.Car;
import racingCar.domain.Cars;

import java.util.List;

public class ResultView {
    public static void showResult(Cars cars) {
        List<String> winnerNames = cars.getWinnerNames();
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }

    public static void showStatus(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + bar(car.getDistance()));
        }
        System.out.println();
    }

    public static String bar(int distance) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
