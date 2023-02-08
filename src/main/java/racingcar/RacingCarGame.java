package racingcar;

import java.util.List;

public class RacingCarGame {

    public void moveCars() {
        List<Car> cars = CarRepository.findAll();
        for (Car car : cars) {
            car.move(new RandomBasedStrategy());
        }
    }
}
