package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;

public class OutputView {
    public static void outputCarPosition(ArrayList<Car> carList) {
        for (Car car : carList) {
            System.out.println(car);
        }
        System.out.println();
    }
}
