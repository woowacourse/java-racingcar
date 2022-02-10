package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    public void printRaceResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getCurrentPosition());
        }
    }
}
