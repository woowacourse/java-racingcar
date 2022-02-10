package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class Output {

    public static void racePrint(List<Car> carList) {
        for (Car car : carList) {
            car.showInfo();
        }
        System.out.println();
    }
}
