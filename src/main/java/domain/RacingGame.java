package domain;

import java.util.List;
import java.util.Random;

public class RacingGame {

    public List<Car> tryMove(List<Car> cars) {
        for (Car car : cars) {
            car.move(Rule.isMove(makeRandomNumber()));
        }
        return cars;
    }

    public int makeRandomNumber() {
        Random random = new Random();
        return random.nextInt(Rule.BOUND_RULE_NUMBER);
    }
}
