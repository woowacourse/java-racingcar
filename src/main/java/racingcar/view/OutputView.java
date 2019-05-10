package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void outputAllTryCarPosition(List<List<Car>> eachTryCars) {
        System.out.println("\n실행 결과");
        for (List<Car> cars : eachTryCars) {
            outputCarPosition(cars);
        }
    }

    private static void outputCarPosition(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car);
        }
        System.out.println();
    }

    public static void outputWinners(List<Car> winners) {
        List<String> winnersName = new ArrayList<>();

        for (Car car : winners) {
            winnersName.add(car.getName());
        }
        System.out.println(String.join(", ", winnersName) + "가 최종 우승했습니다.");
    }
}
