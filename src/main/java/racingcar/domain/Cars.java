package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

import java.util.List;

import static racingcar.Utils.checkMove;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void playTurn() {
        RandomNumberGenerator random = new RandomNumberGenerator();
        cars.forEach(car -> {
            if (checkMove(random.generateNumber())) {
                car.proceed();
            }
        });
    }

    public void printStatus() {

    }
}
