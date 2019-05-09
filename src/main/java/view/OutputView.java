package view;

import domain.Car;

import java.util.ArrayList;

public class OutputView {

    public static void printPosition(ArrayList<Car> carList) {
        for (Car car : carList) {
            System.out.println(car);
        }
    }

    public static void printWinners(ArrayList<Car> winnerList) {
        ArrayList<String> winnerNames = new ArrayList<>();

        for (Car car : winnerList) {
            winnerNames.add(car.getName());
        }

        System.out.format("%s 이(가) 최종 우승했습니다.\n", String.join(", ", winnerNames));
    }
}
