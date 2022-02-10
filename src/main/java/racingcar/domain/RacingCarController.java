package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.view.InputView;
import racingcar.view.OutPutView;

public class RacingCarController {

    public void run() {
        String[] carNames = InputView.getCarNames();
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        Count count = InputView.getCount();
        OutPutView.printStatusMessage();
        while (count.isPositive()) {
            count.subtract();
            moveCars(cars);
            OutPutView.printStatus(cars);
        }
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move();
        }
    }
}
