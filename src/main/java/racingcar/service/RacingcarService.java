package racingcar.service;

import java.util.List;
import racingcar.domain.Car;

public class RacingcarService {
    public void processRound(List<Car> cars) {
        cars.forEach(Car::go);
    }
}
