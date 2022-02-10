package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    public static void printCarsPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car);
        }
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }
}
