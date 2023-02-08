package racingcar;

import java.util.List;

public class RacingcarService {

    public void move(List<Car> cars) {
        for (Car car : cars) {
            car.move(RandomMaker.random());
        }
    }
}
