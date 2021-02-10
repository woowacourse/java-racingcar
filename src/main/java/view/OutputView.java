package view;

import racingCar.Car;
import racingCar.Cars;
import racingCar.Name;

import java.util.List;

public class OutputView {

    public static void showStatus(List<Car> cars) {
        for (Car car : cars) {
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

    public static void showResult(List<Name> winners) {
        System.out.println(String.join(",", winners.toString()) + "가 최종 우승했습니다.");
    }
}
