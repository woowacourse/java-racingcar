package racingcar.view;

import racingcar.model.Car;

public class OutputView {
    public static void printPosition(Car car) {
        System.out.print(car.getName() + " ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
