package domain;

import java.util.List;

public class RacingGame {

    public List<Car> tryMove(List<Car> cars) {
        for (Car car : cars) {
            if (Rule.judgeMove(Rule.makeRandomNumber()) == 1) {
                car.move();
            }
        }
        return cars;
    }
}
