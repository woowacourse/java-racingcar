package view;

import racingCar.Car;
import racingCar.Cars;

import java.util.List;

public class OutputView {

    public static void showStatus() {
        for (Car car : Cars.getCars()) {
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


    public static void showResult() {
        List<String> winners = getWinners(Cars.findMaxDistance());
        System.out.println(String.join(",", winners) + "가 최종 우승했습니다.");
    }

    static List<String> getWinners(int max) {
        List<String> winners = Cars.findWinners(max);
        return winners;
    }


}
