package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;

public class OutputView {
    public static void outputAllTryCarPosition(ArrayList<ArrayList<Car>> eachTryCars) {
        System.out.println("\n실행 결과");
        for (ArrayList<Car> cars : eachTryCars) {
            outputCarPosition(cars);
        }
    }

    private static void outputCarPosition(ArrayList<Car> carList) {
        for (Car car : carList) {
            System.out.println(car);
        }
        System.out.println();
    }

    public static void outputWinners(ArrayList<Car> winners) {
        ArrayList<String> winnersName = new ArrayList<>();

        for (Car car : winners) {
            winnersName.add(car.getName());
        }
        System.out.println(String.join(", ", winnersName) + "가 최종 우승했습니다.");
    }
}
