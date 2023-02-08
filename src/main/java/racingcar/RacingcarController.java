package racingcar;

import java.util.List;

public class RacingcarController {

    private final CarFactory carFactory;

    public RacingcarController() {
        this.carFactory = new CarFactory();
    }

    public void run(String carNames, int tryCount) {
        List<Car> cars = carFactory.makeCars(carNames);
    }
}
